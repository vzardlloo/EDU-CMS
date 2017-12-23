package com.vzard.mycms.repository;


import com.vzard.mycms.database.Tables;
import com.vzard.mycms.database.tables.interfaces.IStudent;
import com.vzard.mycms.database.tables.pojos.Student;
import com.vzard.mycms.error.ErrorException;
import com.vzard.mycms.model.dto.CourseWithGrade;
import org.jooq.DSLContext;
import org.jooq.Record10;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.vzard.mycms.database.Tables.COURSE;
import static com.vzard.mycms.database.Tables.GRADE;

@Service
public class StudentRepository {

    @Autowired
    @Qualifier("mycms")
    DSLContext dsl;

    public IStudent getStudentByNumber(String number){
        if (null == number){
            throw new ErrorException("param error",500);
        }

        IStudent iStudent = dsl.select().from(Tables.STUDENT)
                        .where(Tables.STUDENT.NUMBER.eq(number))
                        .fetchOneInto(IStudent.class);
        if (null == iStudent){
            throw new ErrorException("not found",404);
        }
        return iStudent;
    }

    public List<IStudent> getStudentList(){

        return dsl.select().from(Tables.STUDENT)
                //.where(Tables.STUDENT.NUMBER)
                .fetchInto(IStudent.class);
    }



    public IStudent addStudentInfo(Student student){
        if(null == student){
            throw new ErrorException("param error",500);
        }else if (isStudentExist(student.getNumber())){
            throw new ErrorException("already exist!",500);
        }

        dsl.insertInto(Tables.STUDENT)
                .columns(Tables.STUDENT.NUMBER,Tables.STUDENT.NAME,Tables.STUDENT.PASSWORD
                ,Tables.STUDENT.GENDER,Tables.STUDENT.BIRTHDAY,Tables.STUDENT.CLBUM
                ,Tables.STUDENT.ACADEMY,Tables.STUDENT.CREATED_AT,Tables.STUDENT.UPDATED_AT)
                .values(student.getNumber(),student.getName(),student.getPassword()
                ,student.getGender(),student.getBirthday(),student.getClbum()
                ,student.getAcademy(),new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()))
                .execute();


        IStudent iStudent = getStudentByNumber(student.getNumber());
        if (null == iStudent){
            throw new ErrorException("insert failed",404);
        }

        return iStudent;
    }

    public IStudent updateStudentInfo(Student student){
        if (null == student) {
            throw new ErrorException("param error", 500);
        }else if(!isStudentExist(student.getNumber())){
            throw new ErrorException("not exist!",404);
        }

        dsl.update(Tables.STUDENT)
                .set(Tables.STUDENT.BIRTHDAY,student.getBirthday())
                .set(Tables.STUDENT.PASSWORD,student.getPassword())
                .set(Tables.STUDENT.CLBUM,student.getClbum())
                .set(Tables.STUDENT.ACADEMY,student.getAcademy())
                .set(Tables.STUDENT.GENDER,student.getGender())
                .set(Tables.STUDENT.UPDATED_AT,new Timestamp(System.currentTimeMillis()))
                .where(Tables.STUDENT.NUMBER.eq(student.getNumber()))
                .execute();

        return getStudentByNumber(student.getNumber());

    }


    public void deleteStudentInfo(String num){
        if (null != num) {
            throw new ErrorException("param error", 500);
        }else if(!isStudentExist(num)){
            throw new ErrorException("not exist!",404);
        }

        dsl.delete(Tables.STUDENT)
                .where(Tables.STUDENT.NUMBER.eq(num))
                .execute();

        if (isStudentExist(num)){
            throw new ErrorException("delete failed",500);
        }

    }


    /**
     * 分页获取课程信息
     * @param studentNum
     * @param start
     * @param offset
     * @return
     */
    public List<CourseWithGrade> getChoosedCourse(String studentNum, int start, int offset){


        Result<Record10<String,String,String,String,String,String,String,String,String,String>> results = dsl.select(COURSE.NUMBER, COURSE.NAME, COURSE.CREDIT
                , COURSE.PERIOD, COURSE.TEACHER, COURSE.TIME
                , COURSE.CLASSROOM,Tables.GRADE.PAPER_GRADE,Tables.GRADE.PACIFIC_GRADE
                ,Tables.GRADE.OVERALL_GRADE)
                .from(COURSE)
                .leftJoin(Tables.GRADE)
                .on(COURSE.NUMBER.eq(Tables.STUDENT_COURSE.COURSE_NUM))
                .where(COURSE.NUMBER.in(
                        dsl.select(Tables.STUDENT_COURSE.COURSE_NUM)
                        .from(Tables.STUDENT_COURSE)
                        .where(Tables.STUDENT_COURSE.STUDENT_NUM.eq(studentNum))

                )).limit(start,offset).fetch();
        List<CourseWithGrade> courseWithGradeDtoList = new ArrayList<>();
        for (Record10<String,String,String,String,String,String,String,String,String,String> result : results){
            CourseWithGrade course = new CourseWithGrade();
            course.setNumber(result.getValue(COURSE.NUMBER));
            course.setName(result.getValue(COURSE.NAME));
            course.setCredit(result.getValue(COURSE.CREDIT));
            course.setTime(result.getValue(COURSE.TIME));
            course.setClassroom(result.getValue(COURSE.CLASSROOM));
            course.setTeacher(result.getValue(COURSE.TEACHER));
            course.setPeriod(result.getValue(COURSE.PERIOD));
            course.setPaperGrade(result.getValue(GRADE.PAPER_GRADE));
            course.setPacificGrade(result.getValue(GRADE.PACIFIC_GRADE));
            course.setOverallGrade(result.getValue(GRADE.OVERALL_GRADE));

            courseWithGradeDtoList.add(course);

        }


        return courseWithGradeDtoList;

    }


    //=======util=======
    private Boolean isStudentExist(String num){

        if (null != getStudentByNumber(num)){
            return true;
        }
        return false;
    }







}

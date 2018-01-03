package com.vzard.mycms.repository;


import com.vzard.mycms.database.Tables;
import com.vzard.mycms.database.tables.interfaces.IStudent;
import com.vzard.mycms.database.tables.pojos.Course;
import com.vzard.mycms.database.tables.pojos.Grade;
import com.vzard.mycms.database.tables.pojos.Student;
import com.vzard.mycms.error.ErrorException;
import com.vzard.mycms.model.dto.CourseWithGrade;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.vzard.mycms.database.Tables.*;

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


    public void deleteStudentInfo(@NotNull String num){
        if(!isStudentExist(num)){
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

       List<CourseWithGrade> courseWithGradeList = new ArrayList<>();

        //某学生所选的课程号列表
       List<String> courseNumList = dsl.select(STUDENT_COURSE.COURSE_NUM)
               .from(STUDENT_COURSE)
               .where(STUDENT_COURSE.STUDENT_NUM.eq(studentNum))
               .fetchInto(String.class);

       for (String currentCourseNum : courseNumList){

           Course course = dsl.select()
                   .from(COURSE)
                   .where(COURSE.NUMBER.eq(currentCourseNum))
                   .fetchOneInto(Course.class);


           Grade grade = dsl.select()
                   .from(GRADE)
                   .where(GRADE.COURSE_NUM.eq(currentCourseNum).and(GRADE.STUDENT_NUM.eq(studentNum)))
                   .fetchOneInto(Grade.class);


           CourseWithGrade courseWithGrade = new CourseWithGrade();

           if (null != course) {
               courseWithGrade.setName(course.getName());
               courseWithGrade.setNumber(course.getNumber());
               courseWithGrade.setCredit(course.getCredit());
               courseWithGrade.setPeriod(course.getPeriod());
               courseWithGrade.setClassroom(course.getClassroom());
               courseWithGrade.setTime(course.getTime());
               courseWithGrade.setTeacher(course.getTeacher());
           }

           if (null != grade) {
               courseWithGrade.setPacificGrade(grade.getPacificGrade());
               courseWithGrade.setPaperGrade(grade.getPaperGrade());
               courseWithGrade.setOverallGrade(grade.getOverallGrade());
           }else {
               courseWithGrade.setPacificGrade("成绩未公布");
               courseWithGrade.setPaperGrade("成绩未公布");
               courseWithGrade.setOverallGrade("成绩未公布");
           }
           courseWithGradeList.add(courseWithGrade);

       }



       return courseWithGradeList;

    }


    //=======util=======
    private Boolean isStudentExist(String num){

        if (null != getStudentByNumber(num)){
            return true;
        }
        return false;
    }







}

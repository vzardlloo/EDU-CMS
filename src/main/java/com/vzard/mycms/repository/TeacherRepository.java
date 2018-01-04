package com.vzard.mycms.repository;


import com.vzard.mycms.database.Tables;
import com.vzard.mycms.database.tables.interfaces.ITeacher;
import com.vzard.mycms.database.tables.pojos.Teacher;
import com.vzard.mycms.error.ErrorException;
import com.vzard.mycms.model.dto.StudentWithGrade;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.vzard.mycms.database.Tables.*;

@Service
public class TeacherRepository {

    @Autowired
    @Qualifier("mycms")
    DSLContext dsl;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public ITeacher getTeacherByNumber(String num){
        if (null == num){
            throw new ErrorException("param error",500);
        }

        return dsl.select().from(Tables.TEACHER)
                .where(Tables.TEACHER.NUMBER.eq(num))
                .fetchOneInto(ITeacher.class);
    }


    public List<ITeacher> getTeacherList(){

        return dsl.select().from(Tables.TEACHER)
                //.where(Tables.TEACHER.NUMBER.eq(num))
                .fetchInto(ITeacher.class);
    }


    public ITeacher addTeacherInfo(Teacher teacher){
        if (null == teacher){
            throw new ErrorException("param error",500);
        }else if(isTeacherExist(teacher.getNumber())){
            throw new ErrorException("already exist",404);
        }

        dsl.insertInto(Tables.TEACHER)
                .columns(Tables.TEACHER.NUMBER,Tables.TEACHER.NAME,Tables.TEACHER.PASSWORD,Tables.TEACHER.GENDER
                ,Tables.TEACHER.OFFICE,Tables.TEACHER.ACADEMY,Tables.TEACHER.CREATED_AT,Tables.TEACHER.UPDATE_AT)
                .values(teacher.getNumber(),teacher.getName(),teacher.getPassword(),teacher.getGender()
                ,teacher.getOffice(),teacher.getAcademy(),new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()))
                .execute();

        ITeacher iTeacher = getTeacherByNumber(teacher.getNumber());
        if (null == iTeacher){
            throw new ErrorException("insert failed",500);
        }
        return iTeacher;

    }


    public ITeacher updateTeacherInfo(Teacher teacher){
        if (null == teacher){
            throw new ErrorException("param error",500);
        }else if(!isTeacherExist(teacher.getNumber())){
            throw new ErrorException(" not exist",404);
        }

        dsl.update(Tables.TEACHER)
                .set(Tables.TEACHER.NAME,teacher.getName())
                .set(Tables.TEACHER.PASSWORD,teacher.getPassword())
                .set(Tables.TEACHER.OFFICE,teacher.getOffice())
                .set(Tables.TEACHER.ACADEMY,teacher.getAcademy())
                .set(Tables.TEACHER.UPDATE_AT,new Timestamp(System.currentTimeMillis()))
                .where(Tables.TEACHER.NUMBER.eq(teacher.getNumber()))
                .execute();


        return getTeacherByNumber(teacher.getNumber());

    }






    public void deleteTeacherInfo(String num){
        if (null == num){
            throw new ErrorException("param error",500);
        }else if(!isTeacherExist(num)){
            throw new ErrorException(" not exist",404);
        }
        dsl.delete(Tables.TEACHER)
                .where(Tables.TEACHER.NUMBER.eq(num))
                .execute();
        if (isTeacherExist(num)){
            throw new ErrorException("delete error",500);
        }
    }


    public List<StudentWithGrade> getStudentWithGrade(@NotNull String teacherNum) {
        logger.info(teacherNum);
        //studentWithGrade 的列表
        List<StudentWithGrade> studentWithGrades = new ArrayList<>();
        //获取该教师发布的所有课程编号
        List<String> courseNumList = getCourseNumListByTeacherNum(teacherNum);
        logger.info(courseNumList.toString());
        //选择某门课的所有学生学号
        List<List<String>> studentNumLists = new ArrayList<>();
        for (String courseNum : courseNumList) {
            List<String> studentNums = getStudentNumListByCourseNum(courseNum);
            if (null != studentNums) {
                studentNumLists.add(studentNums);
            }
        }

        List<String> studentNumList = studentNumLists.stream().flatMap(Collection::stream)
                .collect(Collectors.toList());
        logger.info(studentNumList.toString());

        List<StudentWithGrade> studentWithGradeList = new ArrayList<>();
        for (String studentNum : studentNumList) {
            for (String courseNum : courseNumList) {
                StudentWithGrade studentWithGrade = getStudentWithGradeByStudentNum(studentNum, courseNum);

                if (null != studentWithGrade) {
                    studentWithGradeList.add(studentWithGrade);
                }
            }
        }

        return studentWithGradeList.stream().distinct().collect(Collectors.toList());

    }


    /**
     * 根据学号获取StudentWithGrade
     *
     * @param studentNum
     * @return
     */
    private StudentWithGrade getStudentWithGradeByStudentNum(@NotNull String studentNum, @NotNull String courseNum) {
        StudentWithGrade studentWithGrade = dsl.select(STUDENT.NUMBER, STUDENT.NAME,GRADE.COURSE_NUM,GRADE.COURSE_NAME,
                GRADE.PAPER_GRADE, GRADE.PACIFIC_GRADE, GRADE.OVERALL_GRADE)
                .from(STUDENT)
                .leftJoin(GRADE)
                .on(STUDENT.NUMBER.eq(GRADE.STUDENT_NUM))
                .where(STUDENT.NUMBER.eq(studentNum))
                .and(GRADE.COURSE_NUM.eq(courseNum))
                .fetchOneInto(StudentWithGrade.class);

        return studentWithGrade;
    }

    /**
     * 根据课程号获取选择选择该课程的学生编号列表
     *
     * @param num
     * @return
     */
    private List<String> getStudentNumListByCourseNum(@NotNull String num) {
        List<String> studentNumList = dsl.select(STUDENT_COURSE.STUDENT_NUM)
                .from(Tables.STUDENT_COURSE)
                .where(Tables.STUDENT_COURSE.COURSE_NUM.eq(num))
                .fetchInto(String.class);
        if (null == studentNumList) {
            throw new ErrorException("not found", 404);
        }
        return studentNumList;
    }

    /**
     * 根据老师工号获取该老师发布所有课程编号
     *
     * @param num
     * @return
     */
    private List<String> getCourseNumListByTeacherNum(@NotNull String num) {
        List<String> courseNumList = dsl.select(Tables.COURSE.NUMBER)
                .from(Tables.COURSE)
                .where(Tables.COURSE.TECHER_NUM.eq(num))
                .fetchInto(String.class);
        if (null == courseNumList) {
            throw new ErrorException("not found", 404);
        }
        return courseNumList;
    }

    /**
     * 根据教师工号获取教师姓名
     *
     * @param num
     * @return
     */
    private String getTeacherNameByNum(@NotNull String num) {

        ITeacher iTeacher = dsl.select()
                .from(Tables.TEACHER)
                .where(Tables.TEACHER.NAME.eq(num))
                .fetchOneInto(ITeacher.class);
        if (null == iTeacher) {
            throw new ErrorException("not found", 404);
        }

        return iTeacher.getName();
    }










    //=======util======
    private Boolean isTeacherExist(String num){

        if (null != getTeacherByNumber(num)){
            return true;
        }
        return false;
    }


}

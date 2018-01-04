package com.vzard.mycms.repository;


import com.vzard.mycms.database.Tables;
import com.vzard.mycms.database.tables.interfaces.IStudentCourse;
import com.vzard.mycms.database.tables.pojos.StudentCourse;
import com.vzard.mycms.error.ErrorException;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


@Service
public class StudentCourseRepository {


    @Autowired
    @Qualifier("mycms")
    DSLContext dsl;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    //根据studentName 查找 course
    public IStudentCourse getStudentCourseMap(@NotNull String studentNum, @NotNull String courseNum) {

        IStudentCourse iStudentCourse = dsl.select()
                .from(Tables.STUDENT_COURSE)
                .where(Tables.STUDENT_COURSE.STUDENT_NUM
                        .eq(studentNum)
                        .and(Tables.STUDENT_COURSE.COURSE_NUM.eq(courseNum)))
                .fetchOneInto(IStudentCourse.class);
        return iStudentCourse;
    }

    public IStudentCourse addStudentCourseMap(@NotNull String studentNumber, String courseNumber) {

            dsl.insertInto(Tables.STUDENT_COURSE)
                    .columns(Tables.STUDENT_COURSE.STUDENT_NUM, Tables.STUDENT_COURSE.COURSE_NUM,
                            Tables.STUDENT_COURSE.CREATED_AT, Tables.STUDENT_COURSE.UPDATED_AT)
                    .values(studentNumber, courseNumber,
                            new Timestamp(System.currentTimeMillis()),
                            new Timestamp(System.currentTimeMillis()))
                    .execute();

        IStudentCourse iStudentCourse = getStudentCourseMap(studentNumber, courseNumber);

        if (null == iStudentCourse){
            throw new ErrorException("insert error",500);
        }

        return  iStudentCourse;
    }


    public IStudentCourse updateStudentCourseMap(StudentCourse studentCourse){
        if (null != studentCourse){
            throw new ErrorException("param error",500);
        } else if (!isStudentCourseMapExist(studentCourse.getStudentNum(), studentCourse.getCourseNum())) {
            throw new ErrorException("not exist",500);
        }

        dsl.update(Tables.STUDENT_COURSE)
                .set(Tables.STUDENT_COURSE.STUDENT_NUM,studentCourse.getStudentNum())
                .set(Tables.STUDENT_COURSE.COURSE_NUM,studentCourse.getCourseNum())
                .set(Tables.STUDENT_COURSE.UPDATED_AT,new Timestamp(System.currentTimeMillis()))
                .execute();

        IStudentCourse iStudentCourse = getStudentCourseMap(studentCourse.getStudentNum(), studentCourse.getCourseNum());

        return iStudentCourse;
    }

    public void deleteStudentCourseMap(@NotNull String studentNum, String couserNum) {

        if (!isStudentCourseMapExist(studentNum, couserNum)) {
            throw new ErrorException("未选择该课程！", 500);

        }

        dsl.delete(Tables.STUDENT_COURSE)
                .where(Tables.STUDENT_COURSE.STUDENT_NUM.eq(studentNum)
                .and(Tables.STUDENT_COURSE.COURSE_NUM.eq(couserNum)))
                .execute();
        if (isStudentCourseMapExist(studentNum,couserNum)){
            throw new ErrorException("delete error",500);
        }

    }



    //=========util======//
//    private Boolean isStudentCourseMapExist(String num){
//        if (null == getStudentCourseMap(num)) {
//            return false;
//        }
//        return true;
//    }

    private Boolean isStudentCourseMapExist(@NotNull String studentNum, @NotNull String courseNum) {

        IStudentCourse iStudentCourse = dsl.select()
                                        .from(Tables.STUDENT_COURSE)
                                        .where(Tables.STUDENT_COURSE.STUDENT_NUM
                                        .eq(studentNum)
                                        .and(Tables.STUDENT_COURSE.COURSE_NUM.eq(courseNum)))
                                        .fetchOneInto(IStudentCourse.class);
        //logger.info(iStudentCourse.toString());
        if (null == iStudentCourse) {
            return false;
        }
        return true;
    }




}

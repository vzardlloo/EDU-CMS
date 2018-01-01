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
    public IStudentCourse getStudentCourseMap(@NotNull String studentNum) {


        return dsl.select()
                .from(Tables.STUDENT_COURSE)
                .where(Tables.STUDENT_COURSE.STUDENT_NUM.eq(studentNum))
                .fetchOneInto(IStudentCourse.class);
    }

    public IStudentCourse addStudentCourseMap(StudentCourse studentCourse){
        logger.info(studentCourse.getStudentNum().toString());
        if (null == studentCourse){
            throw new ErrorException("param error",400);
        }

            dsl.insertInto(Tables.STUDENT_COURSE)
                    .columns(Tables.STUDENT_COURSE.STUDENT_NUM, Tables.STUDENT_COURSE.COURSE_NUM,
                            Tables.STUDENT_COURSE.CREATED_AT, Tables.STUDENT_COURSE.UPDATED_AT)
                    .values(studentCourse.getStudentNum(), studentCourse.getCourseNum(),
                            new Timestamp(System.currentTimeMillis()),
                            new Timestamp(System.currentTimeMillis()))
                    .execute();

        IStudentCourse iStudentCourse = getStudentCourseMap(studentCourse.getStudentNum());
        logger.info(studentCourse.getStudentNum());
        logger.info(iStudentCourse.toString());
        if (null == iStudentCourse){
            throw new ErrorException("insert error",500);
        }

        return  iStudentCourse;
    }


    public IStudentCourse updateStudentCourseMap(StudentCourse studentCourse){
        if (null != studentCourse){
            throw new ErrorException("param error",500);
        }else if (!isStudentCourseMapExist(studentCourse.getStudentNum())){
            throw new ErrorException("not exist",500);
        }

        dsl.update(Tables.STUDENT_COURSE)
                .set(Tables.STUDENT_COURSE.STUDENT_NUM,studentCourse.getStudentNum())
                .set(Tables.STUDENT_COURSE.COURSE_NUM,studentCourse.getCourseNum())
                .set(Tables.STUDENT_COURSE.UPDATED_AT,new Timestamp(System.currentTimeMillis()))
                .execute();

        IStudentCourse iStudentCourse = getStudentCourseMap(studentCourse.getStudentNum());

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
    private Boolean isStudentCourseMapExist(String num){
        if (null == getStudentCourseMap(num)) {
            return false;
        }
        return true;
    }

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

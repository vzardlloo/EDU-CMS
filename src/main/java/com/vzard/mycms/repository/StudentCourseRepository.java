package com.vzard.mycms.repository;


import com.vzard.mycms.database.Tables;
import com.vzard.mycms.database.tables.interfaces.IStudentCourse;
import com.vzard.mycms.database.tables.pojos.StudentCourse;
import com.vzard.mycms.error.ErrorException;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;


@Service
public class StudentCourseRepository {


    @Autowired
    @Qualifier("mycms")
    DSLContext dsl;


    //根据studentName 查找 course
    public IStudentCourse getStudentCourseMap(String studentNum){
        if (null == studentNum){
            throw new ErrorException("param error",400);
        }

        return dsl.select()
                .from(Tables.STUDENT_COURSE)
                .where(Tables.STUDENT_COURSE.COURSE_NUM.eq(studentNum))
                .fetchOneInto(IStudentCourse.class);
    }

    public IStudentCourse addStudentCourseMap(StudentCourse studentCourse){
        if (null == studentCourse){
            throw new ErrorException("param error",400);
        }else if (isStudentCourseMapExist(studentCourse.getStudentNum())){
            throw new ErrorException("already exist",500);
        }

        dsl.insertInto(Tables.STUDENT_COURSE)
                .columns(Tables.STUDENT_COURSE.STUDENT_NUM,Tables.STUDENT_COURSE.COURSE_NUM,
                        Tables.STUDENT_COURSE.CREATED_AT,Tables.STUDENT_COURSE.UPDATED_AT)
                .values(studentCourse.getStudentNum(),studentCourse.getCourseNum(),
                        new Timestamp(System.currentTimeMillis()),
                        new Timestamp(System.currentTimeMillis()))
                .execute();
        IStudentCourse iStudentCourse = getStudentCourseMap(studentCourse.getStudentNum());
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

    public void deleteStudentCourseMap(String studentNum,String couserNum){
        if (null == couserNum){
            throw new ErrorException("param error",500);
        }else if (!isStudentCourseMapExist(studentNum,couserNum)){
            throw new ErrorException("not exist",500);
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
        if (null != getStudentCourseMap(num)){
            return true;
        }
        return false;
    }

    private Boolean isStudentCourseMapExist(String studentNum,String courseNum){
        if (null == studentNum || null == courseNum){
            throw new ErrorException("param error",400);
        }
        IStudentCourse iStudentCourse = dsl.select()
                                        .from(Tables.STUDENT_COURSE)
                                        .where(Tables.STUDENT_COURSE.STUDENT_NUM
                                        .eq(studentNum)
                                        .and(Tables.STUDENT_COURSE.COURSE_NUM.eq(courseNum)))
                                        .fetchOneInto(IStudentCourse.class);

        if (null != iStudentCourse){
            return true;
        }
        return false;
    }




}

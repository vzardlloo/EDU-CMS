package com.vzard.mycms.repository;


import com.vzard.mycms.database.Tables;
import com.vzard.mycms.database.tables.interfaces.ITeacherCourse;
import com.vzard.mycms.error.ErrorException;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Service
public class TeacherCourseRepository {

    @Autowired
    @Qualifier("mycms")
    DSLContext dsl;

    public ITeacherCourse getTeacherCourseMap(@NotNull String teacherNumber, @NotNull String courseNumber) {
        ITeacherCourse iTeacherCourse = dsl.select()
                .from(Tables.TEACHER_COURSE)
                .where(Tables.TEACHER_COURSE.COURSE_NUM.eq(courseNumber))
                .and(Tables.TEACHER_COURSE.TEACHER_NUM.eq(teacherNumber))
                .fetchOneInto(ITeacherCourse.class);
        return iTeacherCourse;
    }


    public ITeacherCourse addTeacherCourseMap(@NotNull String teacherNumber, @NotNull String courseNumber) {
        if (null != getTeacherCourseMap(teacherNumber, courseNumber)) {
            throw new ErrorException("alread exist", 500);
        }

        dsl.insertInto(Tables.TEACHER_COURSE)
                .columns(Tables.TEACHER_COURSE.TEACHER_NUM, Tables.TEACHER_COURSE.COURSE_NUM,
                        Tables.TEACHER_COURSE.CREATED_AT, Tables.TEACHER_COURSE.UPDATED_AT)
                .values(teacherNumber, courseNumber, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()))
                .execute();
        ITeacherCourse iTeacherCourse = getTeacherCourseMap(teacherNumber, courseNumber);
        if (null == iTeacherCourse) {
            throw new ErrorException("insert faild", 500);

        }

        return iTeacherCourse;
    }


}

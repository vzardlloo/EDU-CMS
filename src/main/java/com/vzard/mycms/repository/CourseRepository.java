package com.vzard.mycms.repository;


import com.vzard.mycms.database.Tables;
import com.vzard.mycms.database.tables.interfaces.ICourse;
import com.vzard.mycms.database.tables.pojos.Course;
import com.vzard.mycms.error.ErrorException;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.sql.Timestamp;
import java.util.List;

import static com.vzard.mycms.database.Tables.COURSE;

public class CourseRepository {

    @Autowired
    @Qualifier("mycms")
    DSLContext dsl;

    public ICourse getCourseByNum(Long num){
        if (null == num){
            throw new ErrorException("param error",500);
        }
        return dsl.select()
                .from(COURSE)
                .where(COURSE.NUMBER.eq(num))
                .fetchOneInto(ICourse.class);
    }

    public List<ICourse> getCourseByNum(){

        return dsl.select()
                .from(COURSE)
                //.where(COURSE.NUMBER.eq(num))
                .fetchInto(ICourse.class);
    }




    public ICourse addCourse(Course course){
        if(null == course){
            throw new ErrorException("param error",500);
        }else if (isCourseExist(course.getNumber())){
            throw new ErrorException("already exist",500);
        }

        dsl.insertInto(COURSE)
                .columns(COURSE.NUMBER,COURSE.NAME,COURSE.CREDIT,COURSE.PERIOD,COURSE.TIME,
                        COURSE.TEACHER,COURSE.CLASSROOM,COURSE.MAX_CHOOSED,COURSE.HAS_CHOOSED,
                        COURSE.CREATED_AT,COURSE.UPDATED_AT)
                .values(course.getNumber(),course.getName(),course.getCredit(),course.getPeriod(),course.getTime(),
                        course.getTeacher(),course.getClassroom(),course.getMaxChoosed(),course.getHasChoosed(),
                        new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()))
                .execute();

        ICourse iCourse = getCourseByNum(course.getNumber());
        if (null == iCourse){
            throw new ErrorException("insert error",500);
        }

        return iCourse;

    }


    public ICourse updateCourse(Course course){
        if (null == course){
            throw new ErrorException("param error",500);
        }else if (!isCourseExist(course.getNumber())){
            throw new ErrorException("not exist",500);
        }

        dsl.update(COURSE)
                .set(COURSE.NAME,course.getName())
                .set(COURSE.CREDIT,course.getCredit())
                .set(COURSE.PERIOD,course.getPeriod())
                .set(COURSE.TIME,course.getTime())
                .set(COURSE.CLASSROOM,course.getClassroom())
                .set(COURSE.MAX_CHOOSED,course.getMaxChoosed())
                .set(COURSE.UPDATED_AT,course.getUpdatedAt())
                .execute();
        return getCourseByNum(course.getNumber());
    }


    public void deleteCourse(Long num){
        if (null == num){
            throw new ErrorException("param error",500);
        }else if (!isCourseExist(num)){
            throw new ErrorException("not exsit",500);
        }

        dsl.delete(COURSE)
                .where(COURSE.NUMBER.eq(num))
                .execute();
        if (isCourseExist(num)){
            throw new ErrorException("delete error",500);
        }

    }



    //=======util=====
    private Boolean isCourseExist(Long num){
        if (null != getCourseByNum(num)){
            return true;
        }
        return false;
    }

}

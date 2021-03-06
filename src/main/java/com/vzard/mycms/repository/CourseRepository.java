package com.vzard.mycms.repository;


import com.vzard.mycms.database.tables.interfaces.ICourse;
import com.vzard.mycms.database.tables.pojos.Course;
import com.vzard.mycms.error.ErrorException;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

import static com.vzard.mycms.database.Tables.COURSE;


@Service
public class CourseRepository {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("mycms")
    DSLContext dsl;

    public ICourse getCourseByNum(String num){
        if (null == num){
            throw new ErrorException("param error",500);
        }
        return dsl.select()
                .from(COURSE)
                .where(COURSE.NUMBER.eq(num))
                .fetchOneInto(ICourse.class);
    }

    public List<ICourse> getCourseByTeacher(String name){

        return dsl.select()
                .from(COURSE)
                .where(COURSE.TEACHER.eq(name))
                .fetchInto(ICourse.class);
    }

    public List<ICourse> getCourseList(){
        return dsl.select()
                .from(COURSE)
                //.limit(page, limit)
                .fetchInto(ICourse.class);
    }




    public ICourse addCourse(Course course){
        logger.info(course.toString());
        if(null == course){
            throw new ErrorException("param error",500);
        }

        dsl.insertInto(COURSE)
                .columns(COURSE.NUMBER,COURSE.NAME,COURSE.CREDIT,COURSE.PERIOD,COURSE.TIME,
                        COURSE.TECHER_NUM, COURSE.TEACHER, COURSE.CLASSROOM, COURSE.MAX_CHOOSED, COURSE.HAS_CHOOSED,
                        COURSE.CREATED_AT,COURSE.UPDATED_AT)
                .values(course.getNumber(),course.getName(),course.getCredit(),course.getPeriod(),course.getTime(),
                        course.getTecherNum(), course.getTeacher(), course.getClassroom(), course.getMaxChoosed(), course.getHasChoosed(),
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

    /**
     * 更新某个课程的已选人数
     *
     * @param courseNum
     */
    public void updateHasChoosed(String courseNum, Long hasChoosed) {
        dsl.update(COURSE)
                .set(COURSE.HAS_CHOOSED, hasChoosed)
                .where(COURSE.NUMBER.eq(courseNum))
                .execute();
    }


    public void deleteCourse(String num){
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
    private Boolean isCourseExist(String num){
        if (null != getCourseByNum(num)){
            return true;
        }
        return false;
    }

}

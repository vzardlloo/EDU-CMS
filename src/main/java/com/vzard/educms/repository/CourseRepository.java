package com.vzard.educms.repository;

import com.vzard.educms.constant.ErrorConstant;
import com.vzard.educms.database.Tables;


import com.vzard.educms.database.tables.interfaces.ICourse;

import com.vzard.educms.database.tables.pojos.Course;
import com.vzard.educms.error.EduErrorException;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectConditionStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vzard
 * Date: 2017/11/13
 * Time: 13:02
 * To change this template use File | Settings | File Templates.
 * Description:
 **/
@Service
public class CourseRepository {

    @Autowired
    @Qualifier("edu")
    DSLContext dsl;


    Logger logger = LoggerFactory.getLogger(CourseRepository.class);

    public ICourse getCourseInfoByNumber(String number){

        return dsl.select()
                .from(Tables.COURSE)
                .where(Tables.COURSE.NUMBER.eq(number)).fetchOneInto(ICourse.class);

    }

    public List<ICourse> getCourseInfoByStudentNumber(String number){
        logger.info("repository...");

        SelectConditionStep<Record> step =  dsl.select()
                .from(Tables.COURSE)
                .where(Tables.COURSE.NUMBER.in(
                        dsl.select(Tables.STUDENT_COURSE.COURSE_NUMBER).from(Tables.STUDENT_COURSE)
                            .where(Tables.STUDENT_COURSE.STUDENT_NUMBER.eq(number))));
        return step.orderBy(Tables.COURSE.NUMBER.desc()).fetchInto(ICourse.class);
    }


    public ICourse addCourseInfo(Course course){

        if (isCourseExist(course.getNumber())){
            throw new EduErrorException(ErrorConstant.ERROR_MSG_USER_EXIST_ERROR,ErrorConstant.ERROR_CODE_USER_NOT_FOUND);
        }

        dsl.insertInto(Tables.COURSE)
                .columns(Tables.COURSE.NUMBER,Tables.COURSE.NAME,Tables.COURSE.CREDIT,
                        Tables.COURSE.PERIED,Tables.COURSE.CLASSROOM,Tables.COURSE.COURSE_TIME,
                        Tables.COURSE.MAX_CHOOSED,Tables.COURSE.HAS_CHOOSED,Tables.COURSE.GRADE,
                        Tables.COURSE.PACIFIC_GRADE,Tables.COURSE.GENERAL_GRADE)
                .values(course.getNumber(),course.getName(),course.getCredit(),
                        course.getPeried(),course.getClassroom(),course.getCourseTime(),
                        course.getMaxChoosed(),course.getHasChoosed(),course.getGrade(),
                        course.getPacificGrade(),course.getGeneralGrade())
                .execute();

        return getCourseInfoByNumber(course.getNumber());

    }


    public ICourse updateCourseInfo(Course course){

        if (!isCourseExist(course.getNumber())){
            throw new EduErrorException(ErrorConstant.ERROR_MSG_USER_NOT_FOUND,ErrorConstant.ERROR_CODE_USER_NOT_FOUND);
        }

        dsl.update(Tables.COURSE)
                .set(Tables.COURSE.NAME,course.getName())
                .set(Tables.COURSE.CREDIT,course.getCredit())
                .set(Tables.COURSE.PERIED,course.getPeried())
                .set(Tables.COURSE.CLASSROOM,course.getClassroom())
                .set(Tables.COURSE.COURSE_TIME,course.getCourseTime())
                .set(Tables.COURSE.MAX_CHOOSED,course.getMaxChoosed())
                .set(Tables.COURSE.HAS_CHOOSED,course.getMaxChoosed())
                .set(Tables.COURSE.GRADE,course.getGrade())
                .set(Tables.COURSE.PACIFIC_GRADE,course.getPacificGrade())
                .set(Tables.COURSE.GENERAL_GRADE,course.getGeneralGrade())
                .where(Tables.TEACHER.NUMBER.eq(course.getNumber()))
                .execute();

        return getCourseInfoByNumber(course.getNumber());

    }



    public void deleteCourseInfo(String number){

        if (!isCourseExist(number)){
            throw new EduErrorException(ErrorConstant.ERROR_MSG_USER_NOT_FOUND,ErrorConstant.ERROR_CODE_USER_NOT_FOUND);
        }

        dsl.delete(Tables.COURSE).where(Tables.COURSE.NUMBER.eq(number)).execute();

    }





    public Boolean isCourseExist(String number){
        if (null != getCourseInfoByNumber(number)){
            return true;
        }

        return false;
    }





}

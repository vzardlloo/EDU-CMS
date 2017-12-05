package com.vzard.educms.repository;

import com.vzard.educms.constant.ErrorConstant;
import com.vzard.educms.database.Tables;
import com.vzard.educms.database.tables.interfaces.ITeacher;
import com.vzard.educms.database.tables.pojos.Teacher;
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
 * Time: 11:12
 * To change this template use File | Settings | File Templates.
 * Description:
 **/

@Service
public class TeacherRepository {

    @Autowired
    @Qualifier("edu")
    DSLContext dsl;


    Logger logger = LoggerFactory.getLogger(TeacherRepository.class);

    public ITeacher getTeacherInfoByNumber(String number){

        return dsl.select()
                .from(Tables.TEACHER)
                .where(Tables.TEACHER.NUMBER.eq(number)).fetchOneInto(ITeacher.class);

    }


    public List<ITeacher> getTeacherInfoByCourseNumber(String number,int limit){
        SelectConditionStep<Record> step  = dsl.select()
                .from(Tables.TEACHER)
                .where(Tables.TEACHER.NUMBER.in(
                        dsl.select(Tables.TEACHER_COURSE.TEACHER_NUMBER)
                        .from(Tables.TEACHER_COURSE)
                        .where(Tables.TEACHER_COURSE.COURSE_NUMBER.eq(number))
                ));

        return step.orderBy(Tables.TEACHER.NUMBER.desc()).limit(limit).fetchInto(ITeacher.class);

    }


    public ITeacher addTeacherInfo(Teacher teacher){

        if (isTeacherExist(teacher.getNumber())){
            throw new EduErrorException(ErrorConstant.ERROR_MSG_USER_EXIST_ERROR,ErrorConstant.ERROR_CODE_USER_NOT_FOUND);
        }

        dsl.insertInto(Tables.TEACHER)
                .columns(Tables.TEACHER.NUMBER,Tables.TEACHER.NAME,Tables.TEACHER.GENDER,
                        Tables.TEACHER.OFFICE,Tables.TEACHER.PHONE_NUMBER,Tables.TEACHER.TITLE)
                .values(teacher.getNumber(),teacher.getName(),teacher.getGender(),teacher.getOffice(),
                        teacher.getPhoneNumber(),teacher.getTitle())
                .execute();

        return getTeacherInfoByNumber(teacher.getNumber());

    }


    public ITeacher updateTeacherInfo(Teacher teacher){

        if (!isTeacherExist(teacher.getNumber())){
            throw new EduErrorException(ErrorConstant.ERROR_MSG_USER_NOT_FOUND,ErrorConstant.ERROR_CODE_USER_NOT_FOUND);
        }

        dsl.update(Tables.TEACHER)
                .set(Tables.TEACHER.NAME,teacher.getName())
                .set(Tables.TEACHER.GENDER,teacher.getGender())
                .set(Tables.TEACHER.OFFICE,teacher.getOffice())
                .set(Tables.TEACHER.PHONE_NUMBER,teacher.getPhoneNumber())
                .set(Tables.TEACHER.TITLE,teacher.getTitle())
                .where(Tables.TEACHER.NUMBER.eq(teacher.getNumber()))
                .execute();

        return getTeacherInfoByNumber(teacher.getNumber());

    }



    public void deleteStudentInfo(String number){

        if (!isTeacherExist(number)){
            throw new EduErrorException(ErrorConstant.ERROR_MSG_USER_NOT_FOUND,ErrorConstant.ERROR_CODE_USER_NOT_FOUND);
        }

        dsl.delete(Tables.TEACHER).where(Tables.TEACHER.NUMBER.eq(number)).execute();

    }





    public Boolean isTeacherExist(String number){
        if (null != getTeacherInfoByNumber(number)){
            return true;
        }

        return false;
    }






}




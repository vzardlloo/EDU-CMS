package com.vzard.mycms.repository;


import com.vzard.mycms.database.Tables;
import com.vzard.mycms.database.tables.interfaces.ITeacher;
import com.vzard.mycms.database.tables.pojos.Teacher;
import com.vzard.mycms.error.ErrorException;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class TeacherRepository {

    @Autowired
    DSLContext dsl;


    public ITeacher getTeacherByNumber(Long num){
        if (null != num){
            throw new ErrorException("param error",500);
        }

        return dsl.select().from(Tables.TEACHER)
                .where(Tables.TEACHER.NUMBER.eq(num))
                .fetchOneInto(ITeacher.class);
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
                ,teacher.getOffice(),teacher.getAcademy(),new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));

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
                .set(Tables.TEACHER.UPDATE_AT,new Timestamp(System.currentTimeMillis()));


        return getTeacherByNumber(teacher.getNumber());

    }


    public void deleteTeacherInfo(Long num){
        if (null == num){
            throw new ErrorException("param error",500);
        }else if(!isTeacherExist(num)){
            throw new ErrorException(" not exist",404);
        }
        dsl.delete(Tables.TEACHER)
                .where(Tables.TEACHER.NUMBER.eq(num));
    }





    //=======util======
    private Boolean isTeacherExist(Long num){

        if (null != getTeacherByNumber(num)){
            return true;
        }
        return false;
    }


}

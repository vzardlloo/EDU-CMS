package com.vzard.mycms.repository;


import com.vzard.mycms.database.Tables;
import com.vzard.mycms.database.tables.interfaces.IStudent;
import com.vzard.mycms.database.tables.pojos.Student;
import com.vzard.mycms.error.ErrorException;
import javafx.scene.control.Tab;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class StudentRepository {

    @Autowired
    @Qualifier("mycms")
    DSLContext dsl;

    public IStudent getStudentByNumber(Long number){
        if (null != number){
            throw new ErrorException("param error",500);
        }

        return dsl.select().from(Tables.STUDENT)
                .where(Tables.STUDENT.NUMBER.eq(number))
                .fetchOneInto(IStudent.class);
    }


    public IStudent addStudentInfo(Student student){
        if(null == student){
            throw new ErrorException("param error",500);
        }else if (isStudentExist(student.getNumber())){
            throw new ErrorException("already exist!",500);
        }

        dsl.insertInto(Tables.STUDENT)
                .columns(Tables.STUDENT.NUMBER,Tables.STUDENT.NAME,Tables.STUDENT.PASSWORD
                ,Tables.STUDENT.GENDER,Tables.STUDENT.BIRTHDAY,Tables.STUDENT.CLBUM
                ,Tables.STUDENT.ACADEMY,Tables.STUDENT.CREATED_AT,Tables.STUDENT.UPDATED_AT)
                .values(student.getNumber(),student.getName(),student.getPassword()
                ,student.getGender(),student.getBirthday(),student.getClbum()
                ,student.getAcademy(),new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()))
                .execute();


        IStudent iStudent = getStudentByNumber(student.getNumber());
        if (null == iStudent){
            throw new ErrorException("insert failed",404);
        }

        return iStudent;
    }

    public IStudent updateStudentInfo(Student student){
        if (null == student) {
            throw new ErrorException("param error", 500);
        }else if(!isStudentExist(student.getNumber())){
            throw new ErrorException("not exist!",404);
        }

        dsl.update(Tables.STUDENT)
                .set(Tables.STUDENT.BIRTHDAY,student.getBirthday())
                .set(Tables.STUDENT.PASSWORD,student.getPassword())
                .set(Tables.STUDENT.CLBUM,student.getClbum())
                .set(Tables.STUDENT.ACADEMY,student.getAcademy())
                .set(Tables.STUDENT.GENDER,student.getGender())
                .set(Tables.STUDENT.UPDATED_AT,new Timestamp(System.currentTimeMillis()));

        return getStudentByNumber(student.getNumber());

    }


    public void deleteStudentInfo(Long num){
        if (null != num) {
            throw new ErrorException("param error", 500);
        }else if(!isStudentExist(num)){
            throw new ErrorException("not exist!",404);
        }

        dsl.delete(Tables.STUDENT)
                .where(Tables.STUDENT.NUMBER.eq(num));

        if (isStudentExist(num)){
            throw new ErrorException("delete failed",500);
        }

    }


    //=======util=======
    private Boolean isStudentExist(Long num){

        if (null != getStudentByNumber(num)){
            return true;
        }
        return false;
    }







}

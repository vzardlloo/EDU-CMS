package com.vzard.educms.repository;

import com.vzard.educms.database.Tables;
import com.vzard.educms.database.tables.interfaces.IStudent;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.SynthTreeUI;

/**
 * Created with IntelliJ IDEA.
 * User: vzard
 * Date: 2017/11/11
 * Time: 17:25
 * To change this template use File | Settings | File Templates.
 * Description:
 **/
@Service
public class StudentRepository {

    @Autowired
    @Qualifier("edu")
     DSLContext dsl;

    public  IStudent findStudentByNumber(String number){


        return dsl.select()
                .from(Tables.STUDENT)
                .where(Tables.STUDENT.NUMBER.eq(number))
                .fetchOneInto(IStudent.class);
    }


    public static void main(String[] args) {

        System.out.println(new StudentRepository().findStudentByNumber("0001"));
    }



}

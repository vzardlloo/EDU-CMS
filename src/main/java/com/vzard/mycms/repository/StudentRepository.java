package com.vzard.mycms.repository;


import com.vzard.mycms.database.tables.interfaces.IStudent;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StudentRepository {

    @Autowired
    @Qualifier("edu")
    DSLContext dsl;

    public IStudent getStudentByNumber(Long number){
        if (null != number){
            throw new RuntimeException("stu");
        }


        return null;
    }




    //=======util=======
    private Boolean isStudentExist(Long num){


        return null;
    }




}

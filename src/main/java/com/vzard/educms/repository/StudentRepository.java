package com.vzard.educms.repository;

import com.vzard.educms.constant.ErrorConstant;
import com.vzard.educms.database.Tables;
import com.vzard.educms.database.tables.interfaces.IStudent;
import com.vzard.educms.database.tables.pojos.Student;
import com.vzard.educms.error.EduErrorException;
import org.jooq.DSLContext;
import org.jooq.util.xml.jaxb.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(StudentRepository.class);

    public  IStudent findStudentByNumber(String number){


        return dsl.select()
                .from(Tables.STUDENT)
                .where(Tables.STUDENT.NUMBER.eq(number))
                .fetchOneInto(IStudent.class);
    }


    public IStudent addStudentInfo(Student student){
       //logger.info("studentInfo-r: "+student.toString());

        if (isStudentExist(student.getNumber())){
            throw new EduErrorException(ErrorConstant.ERROR_MSG_USER_EXIST_ERROR,ErrorConstant.ERROR_CODE_USER_EXIST_ERROR);
        }

        dsl.insertInto(Tables.STUDENT)
                .columns(Tables.STUDENT.NUMBER,Tables.STUDENT.NAME,Tables.STUDENT.ADDRESS,
                        Tables.STUDENT.BRITHDAY,Tables.STUDENT.GENDER,Tables.STUDENT.PASSWORD,Tables.STUDENT.PHONE_NUMBER)
                .values(student.getNumber(),student.getName(),student.getAddress(),student.getBrithday(),
                        student.getGender(),student.getPassword(),student.getPhoneNumber()).execute();

        return findStudentByNumber(student.getNumber());
    }


    public IStudent updateStudentInfo(Student student){

        if (!isStudentExist(student.getNumber())){
            throw new EduErrorException(ErrorConstant.ERROR_MSG_USER_NOT_FOUND,ErrorConstant.ERROR_CODE_USER_NOT_FOUND);
        }

        dsl.update(Tables.STUDENT)
                .set(Tables.STUDENT.NAME,student.getName())
                .set(Tables.STUDENT.PASSWORD,student.getPassword())
                .set(Tables.STUDENT.ADDRESS,student.getAddress())
                .set(Tables.STUDENT.BRITHDAY,student.getBrithday())
                .set(Tables.STUDENT.GENDER,student.getGender())
                .set(Tables.STUDENT.PHONE_NUMBER,student.getPhoneNumber())
                .where(Tables.STUDENT.NUMBER.eq(student.getNumber()));

        return findStudentByNumber(student.getNumber());
    }


    public void deleteStudentInfo(String number){
        if (!isStudentExist(number)){
            throw new EduErrorException(ErrorConstant.ERROR_MSG_USER_NOT_FOUND,ErrorConstant.ERROR_CODE_USER_NOT_FOUND);
        }

        dsl.delete(Tables.STUDENT).where(Tables.STUDENT.NUMBER.eq(number)).execute();

    }

    //根据学号和密码来查询学生是否存在
    public IStudent findStudentByNumberAndPassWord(String num,String pwd){

        return dsl.select()
                .from(Tables.STUDENT)
                .where(Tables.STUDENT.NUMBER.eq(num))
                .and(Tables.STUDENT.PASSWORD.eq(pwd))
                .fetchOneInto(IStudent.class);



    }






    //判断学生是否存在
    public Boolean isStudentExist(String number){

        if (null != findStudentByNumber(number)){
            return true;
        }

        return false;
    }







}

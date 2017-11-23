package com.vzard.educms.service;


import com.vzard.educms.database.tables.interfaces.IStudent;
import com.vzard.educms.database.tables.pojos.Student;
import com.vzard.educms.error.EduErrorException;
import com.vzard.educms.mapper.StudentMapper;
import com.vzard.educms.model.dto.LoginParam;
import com.vzard.educms.model.dto.RegisterParam;
import com.vzard.educms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.Session;

@Service
public class AccountService {

@Autowired
StudentRepository studentRepository;


    public Boolean login(LoginParam param){

        IStudent iStudent = studentRepository.findStudentByNumberAndPassWord(param.getNumber(),param.getPassword());

        if (null != iStudent){
            return true;
        }
        return false;

    }

    public Student register(Student student){

        IStudent iStudent = studentRepository.addStudentInfo(student);

        Student std = StudentMapper
                .mapToDao(studentRepository.findStudentByNumber(student.getNumber()));
        if (!isRegister(std.getNumber())){
            throw new EduErrorException("登录失败!");
        }

        return std;
    }

    /**
     * 验证是否注册成功
     * @param number
     * @return
     */
    public Boolean isRegister(String number){

        IStudent iStudent = studentRepository.findStudentByNumber(number);
        if (null != iStudent){
            return true;
        }
        return false;
    }




}

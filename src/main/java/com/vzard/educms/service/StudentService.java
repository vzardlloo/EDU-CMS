package com.vzard.educms.service;

import com.vzard.educms.database.tables.interfaces.IStudent;
import com.vzard.educms.database.tables.pojos.Student;
import com.vzard.educms.mapper.StudentMapper;
import com.vzard.educms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: vzard
 * Date: 2017/11/11
 * Time: 21:53
 * To change this template use File | Settings | File Templates.
 * Description:
 **/
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    public Student getStudentByNumber(String number) {

        IStudent iStudent = studentRepository.findStudentByNumber(number);
        return StudentMapper.mapToDao(iStudent);
    }




}

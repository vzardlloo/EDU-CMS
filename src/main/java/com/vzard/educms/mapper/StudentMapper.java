package com.vzard.educms.mapper;


import com.vzard.educms.database.tables.interfaces.IStudent;
import com.vzard.educms.database.tables.pojos.Student;

/**
 * Created with IntelliJ IDEA.
 * User: vzard
 * Date: 2017/11/11
 * Time: 21:56
 * To change this template use File | Settings | File Templates.
 * Description:
 **/


public class StudentMapper {

    public static Student mapToDao(IStudent iStudent){

        Student student = new Student();

        student.setName(iStudent.getName());
        student.setNumber(iStudent.getNumber());
        student.setAddress(iStudent.getAddress());
        student.setBrithday(iStudent.getBrithday());
        student.setGender(iStudent.getGender());
        student.setPassword(iStudent.getPassword());
        student.setPhoneNumber(iStudent.getPhoneNumber());

        return student;

    }




}

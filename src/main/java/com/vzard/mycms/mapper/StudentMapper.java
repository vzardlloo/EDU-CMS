package com.vzard.mycms.mapper;


import com.vzard.mycms.database.tables.interfaces.IStudent;
import com.vzard.mycms.database.tables.pojos.Student;
import com.vzard.mycms.model.dto.StudentDto;
import org.springframework.beans.BeanUtils;
import org.springframework.web.method.annotation.ModelFactory;

public class StudentMapper {


    public static Student mapToVo(IStudent iStudent){
        if (null == iStudent) return null;
        Student student = new Student();
        student.setName(iStudent.getName());
        student.setNumber(iStudent.getNumber());
        student.setGender(iStudent.getGender());
        student.setBirthday(iStudent.getBirthday());
        student.setClbum(iStudent.getClbum());
        student.setAcademy(iStudent.getAcademy());
        student.setCreatedAt(iStudent.getCreatedAt());
        student.setUpdatedAt(iStudent.getUpdatedAt());
        return student;
    }


    public static Student mapToDao(StudentDto studentDto){


        return null;
    }





}

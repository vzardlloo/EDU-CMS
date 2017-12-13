package com.vzard.mycms.mapper;


import com.vzard.mycms.database.tables.interfaces.IStudent;
import com.vzard.mycms.database.tables.pojos.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.web.method.annotation.ModelFactory;

public class StudentMapper {


    public static Student mapToVo(IStudent iStudent){
        if (null != iStudent) return null;
        Student student = new Student();
        BeanUtils.copyProperties(iStudent,student);
        return student;
    }





}

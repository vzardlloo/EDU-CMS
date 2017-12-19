package com.vzard.mycms.mapper;


import com.vzard.mycms.database.tables.interfaces.ITeacher;
import com.vzard.mycms.database.tables.pojos.Teacher;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;

public class TeacherMapper {


    public static Teacher mapToVo(ITeacher iTeacher){
        if (null == iTeacher){
            return null;
        }
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(iTeacher,teacher);
//        teacher.setNumber(iTeacher.getNumber());
//        teacher.setName(iTeacher.getName());
//        teacher.setGender(iTeacher.getGender());
//        teacher.setPassword(iTeacher.getPassword());
        return teacher;
    }




}

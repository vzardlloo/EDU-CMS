package com.vzard.mycms.mapper;


import com.vzard.mycms.database.tables.interfaces.ITeacher;
import com.vzard.mycms.database.tables.pojos.Teacher;
import org.springframework.beans.BeanUtils;

public class TeacherMapper {


    public static Teacher mapToVo(ITeacher iTeacher){
        if (null == iTeacher){
            return null;
        }
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(iTeacher,teacher);
        return teacher;
    }

}

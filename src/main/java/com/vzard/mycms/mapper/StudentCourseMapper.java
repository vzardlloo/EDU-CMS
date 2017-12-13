package com.vzard.mycms.mapper;


import com.vzard.mycms.database.tables.interfaces.IStudentCourse;
import com.vzard.mycms.database.tables.pojos.StudentCourse;
import org.springframework.beans.BeanUtils;

public class StudentCourseMapper {



    public static StudentCourse mapToVo(IStudentCourse iStudentCourse){
        if (null == iStudentCourse) return null;
        StudentCourse studentCourse = new StudentCourse();
        BeanUtils.copyProperties(iStudentCourse,studentCourse);
        return studentCourse;
    }


}

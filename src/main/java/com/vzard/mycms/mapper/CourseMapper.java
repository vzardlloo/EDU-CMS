package com.vzard.mycms.mapper;


import com.vzard.mycms.database.tables.interfaces.ICourse;
import com.vzard.mycms.database.tables.interfaces.IStudent;
import com.vzard.mycms.database.tables.pojos.Course;
import com.vzard.mycms.model.dto.CourseWithCurrentStudentNumber;
import org.springframework.beans.BeanUtils;

public class CourseMapper {


    public static Course  mapToVo(ICourse iCourse){
        if (null == iCourse){
            return null;
        }
        Course course = new Course();
        BeanUtils.copyProperties(iCourse,course);
        return course;
    }

    public static CourseWithCurrentStudentNumber mapToDto(ICourse iCourse, IStudent iStudent){
        if (null == iCourse && null == iStudent){
            return null;
        }
        CourseWithCurrentStudentNumber courseWithCurrentStudentNumber = new CourseWithCurrentStudentNumber();
        BeanUtils.copyProperties(iCourse,courseWithCurrentStudentNumber);
        courseWithCurrentStudentNumber.setStudentNumber(iStudent.getNumber());

        return courseWithCurrentStudentNumber;
    }


}

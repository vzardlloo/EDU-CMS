package com.vzard.mycms.mapper;


import com.vzard.mycms.database.tables.interfaces.ICourse;
import com.vzard.mycms.database.tables.pojos.Course;
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


}

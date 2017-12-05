package com.vzard.educms.mapper;

import com.vzard.educms.database.tables.interfaces.ICourse;
import com.vzard.educms.database.tables.pojos.Course;

/**
 * Created with IntelliJ IDEA.
 * User: vzard
 * Date: 2017/11/13
 * Time: 13:27
 * To change this template use File | Settings | File Templates.
 * Description:
 **/

public class CourseMapper {

    public static Course mapToDao(ICourse iCourse){

        if (null == iCourse){
            return null;
        }
        Course course = new Course();

        course.setNumber(iCourse.getNumber());
        course.setName(iCourse.getName());
        course.setCredit(iCourse.getCredit());
        course.setPeried(iCourse.getPeried());
        course.setTeacher(iCourse.getTeacher());
        course.setClassroom(iCourse.getClassroom());
        course.setCourseTime(iCourse.getCourseTime());
        course.setMaxChoosed(iCourse.getMaxChoosed());
        course.setHasChoosed(iCourse.getHasChoosed());
        course.setGrade(iCourse.getGrade());
        course.setPacificGrade(iCourse.getPacificGrade());
        course.setGeneralGrade(iCourse.getGeneralGrade());

        return course;

    }

}

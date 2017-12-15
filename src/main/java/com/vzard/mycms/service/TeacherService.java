package com.vzard.mycms.service;


import com.vzard.mycms.database.tables.Teacher;
import com.vzard.mycms.database.tables.interfaces.ICourse;
import com.vzard.mycms.database.tables.interfaces.IStudent;
import com.vzard.mycms.database.tables.pojos.Course;
import com.vzard.mycms.mapper.CourseMapper;
import com.vzard.mycms.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TeacherService {

    @Autowired
    CourseRepository courseRepository;

   public Course addCourse(Course c){

       ICourse  course = courseRepository.addCourse(c);
       return CourseMapper.mapToVo(course);
   }







}

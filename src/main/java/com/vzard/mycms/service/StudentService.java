package com.vzard.mycms.service;


import com.vzard.mycms.database.tables.interfaces.IStudentCourse;
import com.vzard.mycms.database.tables.pojos.Student;
import com.vzard.mycms.database.tables.pojos.StudentCourse;
import com.vzard.mycms.mapper.StudentCourseMapper;
import com.vzard.mycms.mapper.StudentMapper;
import com.vzard.mycms.repository.StudentCourseRepository;
import com.vzard.mycms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentCourseRepository studentCourseRepository;

    public Student modifyPersonInfo(Student student){


        return StudentMapper.mapToVo(studentRepository.updateStudentInfo(student));
    }
    public StudentCourse chooseCourse(StudentCourse studentCourse){

        IStudentCourse iStudentCourse = studentCourseRepository.addStudentCourseMap(studentCourse);
        return StudentCourseMapper.mapToVo(iStudentCourse);
    }




}

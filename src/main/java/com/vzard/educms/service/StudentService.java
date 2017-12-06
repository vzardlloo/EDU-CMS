package com.vzard.educms.service;

import com.vzard.educms.database.tables.interfaces.ICourse;
import com.vzard.educms.database.tables.interfaces.IStudent;
import com.vzard.educms.database.tables.pojos.Course;
import com.vzard.educms.database.tables.pojos.Student;
import com.vzard.educms.error.EduErrorException;
import com.vzard.educms.mapper.CourseMapper;
import com.vzard.educms.mapper.StudentMapper;
import com.vzard.educms.repository.CourseRepository;
import com.vzard.educms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: vzard
 * Date: 2017/11/11
 * Time: 21:53
 * To change this template use File | Settings | File Templates.
 * Description:
 **/
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;


    public Student getStudentByNumber(String number) {

        IStudent iStudent = studentRepository.findStudentByNumber(number);
        return StudentMapper.mapToDao(iStudent);
    }

    public Student addStudentInfo(Student student){

        IStudent s = studentRepository.addStudentInfo(student);
        return StudentMapper.mapToDao(s);

    }


    public List<Course> getCourseRecordByStudentNumber(String number){

        List<Course> courses = courseRepository.getCourseInfoByStudentNumber(number)
                .stream().map(t-> CourseMapper.mapToDao(t)).collect(Collectors.toList());
        if (null == courses){
            throw new EduErrorException("find nothing",400);
        }

        return courses;
    }


    public Student updataStudentInfo(Student student){

        IStudent s = studentRepository.updateStudentInfo(student);

        return StudentMapper.mapToDao(s);
    }


    public void deleteStudentInfo(String number){
        studentRepository.deleteStudentInfo(number);
    }


    public Boolean isStudentExist(String number){
        return studentRepository.isStudentExist(number);
    }





}

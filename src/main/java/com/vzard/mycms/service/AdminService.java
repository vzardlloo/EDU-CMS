package com.vzard.mycms.service;


import com.vzard.mycms.database.tables.pojos.Student;
import com.vzard.mycms.database.tables.pojos.Teacher;
import com.vzard.mycms.mapper.StudentMapper;
import com.vzard.mycms.repository.StudentRepository;
import com.vzard.mycms.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;

    public Student addStudentInfo(Student student){
        return StudentMapper.mapToVo(studentRepository.addStudentInfo(student));
    }





}

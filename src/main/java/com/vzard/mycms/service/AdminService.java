package com.vzard.mycms.service;


import com.vzard.mycms.database.tables.pojos.Student;
import com.vzard.mycms.database.tables.pojos.Teacher;
import com.vzard.mycms.mapper.StudentMapper;
import com.vzard.mycms.mapper.TeacherMapper;
import com.vzard.mycms.repository.StudentRepository;
import com.vzard.mycms.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class AdminService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;

    public List<Student> getStudentInfo(Student student){
        return studentRepository.getStudentList().stream()
                .map(t->StudentMapper.mapToVo(t))
                .collect(Collectors.toList());
    }

    public Student addStudentInfo(Student student){
        return StudentMapper.mapToVo(studentRepository.addStudentInfo(student));
    }

    public Student alertStudentInfo(Student student){
        return StudentMapper.mapToVo(studentRepository.updateStudentInfo(student));
    }

    public void deleteStudentInfo(Long num){
         studentRepository.deleteStudentInfo(num);
    }


    public List<Teacher> getTeacherList(){
        return teacherRepository.getTeacherList().stream()
                .map(t->TeacherMapper.mapToVo(t))
                .collect(Collectors.toList());
    }

    public Teacher addTeacherInfo(Teacher teacher){

        return TeacherMapper.mapToVo(teacherRepository.addTeacherInfo(teacher));
    }

    public Teacher alertTeacherInfo(Teacher teacher){
        return TeacherMapper.mapToVo(teacherRepository.updateTeacherInfo(teacher));
    }

    public void deleteTeacherInfo(Long num){
        teacherRepository.deleteTeacherInfo(num);
    }



}

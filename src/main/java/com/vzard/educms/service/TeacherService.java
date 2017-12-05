package com.vzard.educms.service;

import com.vzard.educms.database.tables.interfaces.ITeacher;
import com.vzard.educms.database.tables.pojos.Teacher;
import com.vzard.educms.mapper.TeacherMapper;
import com.vzard.educms.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: vzard
 * Date: 2017/11/13
 * Time: 12:14
 * To change this template use File | Settings | File Templates.
 * Description:
 **/
@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public Teacher getTeacherInfoByNumber(String number){

        ITeacher iTeacher = teacherRepository.getTeacherInfoByNumber(number);

        return TeacherMapper.mapToDao(iTeacher);
    }

    public Teacher addTeacherInfo(Teacher teacher){

        ITeacher iTeacher = teacherRepository.addTeacherInfo(teacher);

        return TeacherMapper.mapToDao(iTeacher);
    }

    public Teacher updateTeacherInfo(Teacher teacher){

        ITeacher iTeacher = teacherRepository.updateTeacherInfo(teacher);

        return TeacherMapper.mapToDao(iTeacher);
    }

    public void deleteTeacherInfo(String number){

        teacherRepository.deleteStudentInfo(number);
    }


    public Boolean isTeacherExist(String number){
        return teacherRepository.isTeacherExist(number);
    }


}

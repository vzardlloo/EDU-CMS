package com.vzard.mycms.service;


import com.vzard.mycms.database.tables.interfaces.IStudentCourse;
import com.vzard.mycms.database.tables.pojos.Student;
import com.vzard.mycms.database.tables.pojos.StudentCourse;
import com.vzard.mycms.mapper.StudentCourseMapper;
import com.vzard.mycms.mapper.StudentMapper;
import com.vzard.mycms.model.dto.CourseWithGradeDto;
import com.vzard.mycms.repository.StudentCourseRepository;
import com.vzard.mycms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentCourseRepository studentCourseRepository;

    /**
     * 修改个人信息
     * @param student
     * @return
     */
    public Student modifyPersonInfo(Student student){

        return StudentMapper.mapToVo(studentRepository.updateStudentInfo(student));
    }

    /**
     * 选课
     * @param studentCourse
     * @return
     */
    public StudentCourse chooseCourse(StudentCourse studentCourse){

        IStudentCourse iStudentCourse = studentCourseRepository.addStudentCourseMap(studentCourse);
        return StudentCourseMapper.mapToVo(iStudentCourse);
    }

    /**
     * 获得已选课程
     * @param studentNum
     * @param start
     * @param offset
     * @return
     */
    public List<CourseWithGradeDto> getChoosedCourse(Long studentNum, int start, int offset){

      return studentRepository.getChoosedCourse(studentNum,start,offset);

    }




}

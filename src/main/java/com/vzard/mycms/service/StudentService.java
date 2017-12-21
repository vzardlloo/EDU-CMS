package com.vzard.mycms.service;


import com.vzard.mycms.database.tables.interfaces.IStudentCourse;
import com.vzard.mycms.database.tables.pojos.Course;
import com.vzard.mycms.database.tables.pojos.Student;
import com.vzard.mycms.database.tables.pojos.StudentCourse;
import com.vzard.mycms.mapper.CourseMapper;
import com.vzard.mycms.mapper.StudentCourseMapper;
import com.vzard.mycms.mapper.StudentMapper;
import com.vzard.mycms.model.dto.CourseWithGradeDto;
import com.vzard.mycms.repository.CourseRepository;
import com.vzard.mycms.repository.StudentCourseRepository;
import com.vzard.mycms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentCourseRepository studentCourseRepository;
    @Autowired
    CourseRepository courseRepository;

    /**
     * 根据学号查找一个学生
     * @param num
     * @return
     */
    public Student getStudentByNumber(String num){

        return StudentMapper.mapToVo(studentRepository.getStudentByNumber(num));

    }


    /**
     * 修改个人信息
     * @param student
     * @return
     */
    public Student modifyPersonInfo(Student student){

        return StudentMapper.mapToVo(studentRepository.updateStudentInfo(student));
    }


    public List<Course> getCourseList(){

        return courseRepository.getCourseList()
                .stream().map(t-> CourseMapper.mapToVo(t))
                .collect(Collectors.toList());
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
     * 退课
     * @param studentNum
     * @param courseNum
     */
    public void deleteCourse(String studentNum,String courseNum){
        studentCourseRepository.deleteStudentCourseMap(studentNum,courseNum);
    }

    /**
     * 获得已选课程
     * @param studentNum
     * @param start
     * @param offset
     * @return
     */
    public List<CourseWithGradeDto> getChoosedCourse(String studentNum, int start, int offset){

      return studentRepository.getChoosedCourse(studentNum,start,offset);

    }




}

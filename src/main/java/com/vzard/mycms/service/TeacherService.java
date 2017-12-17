package com.vzard.mycms.service;


import com.vzard.mycms.database.tables.Teacher;
import com.vzard.mycms.database.tables.interfaces.ICourse;
import com.vzard.mycms.database.tables.interfaces.IStudent;
import com.vzard.mycms.database.tables.pojos.Course;
import com.vzard.mycms.database.tables.pojos.Grade;
import com.vzard.mycms.mapper.CourseMapper;
import com.vzard.mycms.mapper.GradeMapper;
import com.vzard.mycms.repository.CourseRepository;
import com.vzard.mycms.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TeacherService {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    GradeRepository gradeRepository;

    /**
     * 获取自己教授的课程列表
     * @param teacherName
     * @return
     */
   public List<Course> getCourseList(String teacherName){
       return courseRepository.getCourseByTeacher(teacherName).stream()
               .map(t->CourseMapper.mapToVo(t))
               .collect(Collectors.toList());
   }

    /**
     * 发布一条课程
     * @param c
     * @return
     */
   public Course addCourse(Course c){

       ICourse  course = courseRepository.addCourse(c);
       return CourseMapper.mapToVo(course);
   }

    /**
     * 修改一条课程
     * @param course
     * @return
     */
   public Course alertCourse(Course course){
       return CourseMapper.mapToVo(courseRepository.updateCourse(course));
   }

    /**
     * 删除一条课程
     * @param num
     */
   public void deleteCourse(String num){
       courseRepository.deleteCourse(num);
   }

    /**
     *
     * @param courseNum
     * @return
     */
    public List<Grade> getGradeList(String courseNum){
       return gradeRepository.getGradeList(courseNum.toString()).stream()
               .map(t-> GradeMapper.mapToVo(t))
               .collect(Collectors.toList());
    }

    /**
     * 增加一条成绩信息
     * @param grade
     * @return
     */
    public Grade addGradeInfo(Grade grade){
        return GradeMapper.mapToVo(gradeRepository.addGradeInfo(grade));
    }

    /**
     * 更新一条成绩信息
     * @param grade
     * @return
     */
    public Grade updateGradeInfo(Grade grade){
        return GradeMapper.mapToVo(gradeRepository.updateGradeInfo(grade));
    }

    /**
     * 删除一条成绩信息
     * @param id
     */
    public void deleteGradeInfo(Long id){
        gradeRepository.deleteGradeInfo(id);
    }





}

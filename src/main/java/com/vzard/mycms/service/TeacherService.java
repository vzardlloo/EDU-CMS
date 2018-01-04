package com.vzard.mycms.service;


import com.vzard.mycms.database.tables.interfaces.ICourse;
import com.vzard.mycms.database.tables.pojos.Course;
import com.vzard.mycms.database.tables.pojos.Grade;
import com.vzard.mycms.database.tables.pojos.Teacher;
import com.vzard.mycms.mapper.CourseMapper;
import com.vzard.mycms.mapper.GradeMapper;
import com.vzard.mycms.mapper.TeacherMapper;
import com.vzard.mycms.model.dto.StudentWithGrade;
import com.vzard.mycms.repository.CourseRepository;
import com.vzard.mycms.repository.GradeRepository;
import com.vzard.mycms.repository.TeacherCourseRepository;
import com.vzard.mycms.repository.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TeacherService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    TeacherCourseRepository teacherCourseRepository;

    /**
     * 根据工号获取教师信息
     * @param number
     * @return
     */
    public Teacher getTeacherByNumber(String number){

        return TeacherMapper.mapToVo(teacherRepository.getTeacherByNumber(number));
    }

    /**
     * 发布一个成绩
     * @param grade
     * @return
     */
    public Grade postGrade(StudentWithGrade grade){
        return GradeMapper.mapToVo(gradeRepository.updateGradeInfo(grade));
    }

    /**
     * 获取学生-成绩
     * @param num
     * @return
     */
    public List<StudentWithGrade> getStudnetWithGrade(String num){
        logger.info(num);
        return teacherRepository.getStudentWithGrade(num);
    }


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
       logger.info(c.toString());
       c.setHasChoosed(0L);
       ICourse  course = courseRepository.addCourse(c);
       teacherCourseRepository.addTeacherCourseMap(c.getTecherNum(), c.getNumber());
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
     * 删除一条成绩信息
     * @param id
     */
    public void deleteGradeInfo(Long id){
        gradeRepository.deleteGradeInfo(id);
    }









}

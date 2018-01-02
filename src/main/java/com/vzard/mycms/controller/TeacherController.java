package com.vzard.mycms.controller;



import com.vzard.mycms.database.tables.pojos.Course;
import com.vzard.mycms.database.tables.pojos.Grade;
import com.vzard.mycms.database.tables.pojos.Teacher;
import com.vzard.mycms.model.ResponseModel;
import com.vzard.mycms.model.dto.LoginParam;
import com.vzard.mycms.model.dto.StudentWithGrade;
import com.vzard.mycms.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@RequestMapping(path = "teacher")
@Controller
public class TeacherController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TeacherService teacherService;



    private ModelAndView modelAndView = new ModelAndView();

    @RequestMapping(value = "/main",method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, LoginParam loginParam){

        logger.info(loginParam.getNumber());
        Teacher teacher = teacherService.getTeacherByNumber(loginParam.getNumber());
        //logger.info(student.getName());
        String verifyCode = (String)request.getSession().getAttribute("verifyCode");
        logger.info(verifyCode);
        logger.info(teacher.getName());
        logger.info(teacher.getPassword());
        if (null != teacher && verifyCode.equals(loginParam.getVerifycode()) && loginParam.getPassword().equals(teacher.getPassword())){
            logger.info(teacher.getName());
            logger.info(request.getContextPath());
            String sessionId = request.getSession().getId();
            request.getSession().setAttribute(sessionId,teacher);
            modelAndView.addObject("teacher",teacher);
            modelAndView.addObject("page",new String("welcome"));
            modelAndView.setViewName("teacher/main");

        }else {
            logger.info("not login...");
            request.getSession().invalidate();
            modelAndView.setViewName("redirect:/teacher");
        }

        return modelAndView;
    }


    @RequestMapping(value = "/post-course")
    public ModelAndView postCourse(){
        modelAndView.addObject("page",new String("postCourse"));
        modelAndView.setViewName("teacher/main");
        return modelAndView;
    }

    @RequestMapping(value = "/post-grade")
    public ModelAndView postGrade(){
        modelAndView.addObject("page",new String("postGrade"));
        modelAndView.setViewName("teacher/main");
        return modelAndView;
    }


    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        modelAndView.clear();
        modelAndView.setViewName("redirect:/teacher");
        return modelAndView;
    }

    @RequestMapping(value = "/course",method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel<Course> postCourse(@RequestBody Course course){
        logger.info(course.toString());
        Course course1 = teacherService.addCourse(course);
        return ResponseModel.builder()
                .code(0)
                .data(course1)
                .message("")
                .build();
    }

    @RequestMapping(value = "/grade/{teacherNum}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseModel<List<StudentWithGrade>> getStudentWithGrade(@PathVariable(value = "teacherNum") String teacherNum){
        logger.info(teacherNum);
        List<StudentWithGrade> studentWithGradeList = teacherService.getStudnetWithGrade(teacherNum);
        return ResponseModel.builder()
                .code(0)
                .data(studentWithGradeList)
                .message("")
                .count( new Long(studentWithGradeList.size()))
                .build();
    }

    @RequestMapping(value = "/grade",method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel<Grade> postGrade(@RequestBody StudentWithGrade grade){
        Grade grade1 = teacherService.postGrade(grade);
        return ResponseModel.builder()
                .code(0)
                .data(grade1)
                .message("")
                .build();
    }




}

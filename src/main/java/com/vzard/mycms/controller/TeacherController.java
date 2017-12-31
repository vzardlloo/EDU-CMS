package com.vzard.mycms.controller;



import com.vzard.mycms.database.tables.pojos.Student;
import com.vzard.mycms.database.tables.pojos.Teacher;
import com.vzard.mycms.model.dto.LoginParam;
import com.vzard.mycms.service.StudentService;
import com.vzard.mycms.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


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
            modelAndView.setViewName("redirect:/");
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




}

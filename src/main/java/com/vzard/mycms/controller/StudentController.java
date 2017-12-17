package com.vzard.mycms.controller;


import com.vzard.mycms.database.tables.pojos.Student;
import com.vzard.mycms.model.dto.LoginParam;
import com.vzard.mycms.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.soap.Addressing;

@RequestMapping(value = "/student")
@Controller
public class StudentController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/main",method = RequestMethod.POST)
  public ModelAndView login(HttpServletRequest request, LoginParam loginParam){
        ModelAndView modelAndView = new ModelAndView();
        logger.info(loginParam.getNumber());
        Student student = studentService.getStudentByNumber(loginParam.getNumber());
        //logger.info(student.getName());
        String verifyCode = (String)request.getSession().getAttribute("verifyCode");
        logger.info(verifyCode);
        if (null != student && verifyCode.equals(loginParam.getVerifycode())){
            logger.info(student.getName());
            String sessionId = request.getSession().getId();
            request.getSession().setAttribute(sessionId,student);
            modelAndView.addObject("student",student);
            modelAndView.setViewName("student/main");

        }else {
            logger.info("not login...");
            request.getSession().invalidate();
            modelAndView.setViewName("index");
        }

        return modelAndView;
  }



}

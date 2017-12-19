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
import javax.servlet.http.HttpSession;


@RequestMapping(path = "student")
@Controller
public class StudentController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentService studentService;

    private ModelAndView modelAndView = new ModelAndView();

    @RequestMapping(value = "/main",method = RequestMethod.POST)
  public ModelAndView login(HttpServletRequest request, LoginParam loginParam){

        logger.info(loginParam.getNumber());
        Student student = studentService.getStudentByNumber(loginParam.getNumber());
        //logger.info(student.getName());
        String verifyCode = (String)request.getSession().getAttribute("verifyCode");
        logger.info(verifyCode);
        if (null != student && verifyCode.equals(loginParam.getVerifycode())){
            logger.info(student.getName());
            logger.info(request.getContextPath());
            String sessionId = request.getSession().getId();
            request.getSession().setAttribute(sessionId,student);
            modelAndView.addObject("student",student);
            modelAndView.addObject("page",new String("welcome"));
            modelAndView.setViewName("student/main");

        }else {
            logger.info("not login...");
            request.getSession().invalidate();
            modelAndView.setViewName("redirect:/");
        }

        return modelAndView;
  }


  @RequestMapping(value = "/choose",method = RequestMethod.GET)
  public ModelAndView choose(){
      String page = new String("choose");
      modelAndView.addObject("page",page);
      modelAndView.setViewName("student/main");
      return modelAndView;
  }

  @RequestMapping(value = "/course",method = RequestMethod.GET)
  public ModelAndView course(){
      String page = new String("course");
      modelAndView.addObject("page",page);
      modelAndView.setViewName("student/main");
      return modelAndView;
  }

  @RequestMapping(value = "/personal",method = RequestMethod.GET)
  public ModelAndView personal(){
      String page = new String("personal");
      modelAndView.addObject("page",page);
      modelAndView.setViewName("student/main");
      return modelAndView;
  }

  @RequestMapping(value = "/logout",method = RequestMethod.GET)
  public ModelAndView logout(HttpServletRequest request){
      HttpSession session = request.getSession();
      session.invalidate();
      modelAndView.clear();
      modelAndView.setViewName("redirect:/");
      return modelAndView;
  }





}

package com.vzard.mycms.controller;


import com.vzard.mycms.database.tables.pojos.Course;
import com.vzard.mycms.database.tables.pojos.Student;
import com.vzard.mycms.database.tables.pojos.StudentCourse;
import com.vzard.mycms.model.ResponseModel;
import com.vzard.mycms.model.dto.CourseWithCurrentStudentNumber;
import com.vzard.mycms.model.dto.CourseWithGrade;
import com.vzard.mycms.model.dto.LoginParam;
import com.vzard.mycms.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


@RequestMapping(path = "student")
@Controller
public class StudentController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentService studentService;

    private ModelAndView modelAndView = new ModelAndView();

    @RequestMapping(value = "/main",method = RequestMethod.POST)
  public ModelAndView login(HttpServletRequest request, LoginParam loginParam){

        //logger.info(loginParam.getNumber());
        Student student = studentService.getStudentByNumber(loginParam.getNumber());
        logger.info(student.toString());
        //logger.info(student.getName());
        String verifyCode = (String)request.getSession().getAttribute("verifyCode");
        //logger.info(student.getPassword());
        //logger.info(verifyCode);
        if (null != student && verifyCode.equals(loginParam.getVerifycode()) && student.getPassword().equals(loginParam.getPassword())){
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

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        modelAndView.clear();
        modelAndView.setViewName("redirect:/");
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




  @RequestMapping(value = "/update",method = RequestMethod.POST)
  @ResponseBody
  public Student updatePersonalInfo(@RequestBody Student student){
      logger.info(student.getClbum());
      Student student1 = studentService.modifyPersonInfo(student);
      return student1;

  }


  @RequestMapping(value = "/courselist/{num}",method = RequestMethod.GET)
  @ResponseBody
  public ResponseModel<List<CourseWithCurrentStudentNumber>> getCourseList(@PathVariable(value = "num") String num){
      List<CourseWithCurrentStudentNumber> courseList = studentService.getCourseList(num);
      return ResponseModel.builder()
              .code(0)
              .message("")
              .count(new Long(courseList.size()))
              .data(courseList)
              .build();
  }

  @RequestMapping(value = "/course",method = RequestMethod.POST)
  @ResponseBody
  public StudentCourse chooseCourse(@RequestBody StudentCourse studentCourse){
      // logger.info(studentCourse.getStudentNum());
      return studentService.chooseCourse(studentCourse);
  }

    @RequestMapping(value = "/course",method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseModel<Course> deleteCourse(@RequestBody StudentCourse studentCourse, HttpServletResponse response) {
        logger.info(studentCourse.getStudentNum());
        studentService.deleteCourse(studentCourse.getStudentNum(),studentCourse.getCourseNum());

        return ResponseModel.builder()
                .code(response.getStatus())
                .message("Success")
                .data(null)
                .build();
    }



    @RequestMapping(value = "/course/{num}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseModel<List<CourseWithGrade>> getChoosedCourse(@PathVariable String num,int page,int limit){
        List<CourseWithGrade> courseWithGradeList = studentService.getChoosedCourse(num, page, limit);
        return ResponseModel.builder()
                .code(0)
                .count(new Long(courseWithGradeList.size()))
                .message("")
                .data(courseWithGradeList)
                .build();
    }









}

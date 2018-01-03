package com.vzard.mycms.controller;


import com.vzard.mycms.database.tables.pojos.Admin;
import com.vzard.mycms.database.tables.pojos.Student;
import com.vzard.mycms.database.tables.pojos.Teacher;
import com.vzard.mycms.model.ResponseModel;
import com.vzard.mycms.model.dto.LoginParam;
import com.vzard.mycms.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(path = "admin")
public class AdminController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AdminService adminService;

    private ModelAndView modelAndView = new ModelAndView();

    @RequestMapping(value = "/main",method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, LoginParam loginParam){
        Admin admin = adminService.getAdminByNumber(loginParam.getNumber());
        String verifyCode = (String)request.getSession().getAttribute("verifyCode");
        if (null != admin && admin.getPassword().equals(loginParam.getPassword()) && verifyCode.equals(loginParam.getVerifycode())){
        String sessionId = request.getSession().getId();
        request.getSession().setAttribute(sessionId,admin);
        modelAndView.addObject("admin",admin);
        modelAndView.addObject("page",new String("welcome"));
        modelAndView.setViewName("admin/main");

        }else {
            request.getSession().invalidate();
            modelAndView.setViewName("redirect:/admin");
        }


        return modelAndView;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        modelAndView.clear();
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

    @RequestMapping(value = "/post-student",method = RequestMethod.GET)
    public ModelAndView postStudent(){
        modelAndView.addObject("page",new String("post_student"));
        modelAndView.setViewName("admin/main");
        return modelAndView;
    }

    @RequestMapping(value = "/post-teacher",method = RequestMethod.GET)
    public ModelAndView postTeacher(){
        modelAndView.addObject("page",new String("post_teacher"));
        modelAndView.setViewName("admin/main");
        return modelAndView;
    }

    @RequestMapping(value = "/edit-teacher",method = RequestMethod.GET)
    public ModelAndView editTeacher(){
        modelAndView.addObject("page",new String("edit_teacher"));
        modelAndView.setViewName("admin/main");
        return modelAndView;
    }

    @RequestMapping(value = "/edit-student",method = RequestMethod.GET)
    public ModelAndView editStudent(){
        modelAndView.addObject("page",new String("edit_student"));
        modelAndView.setViewName("admin/main");
        return modelAndView;
    }

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    @ResponseBody
    public ResponseModel<List<Student>> getStudentList(){
        List<Student> studentList = adminService.getStudentList();
        return ResponseModel.builder()
                .code(0)
                .message("")
                .data(studentList)
                .count(new Long(studentList.size()))
                .build();
    }

    @RequestMapping(value = "/student",method = RequestMethod.PUT)
    @ResponseBody
    public Student updateStudentInfo(@RequestBody Student student){
       Student student1 =  adminService.alertStudentInfo(student);
       return student;
    }

    @RequestMapping(value = "/student",method = RequestMethod.POST)
    @ResponseBody
    public Student addStudentInfo(@RequestBody Student student){
        Student student1 =  adminService.addStudentInfo(student);
        return student;
    }

    @RequestMapping(value = "/student/{num}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseModel<Student> deleteStudentByNumber(@PathVariable("num") String num){
        adminService.deleteStudentInfo(num);
        return ResponseModel.builder()
                .code(0)
                .message("success")
                .data(null)
                .build();
    }

    @RequestMapping(value = "/teacher",method = RequestMethod.GET)
    @ResponseBody
    public ResponseModel<List<Teacher>> getTeacherList(){
        List<Teacher> teacherList = adminService.getTeacherList();
        return ResponseModel.builder()
                .code(0)
                .message("")
                .count(new Long(teacherList.size()))
                .data(teacherList)
                .build();
    }

    @RequestMapping(value = "/teacher",method = RequestMethod.PUT)
    @ResponseBody
    public Teacher updateTeacherInfo(@RequestBody Teacher teacher){
        Teacher teacher1 = adminService.alertTeacherInfo(teacher);
        return teacher1;
    }

    @RequestMapping(value = "/teacher",method = RequestMethod.POST)
    @ResponseBody
    public Teacher addTeacherInfo(@RequestBody Teacher teacher){
        Teacher teacher1 = adminService.addTeacherInfo(teacher);
        return teacher1;
    }

    @RequestMapping(value = "/teacher/{num}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseModel deleteTeacherByNumber(@PathVariable("num") String num){
        adminService.deleteTeacherInfo(num);
        return ResponseModel.builder()
                .code(0)
                .message("success")
                .data(null)
                .build();
    }


}

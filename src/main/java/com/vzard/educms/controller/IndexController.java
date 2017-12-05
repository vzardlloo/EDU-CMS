package com.vzard.educms.controller;


import com.sun.org.apache.regexp.internal.RE;
import com.vzard.educms.database.tables.pojos.Student;
import com.vzard.educms.model.dto.LoginParam;
import com.vzard.educms.model.dto.RegisterParam;
import com.vzard.educms.service.AccountService;
import com.vzard.educms.service.StudentService;
import com.vzard.educms.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class IndexController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String home(RegisterParam param){

        return "home";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request,LoginParam param){
        ModelAndView modelAndView = new ModelAndView();
        if (accountService.login(param)){
            modelAndView.setViewName("home");
            modelAndView.addObject("student",param);
            SessionUtil.setSession(request,param);
        }else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public ModelAndView register(HttpServletRequest request,Student student){
        ModelAndView modelAndView = new ModelAndView();
        accountService.register(student);
        if (accountService.isRegister(student.getNumber())){
            modelAndView.setViewName("home");
            modelAndView.addObject("student",student);
            SessionUtil.setSession(request,student);
        }else {
            modelAndView.setViewName("login");
        }

        return modelAndView;
    }


    @RequestMapping(value = "/to-login",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "/to-register",method = RequestMethod.GET)
    public String toRegister(){
        return "register";
    }


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){

        return "index";
    }








}

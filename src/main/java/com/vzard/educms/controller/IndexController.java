package com.vzard.educms.controller;


import com.sun.org.apache.regexp.internal.RE;
import com.vzard.educms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;
import java.util.Date;

@Controller
public class IndexController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home(){

        return "home";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){

        return "index";
    }






}

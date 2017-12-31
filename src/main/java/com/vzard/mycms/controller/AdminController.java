package com.vzard.mycms.controller;

import com.vzard.mycms.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AdminService adminService;

    private ModelAndView modelAndView = new ModelAndView();

    public ModelAndView login(){

        return modelAndView;
    }

    

}

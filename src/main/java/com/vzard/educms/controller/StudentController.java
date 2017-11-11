package com.vzard.educms.controller;

import com.sun.deploy.net.HttpResponse;
import com.sun.xml.internal.ws.client.ResponseContext;
import com.vzard.educms.database.tables.pojos.Student;
import com.vzard.educms.model.ResponesModel;
import com.vzard.educms.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: vzard
 * Date: 2017/11/11
 * Time: 23:17
 * To change this template use File | Settings | File Templates.
 * Description:
 **/
@RestController
@Api(tags = "student",description = "关于学生的操作")
public class StudentController {

    @Autowired
    StudentService studentService;

@ApiOperation(value = "根据学号获取学生信息")
@RequestMapping(value = "student/{number}",method = RequestMethod.GET)
public ResponesModel<Student> getStudentByNumber(@ApiParam(name = "number")@PathVariable String number){

    Student student = studentService.getStudentByNumber(number);

    return ResponesModel.builder().data(student).build();

}





}

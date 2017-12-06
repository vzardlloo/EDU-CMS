package com.vzard.educms.controller;


import com.vzard.educms.constant.ErrorConstant;
import com.vzard.educms.constant.StatusConstant;
import com.vzard.educms.database.tables.pojos.Course;
import com.vzard.educms.database.tables.pojos.Student;
import com.vzard.educms.error.EduErrorException;
import com.vzard.educms.model.ResponesModel;
import com.vzard.educms.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: vzard
 * Date: 2017/11/11
 * Time: 23:17
 * To change this template use File | Settings | File Templates.
 * Description:
 **/
@RestController
@Api(tags = "student", description = "关于学生的操作")
public class StudentController {

    @Autowired
    StudentService studentService;

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @ApiOperation(value = "根据学号获取课程信息")
    @RequestMapping(value = "student/{number}/course",method = RequestMethod.GET)
    public ResponesModel<List<Course>> getCourseRecordByStudentNumber(@PathVariable(value = "number") String number){
        List<Course> courseList = studentService.getCourseRecordByStudentNumber(number);
        if (null == courseList){
            throw new EduErrorException(ErrorConstant.ERROR_MSG_USER_NOT_FOUND, ErrorConstant.ERROR_CODE_USER_NOT_FOUND);
        }

        return ResponesModel.builder().code(StatusConstant.STATUS_CODE_SUCCESS).message(StatusConstant.STATUS_INFO_SUCCESS).data(courseList).build();

    }

    @ApiOperation(value = "根据学号获取学生信息")
    @RequestMapping(value = "student/{number}", method = RequestMethod.GET)
    public ResponesModel<Student> getStudentByNumber(@ApiParam(name = "number") @PathVariable String number) {

        Student student = studentService.getStudentByNumber(number);
        if (null == student)
            //logger.info(student.toString());
            throw new EduErrorException(ErrorConstant.ERROR_MSG_USER_NOT_FOUND, ErrorConstant.ERROR_CODE_USER_NOT_FOUND);

        return ResponesModel.builder().code(StatusConstant.STATUS_CODE_SUCCESS).message(StatusConstant.STATUS_INFO_SUCCESS).data(student).build();

    }


    @ApiOperation(value = "增加一条学生信息")
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public ResponesModel<Student> addStudentinfo(@RequestBody Student student) {
        logger.info("studentInfo: " + student.toString());
        if (null == student) {

            throw new EduErrorException(ErrorConstant.ERROR_MSG_USER_INFO_NOT_NULL, ErrorConstant.ERROR_CODE_USER_INFO_NOT_NULL);
        } else if (null == student.getName() || student.getName().equals("")) {
            logger.info("studentName: " + student.getName());
            throw new EduErrorException(ErrorConstant.ERROR_MSG_USER_NAME_NOT_NULL, ErrorConstant.ERROR_CODE_USER_NAME_NOT_NULL);
        } else if (student.getPassword().length() < 8) {
            logger.info("studentPassword :" + student.getPassword());
            throw new EduErrorException(ErrorConstant.ERROR_MSG_USER_PASSWORD_SHORT_ERROR, ErrorConstant.ERROR_CODE_USER_PASSWORD_SHORT_ERROR);
        }

        return ResponesModel.builder()
                .code(StatusConstant.STATUS_CODE_CREATE)
                .message(StatusConstant.STATUS_INFO_CREATED)
                .data(studentService.addStudentInfo(student))
                .build();

    }

    @ApiOperation(value = "更新一条学生信息")
    @RequestMapping(value = "/student", method = RequestMethod.PUT)
    public ResponesModel<Student> updateStudentInfo(@RequestBody Student student) {

        logger.info("studentInfo: " + student.toString());
        if (null == student) {

            throw new EduErrorException(ErrorConstant.ERROR_MSG_USER_INFO_NOT_NULL, ErrorConstant.ERROR_CODE_USER_INFO_NOT_NULL);
        } else if (null == student.getName() || student.getName().equals("")) {
            logger.info("studentName: " + student.getName());
            throw new EduErrorException(ErrorConstant.ERROR_MSG_USER_NAME_NOT_NULL, ErrorConstant.ERROR_CODE_USER_NAME_NOT_NULL);
        } else if (student.getPassword().length() < 8) {
            logger.info("studentPassword :" + student.getPassword());
            throw new EduErrorException(ErrorConstant.ERROR_MSG_USER_PASSWORD_SHORT_ERROR, ErrorConstant.ERROR_CODE_USER_PASSWORD_SHORT_ERROR);
        }

        return ResponesModel.builder()
                .code(StatusConstant.STATUS_CODE_CREATE)
                .message(StatusConstant.STATUS_INFO_CREATED)
                .data(studentService.updataStudentInfo(student))
                .build();

    }


    @ApiOperation(value = "删除一条学生信息")
    @RequestMapping(value = "/student", method = RequestMethod.DELETE)
    public ResponesModel<Student> deleteStudentInfo(String number) {

        studentService.deleteStudentInfo(number);

        if (!studentService.isStudentExist(number)) {
            return ResponesModel.builder()
                    .code(StatusConstant.STATUS_CODE_ACCEPTED)
                    .message(StatusConstant.STATUS_INFO_ACCEPTED)
                    .build();
        }

        return ResponesModel.builder()
                .code(StatusConstant.STATUS_CODE_SERVER_ERROR)
                .message(StatusConstant.STATUS_INFO_SERVER_ERROR)
                .build();

    }


}

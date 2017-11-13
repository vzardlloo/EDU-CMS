package com.vzard.educms.controller;

import com.vzard.educms.constant.ErrorConstant;
import com.vzard.educms.constant.StatusConstant;
import com.vzard.educms.database.tables.pojos.Student;
import com.vzard.educms.database.tables.pojos.Teacher;
import com.vzard.educms.error.EduErrorException;
import com.vzard.educms.model.ResponesModel;
import com.vzard.educms.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: vzard
 * Date: 2017/11/13
 * Time: 12:24
 * To change this template use File | Settings | File Templates.
 * Description:
 **/

@RestController
@Api(tags = "teacher",description = "关于教师的操作")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @ApiOperation(value = "根据教师编号获取教师信息")
    @RequestMapping(value = "teacher/{number}", method = RequestMethod.GET)
    public ResponesModel<Student> getStudentByNumber(@ApiParam(name = "number") @PathVariable String number) {

        Teacher teacher = teacherService.getTeacherInfoByNumber(number);
        if (null == teacher)
            //logger.info(student.toString());
            throw new EduErrorException(ErrorConstant.ERROR_MSG_USER_NOT_FOUND, ErrorConstant.ERROR_CODE_USER_NOT_FOUND);

        return ResponesModel.builder().code(StatusConstant.STATUS_CODE_SUCCESS).message(StatusConstant.STATUS_INFO_SUCCESS).data(teacher).build();

    }


    @ApiOperation(value = "增加一条教师信息")
    @RequestMapping(value = "/teacher", method = RequestMethod.POST)
    public ResponesModel<Student> addTeacherinfo(@RequestBody Teacher teacher) {
        logger.info("studentInfo: " + teacher.toString());
        if (null == teacher) {

            throw new EduErrorException(ErrorConstant.ERROR_MSG_USER_INFO_NOT_NULL, ErrorConstant.ERROR_CODE_USER_INFO_NOT_NULL);
        } else if (null == teacher.getName() || teacher.getName().equals("")) {
            //           logger.info("studentName: " + teacher.getName());
            throw new EduErrorException(ErrorConstant.ERROR_MSG_USER_NAME_NOT_NULL, ErrorConstant.ERROR_CODE_USER_NAME_NOT_NULL);
        }

        return ResponesModel.builder()
                .code(StatusConstant.STATUS_CODE_CREATE)
                .message(StatusConstant.STATUS_INFO_CREATED)
                .data(teacherService.addTeacherInfo(teacher))
                .build();


    }

    @ApiOperation(value = "更新一条教师信息")
    @RequestMapping(value = "/teacher", method = RequestMethod.PUT)
    public ResponesModel<Student> updateStudentInfo(@RequestBody Teacher teacher) {

//        logger.info("studentInfo: " + student.toString());
        if (null == teacher) {

            throw new EduErrorException(ErrorConstant.ERROR_MSG_USER_INFO_NOT_NULL, ErrorConstant.ERROR_CODE_USER_INFO_NOT_NULL);
        } else if (null == teacher.getName() || teacher.getName().equals("")) {
//            logger.info("studentName: " + teacher.getName());
            throw new EduErrorException(ErrorConstant.ERROR_MSG_USER_NAME_NOT_NULL, ErrorConstant.ERROR_CODE_USER_NAME_NOT_NULL);
        }

        return ResponesModel.builder()
                .code(StatusConstant.STATUS_CODE_CREATE)
                .message(StatusConstant.STATUS_INFO_CREATED)
                .data(teacherService.updateTeacherInfo(teacher))
                .build();

    }


    @ApiOperation(value = "删除一条教师信息")
    @RequestMapping(value = "/teacher", method = RequestMethod.DELETE)
    public ResponesModel<Student> deleteStudentInfo(String number) {

        teacherService.deleteTeacherInfo(number);

        if (!teacherService.isTeacherExist(number)) {
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

package com.vzard.educms.mapper;


import com.vzard.educms.database.tables.interfaces.ITeacher;
import com.vzard.educms.database.tables.pojos.Teacher;

/**
 * Created with IntelliJ IDEA.
 * User: vzard
 * Date: 2017/11/13
 * Time: 12:06
 * To change this template use File | Settings | File Templates.
 * Description:
 **/

public class TeacherMapper {


    public static Teacher mapToDao(ITeacher iteacher) {

        if (null == iteacher) return null;

        Teacher teacher = new Teacher();

        teacher.setName(iteacher.getName());
        teacher.setGender(iteacher.getGender());
        teacher.setNumber(iteacher.getNumber());
        teacher.setOffice(iteacher.getOffice());
        teacher.setPhoneNumber(iteacher.getPhoneNumber());
        teacher.setTitle(iteacher.getTitle());

        return teacher;

    }


}

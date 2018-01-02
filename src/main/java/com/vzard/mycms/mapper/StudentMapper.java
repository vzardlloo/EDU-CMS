package com.vzard.mycms.mapper;


import com.vzard.mycms.database.tables.interfaces.IGrade;
import com.vzard.mycms.database.tables.interfaces.IStudent;
import com.vzard.mycms.database.tables.pojos.Student;
import com.vzard.mycms.model.dto.StudentDto;
import com.vzard.mycms.model.dto.StudentWithGrade;
import org.springframework.beans.BeanUtils;

public class StudentMapper {


    public static Student mapToVo(IStudent iStudent){
        if (null == iStudent) return null;
        Student student = new Student();
        student.setId(iStudent.getId());
        student.setName(iStudent.getName());
        student.setNumber(iStudent.getNumber());
        student.setPassword(iStudent.getPassword());
        student.setGender(iStudent.getGender());
        student.setBirthday(iStudent.getBirthday());
        student.setClbum(iStudent.getClbum());
        student.setAcademy(iStudent.getAcademy());
        student.setCreatedAt(iStudent.getCreatedAt());
        student.setUpdatedAt(iStudent.getUpdatedAt());
        return student;
    }


    public static StudentWithGrade mapToDto(IStudent iStudent, IGrade iGrade){
        if (null == iStudent && null == iGrade){
            return null;
        }
        StudentWithGrade studentWithGrade = new StudentWithGrade();
        BeanUtils.copyProperties(iStudent,studentWithGrade);
        BeanUtils.copyProperties(iGrade,studentWithGrade);
        if (studentWithGrade.getPaperGrade()   == null ||
            studentWithGrade.getPacificGrade() == null ||
            studentWithGrade.getOverallGrade() == null  ){
            studentWithGrade.setPaperGrade("0");
            studentWithGrade.setPacificGrade("0");
            studentWithGrade.setOverallGrade("0");
        }

        return studentWithGrade;
    }





}

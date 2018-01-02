package com.vzard.mycms.model.dto;


import lombok.Data;

/**
 * 教师发布成绩的dto
 */
@Data
public class StudentWithGrade {

    //这里要保持和jooq对应字段名称一致
    private String number;
    private String name;
    private String courseNum;
    private String courseName;
    private String pacificGrade;
    private String paperGrade;
    private String overallGrade;

}

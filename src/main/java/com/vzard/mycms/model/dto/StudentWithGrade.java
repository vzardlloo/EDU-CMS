package com.vzard.mycms.model.dto;


import lombok.Data;

/**
 * 教师发布成绩的dto
 */
@Data
public class StudentWithGrade {

    private String studentNumber;
    private String studentName;
    private String courseName;
    private String pacificGrade;
    private String paperGrade;
    private String overallGrade;

}

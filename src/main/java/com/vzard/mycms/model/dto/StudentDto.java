package com.vzard.mycms.model.dto;


import lombok.Data;

import java.sql.Timestamp;


@Data
public class StudentDto {

    private String    password;
    private String    gender;
    private Timestamp birthday;
    private String    clbum;
    private String    academy;


}

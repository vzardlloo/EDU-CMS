package com.vzard.mycms.model.dto;


public class CourseWithCurrentStudentNumber {

    private Integer   id;
    private String    studentNumber;
    private String    number;
    private String    name;
    private String    credit;
    private String    period;
    private String    teacher;
    private String    time;
    private String    classroom;
    private Long      maxChoosed;
    private Long      hasChoosed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Long getMaxChoosed() {
        return maxChoosed;
    }

    public void setMaxChoosed(Long maxChoosed) {
        this.maxChoosed = maxChoosed;
    }

    public Long getHasChoosed() {
        return hasChoosed;
    }

    public void setHasChoosed(Long hasChoosed) {
        this.hasChoosed = hasChoosed;
    }
}

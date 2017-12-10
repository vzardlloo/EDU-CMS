/*
 * This file is generated by jOOQ.
*/
package com.vzard.mycms.database.tables.pojos;


import com.vzard.mycms.database.tables.interfaces.IStudent;

import java.sql.Timestamp;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Student implements IStudent {

    private static final long serialVersionUID = 1020979536;

    private Long      number;
    private String    name;
    private String    password;
    private String    gender;
    private Timestamp birthday;
    private String    class_;
    private String    academy;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Student() {}

    public Student(Student value) {
        this.number = value.number;
        this.name = value.name;
        this.password = value.password;
        this.gender = value.gender;
        this.birthday = value.birthday;
        this.class_ = value.class_;
        this.academy = value.academy;
        this.createdAt = value.createdAt;
        this.updatedAt = value.updatedAt;
    }

    public Student(
        Long      number,
        String    name,
        String    password,
        String    gender,
        Timestamp birthday,
        String    class_,
        String    academy,
        Timestamp createdAt,
        Timestamp updatedAt
    ) {
        this.number = number;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.class_ = class_;
        this.academy = academy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public Long getNumber() {
        return this.number;
    }

    @Override
    public Student setNumber(Long number) {
        this.number = number;
        return this;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Student setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public Student setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String getGender() {
        return this.gender;
    }

    @Override
    public Student setGender(String gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public Timestamp getBirthday() {
        return this.birthday;
    }

    @Override
    public Student setBirthday(Timestamp birthday) {
        this.birthday = birthday;
        return this;
    }

    @Override
    public String getClass_() {
        return this.class_;
    }

    @Override
    public Student setClass_(String class_) {
        this.class_ = class_;
        return this;
    }

    @Override
    public String getAcademy() {
        return this.academy;
    }

    @Override
    public Student setAcademy(String academy) {
        this.academy = academy;
        return this;
    }

    @Override
    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public Student setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @Override
    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    @Override
    public Student setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Student (");

        sb.append(number);
        sb.append(", ").append(name);
        sb.append(", ").append(password);
        sb.append(", ").append(gender);
        sb.append(", ").append(birthday);
        sb.append(", ").append(class_);
        sb.append(", ").append(academy);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(updatedAt);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public void from(IStudent from) {
        setNumber(from.getNumber());
        setName(from.getName());
        setPassword(from.getPassword());
        setGender(from.getGender());
        setBirthday(from.getBirthday());
        setClass_(from.getClass_());
        setAcademy(from.getAcademy());
        setCreatedAt(from.getCreatedAt());
        setUpdatedAt(from.getUpdatedAt());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends IStudent> E into(E into) {
        into.from(this);
        return into;
    }
}

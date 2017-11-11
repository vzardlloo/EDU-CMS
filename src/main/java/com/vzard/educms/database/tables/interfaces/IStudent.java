/*
 * This file is generated by jOOQ.
*/
package com.vzard.educms.database.tables.interfaces;


import java.io.Serializable;

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
public interface IStudent extends Serializable {

    /**
     * Setter for <code>edu-cms.student.number</code>. 学号
     */
    public IStudent setNumber(String value);

    /**
     * Getter for <code>edu-cms.student.number</code>. 学号
     */
    public String getNumber();

    /**
     * Setter for <code>edu-cms.student.name</code>. 姓名
     */
    public IStudent setName(String value);

    /**
     * Getter for <code>edu-cms.student.name</code>. 姓名
     */
    public String getName();

    /**
     * Setter for <code>edu-cms.student.password</code>. 登录密码
     */
    public IStudent setPassword(String value);

    /**
     * Getter for <code>edu-cms.student.password</code>. 登录密码
     */
    public String getPassword();

    /**
     * Setter for <code>edu-cms.student.gender</code>. 性别
     */
    public IStudent setGender(String value);

    /**
     * Getter for <code>edu-cms.student.gender</code>. 性别
     */
    public String getGender();

    /**
     * Setter for <code>edu-cms.student.brithday</code>. 生日
     */
    public IStudent setBrithday(String value);

    /**
     * Getter for <code>edu-cms.student.brithday</code>. 生日
     */
    public String getBrithday();

    /**
     * Setter for <code>edu-cms.student.address</code>. 地址
     */
    public IStudent setAddress(String value);

    /**
     * Getter for <code>edu-cms.student.address</code>. 地址
     */
    public String getAddress();

    /**
     * Setter for <code>edu-cms.student.phone_number</code>. 电话号码
     */
    public IStudent setPhoneNumber(String value);

    /**
     * Getter for <code>edu-cms.student.phone_number</code>. 电话号码
     */
    public String getPhoneNumber();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IStudent
     */
    public void from(com.vzard.educms.database.tables.interfaces.IStudent from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IStudent
     */
    public <E extends com.vzard.educms.database.tables.interfaces.IStudent> E into(E into);
}

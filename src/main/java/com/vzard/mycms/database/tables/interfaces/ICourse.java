/*
 * This file is generated by jOOQ.
*/
package com.vzard.mycms.database.tables.interfaces;


import java.io.Serializable;
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
public interface ICourse extends Serializable {

    /**
     * Setter for <code>my-cms.course.number</code>. 课程号
     */
    public ICourse setNumber(Long value);

    /**
     * Getter for <code>my-cms.course.number</code>. 课程号
     */
    public Long getNumber();

    /**
     * Setter for <code>my-cms.course.name</code>. 课程名称
     */
    public ICourse setName(String value);

    /**
     * Getter for <code>my-cms.course.name</code>. 课程名称
     */
    public String getName();

    /**
     * Setter for <code>my-cms.course.credit</code>. 学分
     */
    public ICourse setCredit(String value);

    /**
     * Getter for <code>my-cms.course.credit</code>. 学分
     */
    public String getCredit();

    /**
     * Setter for <code>my-cms.course.period</code>. 学时
     */
    public ICourse setPeriod(String value);

    /**
     * Getter for <code>my-cms.course.period</code>. 学时
     */
    public String getPeriod();

    /**
     * Setter for <code>my-cms.course.teacher</code>. 任课教师
     */
    public ICourse setTeacher(String value);

    /**
     * Getter for <code>my-cms.course.teacher</code>. 任课教师
     */
    public String getTeacher();

    /**
     * Setter for <code>my-cms.course.classroom</code>. 上课教室
     */
    public ICourse setClassroom(String value);

    /**
     * Getter for <code>my-cms.course.classroom</code>. 上课教室
     */
    public String getClassroom();

    /**
     * Setter for <code>my-cms.course.max_choosed</code>. 最大容量
     */
    public ICourse setMaxChoosed(Long value);

    /**
     * Getter for <code>my-cms.course.max_choosed</code>. 最大容量
     */
    public Long getMaxChoosed();

    /**
     * Setter for <code>my-cms.course.has_choosed</code>. 已选人数
     */
    public ICourse setHasChoosed(Long value);

    /**
     * Getter for <code>my-cms.course.has_choosed</code>. 已选人数
     */
    public Long getHasChoosed();

    /**
     * Setter for <code>my-cms.course.created_at</code>. 创建时间
     */
    public ICourse setCreatedAt(Timestamp value);

    /**
     * Getter for <code>my-cms.course.created_at</code>. 创建时间
     */
    public Timestamp getCreatedAt();

    /**
     * Setter for <code>my-cms.course.updated_at</code>. 更新时间
     */
    public ICourse setUpdatedAt(Timestamp value);

    /**
     * Getter for <code>my-cms.course.updated_at</code>. 更新时间
     */
    public Timestamp getUpdatedAt();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface ICourse
     */
    public void from(com.vzard.mycms.database.tables.interfaces.ICourse from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface ICourse
     */
    public <E extends com.vzard.mycms.database.tables.interfaces.ICourse> E into(E into);
}

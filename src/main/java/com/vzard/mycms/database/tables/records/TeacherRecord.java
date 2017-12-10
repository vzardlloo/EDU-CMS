/*
 * This file is generated by jOOQ.
*/
package com.vzard.mycms.database.tables.records;


import com.vzard.mycms.database.tables.Teacher;
import com.vzard.mycms.database.tables.interfaces.ITeacher;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


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
public class TeacherRecord extends UpdatableRecordImpl<TeacherRecord> implements Record8<Long, String, String, String, String, String, Timestamp, Timestamp>, ITeacher {

    private static final long serialVersionUID = -935692810;

    /**
     * Setter for <code>my-cms.teacher.number</code>. 工号
     */
    @Override
    public TeacherRecord setNumber(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>my-cms.teacher.number</code>. 工号
     */
    @Override
    public Long getNumber() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>my-cms.teacher.name</code>. 姓名
     */
    @Override
    public TeacherRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>my-cms.teacher.name</code>. 姓名
     */
    @Override
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>my-cms.teacher.password</code>. 密码
     */
    @Override
    public TeacherRecord setPassword(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>my-cms.teacher.password</code>. 密码
     */
    @Override
    public String getPassword() {
        return (String) get(2);
    }

    /**
     * Setter for <code>my-cms.teacher.gender</code>. 性别
     */
    @Override
    public TeacherRecord setGender(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>my-cms.teacher.gender</code>. 性别
     */
    @Override
    public String getGender() {
        return (String) get(3);
    }

    /**
     * Setter for <code>my-cms.teacher.office</code>. 办公室
     */
    @Override
    public TeacherRecord setOffice(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>my-cms.teacher.office</code>. 办公室
     */
    @Override
    public String getOffice() {
        return (String) get(4);
    }

    /**
     * Setter for <code>my-cms.teacher.academy</code>. 所在学院
     */
    @Override
    public TeacherRecord setAcademy(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>my-cms.teacher.academy</code>. 所在学院
     */
    @Override
    public String getAcademy() {
        return (String) get(5);
    }

    /**
     * Setter for <code>my-cms.teacher.created_at</code>. 创建时间
     */
    @Override
    public TeacherRecord setCreatedAt(Timestamp value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>my-cms.teacher.created_at</code>. 创建时间
     */
    @Override
    public Timestamp getCreatedAt() {
        return (Timestamp) get(6);
    }

    /**
     * Setter for <code>my-cms.teacher.update_at</code>. 更新时间
     */
    @Override
    public TeacherRecord setUpdateAt(Timestamp value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>my-cms.teacher.update_at</code>. 更新时间
     */
    @Override
    public Timestamp getUpdateAt() {
        return (Timestamp) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Long, String, String, String, String, String, Timestamp, Timestamp> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Long, String, String, String, String, String, Timestamp, Timestamp> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Teacher.TEACHER.NUMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Teacher.TEACHER.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Teacher.TEACHER.PASSWORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Teacher.TEACHER.GENDER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Teacher.TEACHER.OFFICE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Teacher.TEACHER.ACADEMY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field7() {
        return Teacher.TEACHER.CREATED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field8() {
        return Teacher.TEACHER.UPDATE_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getGender();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getOffice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getAcademy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value7() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value8() {
        return getUpdateAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TeacherRecord value1(Long value) {
        setNumber(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TeacherRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TeacherRecord value3(String value) {
        setPassword(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TeacherRecord value4(String value) {
        setGender(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TeacherRecord value5(String value) {
        setOffice(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TeacherRecord value6(String value) {
        setAcademy(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TeacherRecord value7(Timestamp value) {
        setCreatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TeacherRecord value8(Timestamp value) {
        setUpdateAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TeacherRecord values(Long value1, String value2, String value3, String value4, String value5, String value6, Timestamp value7, Timestamp value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public void from(ITeacher from) {
        setNumber(from.getNumber());
        setName(from.getName());
        setPassword(from.getPassword());
        setGender(from.getGender());
        setOffice(from.getOffice());
        setAcademy(from.getAcademy());
        setCreatedAt(from.getCreatedAt());
        setUpdateAt(from.getUpdateAt());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends ITeacher> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TeacherRecord
     */
    public TeacherRecord() {
        super(Teacher.TEACHER);
    }

    /**
     * Create a detached, initialised TeacherRecord
     */
    public TeacherRecord(Long number, String name, String password, String gender, String office, String academy, Timestamp createdAt, Timestamp updateAt) {
        super(Teacher.TEACHER);

        set(0, number);
        set(1, name);
        set(2, password);
        set(3, gender);
        set(4, office);
        set(5, academy);
        set(6, createdAt);
        set(7, updateAt);
    }
}

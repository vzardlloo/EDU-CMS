/*
 * This file is generated by jOOQ.
*/
package com.vzard.mycms.database.tables.records;


import com.vzard.mycms.database.tables.StudentCourse;
import com.vzard.mycms.database.tables.interfaces.IStudentCourse;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
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
public class StudentCourseRecord extends UpdatableRecordImpl<StudentCourseRecord> implements Record5<Long, Long, Long, Timestamp, Timestamp>, IStudentCourse {

    private static final long serialVersionUID = -153368484;

    /**
     * Setter for <code>my-cms.student_course.id</code>. id
     */
    @Override
    public StudentCourseRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>my-cms.student_course.id</code>. id
     */
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>my-cms.student_course.student_num</code>. 学号
     */
    @Override
    public StudentCourseRecord setStudentNum(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>my-cms.student_course.student_num</code>. 学号
     */
    @Override
    public Long getStudentNum() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>my-cms.student_course.course_num</code>. 课程号
     */
    @Override
    public StudentCourseRecord setCourseNum(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>my-cms.student_course.course_num</code>. 课程号
     */
    @Override
    public Long getCourseNum() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>my-cms.student_course.created_at</code>. 创建时间
     */
    @Override
    public StudentCourseRecord setCreatedAt(Timestamp value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>my-cms.student_course.created_at</code>. 创建时间
     */
    @Override
    public Timestamp getCreatedAt() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>my-cms.student_course.updated_at</code>. 更新时间
     */
    @Override
    public StudentCourseRecord setUpdatedAt(Timestamp value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>my-cms.student_course.updated_at</code>. 更新时间
     */
    @Override
    public Timestamp getUpdatedAt() {
        return (Timestamp) get(4);
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
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Long, Long, Long, Timestamp, Timestamp> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Long, Long, Long, Timestamp, Timestamp> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return StudentCourse.STUDENT_COURSE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return StudentCourse.STUDENT_COURSE.STUDENT_NUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return StudentCourse.STUDENT_COURSE.COURSE_NUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return StudentCourse.STUDENT_COURSE.CREATED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return StudentCourse.STUDENT_COURSE.UPDATED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getStudentNum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getCourseNum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getUpdatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StudentCourseRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StudentCourseRecord value2(Long value) {
        setStudentNum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StudentCourseRecord value3(Long value) {
        setCourseNum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StudentCourseRecord value4(Timestamp value) {
        setCreatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StudentCourseRecord value5(Timestamp value) {
        setUpdatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StudentCourseRecord values(Long value1, Long value2, Long value3, Timestamp value4, Timestamp value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public void from(IStudentCourse from) {
        setId(from.getId());
        setStudentNum(from.getStudentNum());
        setCourseNum(from.getCourseNum());
        setCreatedAt(from.getCreatedAt());
        setUpdatedAt(from.getUpdatedAt());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends IStudentCourse> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached StudentCourseRecord
     */
    public StudentCourseRecord() {
        super(StudentCourse.STUDENT_COURSE);
    }

    /**
     * Create a detached, initialised StudentCourseRecord
     */
    public StudentCourseRecord(Long id, Long studentNum, Long courseNum, Timestamp createdAt, Timestamp updatedAt) {
        super(StudentCourse.STUDENT_COURSE);

        set(0, id);
        set(1, studentNum);
        set(2, courseNum);
        set(3, createdAt);
        set(4, updatedAt);
    }
}
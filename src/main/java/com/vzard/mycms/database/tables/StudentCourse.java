/*
 * This file is generated by jOOQ.
*/
package com.vzard.mycms.database.tables;


import com.vzard.mycms.database.Keys;
import com.vzard.mycms.database.MyCms;
import com.vzard.mycms.database.tables.records.StudentCourseRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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
public class StudentCourse extends TableImpl<StudentCourseRecord> {

    private static final long serialVersionUID = -1036981985;

    /**
     * The reference instance of <code>my-cms.student_course</code>
     */
    public static final StudentCourse STUDENT_COURSE = new StudentCourse();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StudentCourseRecord> getRecordType() {
        return StudentCourseRecord.class;
    }

    /**
     * The column <code>my-cms.student_course.id</code>. id
     */
    public final TableField<StudentCourseRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "id");

    /**
     * The column <code>my-cms.student_course.student_num</code>. 学号
     */
    public final TableField<StudentCourseRecord, Long> STUDENT_NUM = createField("student_num", org.jooq.impl.SQLDataType.BIGINT, this, "学号");

    /**
     * The column <code>my-cms.student_course.course_num</code>. 课程号
     */
    public final TableField<StudentCourseRecord, Long> COURSE_NUM = createField("course_num", org.jooq.impl.SQLDataType.BIGINT, this, "课程号");

    /**
     * The column <code>my-cms.student_course.created_at</code>. 创建时间
     */
    public final TableField<StudentCourseRecord, Timestamp> CREATED_AT = createField("created_at", org.jooq.impl.SQLDataType.TIMESTAMP, this, "创建时间");

    /**
     * The column <code>my-cms.student_course.updated_at</code>. 更新时间
     */
    public final TableField<StudentCourseRecord, Timestamp> UPDATED_AT = createField("updated_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "更新时间");

    /**
     * Create a <code>my-cms.student_course</code> table reference
     */
    public StudentCourse() {
        this("student_course", null);
    }

    /**
     * Create an aliased <code>my-cms.student_course</code> table reference
     */
    public StudentCourse(String alias) {
        this(alias, STUDENT_COURSE);
    }

    private StudentCourse(String alias, Table<StudentCourseRecord> aliased) {
        this(alias, aliased, null);
    }

    private StudentCourse(String alias, Table<StudentCourseRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return MyCms.MY_CMS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<StudentCourseRecord, Long> getIdentity() {
        return Keys.IDENTITY_STUDENT_COURSE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<StudentCourseRecord> getPrimaryKey() {
        return Keys.KEY_STUDENT_COURSE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<StudentCourseRecord>> getKeys() {
        return Arrays.<UniqueKey<StudentCourseRecord>>asList(Keys.KEY_STUDENT_COURSE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StudentCourse as(String alias) {
        return new StudentCourse(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public StudentCourse rename(String name) {
        return new StudentCourse(name, null);
    }
}
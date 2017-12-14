/*
 * This file is generated by jOOQ.
*/
package com.vzard.mycms.database;


import com.vzard.mycms.database.tables.Admin;
import com.vzard.mycms.database.tables.Course;
import com.vzard.mycms.database.tables.Grade;
import com.vzard.mycms.database.tables.Student;
import com.vzard.mycms.database.tables.StudentCourse;
import com.vzard.mycms.database.tables.Teacher;
import com.vzard.mycms.database.tables.TeacherCourse;
import com.vzard.mycms.database.tables.records.AdminRecord;
import com.vzard.mycms.database.tables.records.CourseRecord;
import com.vzard.mycms.database.tables.records.GradeRecord;
import com.vzard.mycms.database.tables.records.StudentCourseRecord;
import com.vzard.mycms.database.tables.records.StudentRecord;
import com.vzard.mycms.database.tables.records.TeacherCourseRecord;
import com.vzard.mycms.database.tables.records.TeacherRecord;

import javax.annotation.Generated;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships between tables of the <code>my-cms</code> 
 * schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<GradeRecord, Long> IDENTITY_GRADE = Identities0.IDENTITY_GRADE;
    public static final Identity<StudentCourseRecord, Long> IDENTITY_STUDENT_COURSE = Identities0.IDENTITY_STUDENT_COURSE;
    public static final Identity<TeacherCourseRecord, Long> IDENTITY_TEACHER_COURSE = Identities0.IDENTITY_TEACHER_COURSE;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AdminRecord> KEY_ADMIN_PRIMARY = UniqueKeys0.KEY_ADMIN_PRIMARY;
    public static final UniqueKey<CourseRecord> KEY_COURSE_PRIMARY = UniqueKeys0.KEY_COURSE_PRIMARY;
    public static final UniqueKey<GradeRecord> KEY_GRADE_PRIMARY = UniqueKeys0.KEY_GRADE_PRIMARY;
    public static final UniqueKey<StudentRecord> KEY_STUDENT_PRIMARY = UniqueKeys0.KEY_STUDENT_PRIMARY;
    public static final UniqueKey<StudentCourseRecord> KEY_STUDENT_COURSE_PRIMARY = UniqueKeys0.KEY_STUDENT_COURSE_PRIMARY;
    public static final UniqueKey<StudentCourseRecord> KEY_STUDENT_COURSE_STU_COURSE = UniqueKeys0.KEY_STUDENT_COURSE_STU_COURSE;
    public static final UniqueKey<TeacherRecord> KEY_TEACHER_PRIMARY = UniqueKeys0.KEY_TEACHER_PRIMARY;
    public static final UniqueKey<TeacherCourseRecord> KEY_TEACHER_COURSE_PRIMARY = UniqueKeys0.KEY_TEACHER_COURSE_PRIMARY;
    public static final UniqueKey<TeacherCourseRecord> KEY_TEACHER_COURSE_TEACHER_COURSE = UniqueKeys0.KEY_TEACHER_COURSE_TEACHER_COURSE;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<GradeRecord, Long> IDENTITY_GRADE = createIdentity(Grade.GRADE, Grade.GRADE.ID);
        public static Identity<StudentCourseRecord, Long> IDENTITY_STUDENT_COURSE = createIdentity(StudentCourse.STUDENT_COURSE, StudentCourse.STUDENT_COURSE.ID);
        public static Identity<TeacherCourseRecord, Long> IDENTITY_TEACHER_COURSE = createIdentity(TeacherCourse.TEACHER_COURSE, TeacherCourse.TEACHER_COURSE.ID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<AdminRecord> KEY_ADMIN_PRIMARY = createUniqueKey(Admin.ADMIN, "KEY_admin_PRIMARY", Admin.ADMIN.NUMBER);
        public static final UniqueKey<CourseRecord> KEY_COURSE_PRIMARY = createUniqueKey(Course.COURSE, "KEY_course_PRIMARY", Course.COURSE.NUMBER);
        public static final UniqueKey<GradeRecord> KEY_GRADE_PRIMARY = createUniqueKey(Grade.GRADE, "KEY_grade_PRIMARY", Grade.GRADE.ID);
        public static final UniqueKey<StudentRecord> KEY_STUDENT_PRIMARY = createUniqueKey(Student.STUDENT, "KEY_student_PRIMARY", Student.STUDENT.NUMBER);
        public static final UniqueKey<StudentCourseRecord> KEY_STUDENT_COURSE_PRIMARY = createUniqueKey(StudentCourse.STUDENT_COURSE, "KEY_student_course_PRIMARY", StudentCourse.STUDENT_COURSE.ID);
        public static final UniqueKey<StudentCourseRecord> KEY_STUDENT_COURSE_STU_COURSE = createUniqueKey(StudentCourse.STUDENT_COURSE, "KEY_student_course_stu_course", StudentCourse.STUDENT_COURSE.STUDENT_NUM, StudentCourse.STUDENT_COURSE.COURSE_NUM);
        public static final UniqueKey<TeacherRecord> KEY_TEACHER_PRIMARY = createUniqueKey(Teacher.TEACHER, "KEY_teacher_PRIMARY", Teacher.TEACHER.NUMBER);
        public static final UniqueKey<TeacherCourseRecord> KEY_TEACHER_COURSE_PRIMARY = createUniqueKey(TeacherCourse.TEACHER_COURSE, "KEY_teacher_course_PRIMARY", TeacherCourse.TEACHER_COURSE.ID);
        public static final UniqueKey<TeacherCourseRecord> KEY_TEACHER_COURSE_TEACHER_COURSE = createUniqueKey(TeacherCourse.TEACHER_COURSE, "KEY_teacher_course_teacher_course", TeacherCourse.TEACHER_COURSE.TEACHER_NUM, TeacherCourse.TEACHER_COURSE.COURSE_NUM);
    }
}

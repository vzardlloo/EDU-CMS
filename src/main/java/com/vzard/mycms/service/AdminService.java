package com.vzard.mycms.service;


import com.vzard.mycms.database.tables.pojos.Admin;
import com.vzard.mycms.database.tables.pojos.Student;
import com.vzard.mycms.database.tables.pojos.Teacher;
import com.vzard.mycms.mapper.AdminMapper;
import com.vzard.mycms.mapper.StudentMapper;
import com.vzard.mycms.mapper.TeacherMapper;
import com.vzard.mycms.repository.AdminRepository;
import com.vzard.mycms.repository.StudentRepository;
import com.vzard.mycms.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    AdminRepository adminRepository;


    public Admin getAdminByNumber(@NotNull String number){
        return AdminMapper.mapToVo(adminRepository.getAdminByNumber(number));
    }

    /**
     * 查看学生列表
     * @param
     * @return
     */
    public List<Student> getStudentList(){
        return studentRepository.getStudentList().stream()
                .map(t->StudentMapper.mapToVo(t))
                .collect(Collectors.toList());
    }

    /**
     * 增加一个学生信息
     * @param student
     * @return
     */
    public Student addStudentInfo(Student student){
        return StudentMapper.mapToVo(studentRepository.addStudentInfo(student));
    }

    /**
     * 修改一个学生信息
     * @param student
     * @return
     */
    public Student alertStudentInfo(Student student){
        return StudentMapper.mapToVo(studentRepository.updateStudentInfo(student));
    }

    /**
     * 删除一个学生信息
     * @param num
     */
    public void deleteStudentInfo(String num){
         studentRepository.deleteStudentInfo(num);
    }


    /**
     * 获取教师列表
     * @return
     */
    public List<Teacher> getTeacherList(){
        return teacherRepository.getTeacherList().stream()
                .map(t->TeacherMapper.mapToVo(t))
                .collect(Collectors.toList());
    }

    /**
     * 增加一个教师信息
     * @param teacher
     * @return
     */
    public Teacher addTeacherInfo(Teacher teacher){

        return TeacherMapper.mapToVo(teacherRepository.addTeacherInfo(teacher));
    }

    /**
     * 修改一个学生信息
     * @param teacher
     * @return
     */
    public Teacher alertTeacherInfo(Teacher teacher){
        return TeacherMapper.mapToVo(teacherRepository.updateTeacherInfo(teacher));
    }

    /**
     * 删除一个教师信息
     * @param num
     */
    public void deleteTeacherInfo(String num){
        teacherRepository.deleteTeacherInfo(num);
    }



}

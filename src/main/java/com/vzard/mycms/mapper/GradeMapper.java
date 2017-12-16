package com.vzard.mycms.mapper;


import com.vzard.mycms.database.tables.interfaces.IGrade;
import com.vzard.mycms.database.tables.pojos.Grade;
import org.springframework.beans.BeanUtils;

public class GradeMapper {

    public static Grade mapToVo(IGrade iGrade){
        if (null == iGrade){
            return null;
        }
        Grade grade = new Grade();
        BeanUtils.copyProperties(iGrade,grade);
        return grade;
    }
}

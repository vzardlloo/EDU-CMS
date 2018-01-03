package com.vzard.mycms.mapper;


import com.vzard.mycms.database.tables.interfaces.IAdmin;
import com.vzard.mycms.database.tables.pojos.Admin;
import org.springframework.beans.BeanUtils;

public class AdminMapper {

    public static Admin mapToVo(IAdmin iAdmin){
        if (null == iAdmin){
            return null;
        }
        Admin admin = new Admin();
        BeanUtils.copyProperties(iAdmin,admin);
        return admin;
    }

}

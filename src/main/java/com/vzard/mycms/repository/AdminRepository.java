package com.vzard.mycms.repository;


import com.vzard.mycms.database.Tables;
import com.vzard.mycms.database.tables.interfaces.IAdmin;
import com.vzard.mycms.error.ErrorException;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class AdminRepository {

    @Autowired
    @Qualifier("mycms")
    DSLContext dsl;


    public IAdmin getAdminByNumber(@NotNull String number){
        IAdmin iAdmin = dsl.select()
                .from(Tables.ADMIN)
                .where(Tables.ADMIN.NUMBER.eq(number))
                .fetchOneInto(IAdmin.class);

        if (null == iAdmin){
            throw new ErrorException("not found",404);
        }
        return iAdmin;
    }






}

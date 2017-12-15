package com.vzard.mycms.repository;


import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class GradeRepository {

    @Autowired
    @Qualifier("mycms")
    DSLContext dsl;







}

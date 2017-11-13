package com.vzard.educms.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: vzard
 * Date: 2017/11/11
 * Time: 17:46
 * To change this template use File | Settings | File Templates.
 * Description:
 **/

@Configuration
public class DatabaseConfiguration {

    @Autowired
    private EnvironmentVariables environmentVariables;


    //private DruidDataSource druidDataSource;
    @Primary
    @Bean
    @Qualifier("eduDataSource")
    public DataSource durid() {

//     if (null != druidDataSource){
//
//         return this.druidDataSource;
//   }

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://" + environmentVariables.databaseHost + ":" + environmentVariables.databasePort + "/" + environmentVariables.databaseName + "?useUnicode=true&serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false");
        dataSource.setUsername(environmentVariables.databaseUserName);
        dataSource.setPassword(environmentVariables.databasePassword);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(5);
        dataSource.setMaxWait(5000);

//     this.druidDataSource = dataSource;

        return dataSource;

    }


    @Bean
    @Qualifier("edu")
    public DSLContext dsl(@Qualifier("eduDataSource") DataSource dataSource) {
//        if (null == dataSource){
//            durid();
//        }
        return DSL.using(dataSource, SQLDialect.MYSQL);

    }


}

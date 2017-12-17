package com.vzard.mycms.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: vzard
 * Date: 2017/11/11
 * Time: 20:36
 * To change this template use File | Settings | File Templates.
 * Description:
 **/
@Component
@Configuration
public class EnvironmentVariables {

    @Value("${database.host}")
    public String databaseHost;

    @Value("${database.port}")
    public String databasePort;
    @Value("${database.name}")
    public String databaseName;
    @Value("${database.username}")
    public String databaseUserName;
    @Value("${database.password}")
    public String databasePassword;


}

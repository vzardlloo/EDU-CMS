package com.vzard.mycms.configuartion;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created with IntelliJ IDEA.
 * User: vzard
 * Date: 2017/11/10
 * Time: 23:10
 * To change this template use File | Settings | File Templates.
 * Description:
 **/

@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vzard.mycms.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();


    }

    private ApiInfo apiInfo() {

        //这里可以是markdown
        String descriptionMarkdown =
                "## EDU-CMS";

        return new ApiInfoBuilder()
                .title("EDU-CMS")
                .description(descriptionMarkdown)
                .termsOfServiceUrl("39.106.59.44")
                .contact(new Contact(
                        "vzard",
                        "https://github.com/vzardlloo/MY-CMS",
                        "vzardlloo.gmail.com"
                )).version("1.0").build();


    }


}

package com.anirudh.advertiserservice.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket studentsAPI(){

        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.anirudh.advertiserservice"))
                .paths(regex("/api/advertiser.*")).build().apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

  return new ApiInfoBuilder().title("Advertiser API").contact(new Contact("Anirudh Reddy","anirudhreddy06@gmail.com ","anirudhreddy06@gmail.com")).description("Below are the operations available for the Advertiser Service").build();

    }


}

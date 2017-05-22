package com.abs.wannasmile.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by phongbv on 11/15/16.
 */
@Configuration
@ComponentScan(basePackages = {"com.ss.userservices.endpoint","com.ss.userservices.service","com.ss.userservices.infras.exception"})
public class MvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(false).maxAge(3600);
    }

}

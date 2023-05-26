package com.informatics.practice.runer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.informatics.practice.app.common.exception.ExceptionControllerAdvice;
import com.informatics.practice.app.common.exception.ExceptionHandlerFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfiguration implements WebMvcConfigurer {


    @Bean
    public FilterRegistrationBean<ExceptionHandlerFilter> exceptionHandlerFilter(ExceptionControllerAdvice exceptionControllerAdvice, ObjectMapper objectMapper) {
        FilterRegistrationBean<ExceptionHandlerFilter> registrationBean = new FilterRegistrationBean<>(new ExceptionHandlerFilter(exceptionControllerAdvice, objectMapper));
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registrationBean;
    }

}

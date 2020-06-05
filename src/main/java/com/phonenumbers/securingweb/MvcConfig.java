package com.phonenumbers.securingweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        //setting home page
        registry.addViewController("/").setViewName("home");
        //setting page instead of "White Label error page"
        registry.addViewController("/error").setViewName("error");
    }

}

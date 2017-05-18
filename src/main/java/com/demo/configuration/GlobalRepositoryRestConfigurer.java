package com.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;


@Configuration
public class GlobalRepositoryRestConfigurer extends RepositoryRestConfigurerAdapter {

    /*
        TODO This config enables CORS for the application. This changed since the last time I looked at it,
        and deserves more attention for a production environment.
        http://stackoverflow.com/questions/31724994/spring-data-rest-and-cors
    */
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.getCorsRegistry()
              .addMapping("/**")
              .allowedOrigins("*")
              .allowedHeaders("*")
              .allowedMethods("OPTIONS","HEAD","GET","PUT","POST","DELETE","PATCH");
    }
}
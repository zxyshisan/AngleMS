package com.angle;
;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * Created by Administrator on 2016/8/17 0017.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application{
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}

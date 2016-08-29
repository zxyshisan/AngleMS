package com.angle;
;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Created by Administrator on 2016/8/17 0017.
 */
@MapperScan("com.angle.mapper")
@SpringBootApplication
public class Application{
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}

package com.angle.mybatis;

import com.github.pagehelper.PageHelper;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Created by Administrator on 2016/8/29 0029.
 */
@Configuration
public class MyBatisConfiguration {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MyBatisConfiguration.class);

    @Bean
    public PageHelper pageHelper() {
        logger.info("注册MyBatis分页插件PageHelper");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "false");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}

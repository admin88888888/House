package com.ddhouse.house.config;


import com.ddhouse.house.utils.JedisUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@Author feri
 *@Date Created in 2019/4/29 10:50
 */
@Configuration
public class RedisConfig {

    @Bean
    public JedisUtil creteJu(){
        return new JedisUtil("39.105.189.141",6379,"qfjava");
    }
}

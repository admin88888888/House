package com.ddhouse.house;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.ddhouse.house.mapper")
@EnableSwagger2
public class HouseApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(HouseApplication.class, args);
    }

    //重写configure方法
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HouseApplication.class);
    }
}

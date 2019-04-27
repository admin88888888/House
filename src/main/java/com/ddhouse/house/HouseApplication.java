package com.ddhouse.house;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ddhouse.house.mapper")
public class HouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseApplication.class, args);
    }

}

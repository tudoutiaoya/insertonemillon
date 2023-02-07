package com.zzqedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zzqedu.mapper")
@SpringBootApplication
public class InsertOneMillionApplication {
    public static void main(String[] args) {
        SpringApplication.run(InsertOneMillionApplication.class, args);
    }
}

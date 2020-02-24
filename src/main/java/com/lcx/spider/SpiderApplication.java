package com.lcx.spider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lcx.spider.mapper")
@SpringBootApplication()
public class SpiderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpiderApplication.class, args);
    }

}

package com.example.springbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // package 하위의 모든 어노테이션들을 spring bean으로 등록
public class SpringbasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbasicApplication.class, args);
    }

}

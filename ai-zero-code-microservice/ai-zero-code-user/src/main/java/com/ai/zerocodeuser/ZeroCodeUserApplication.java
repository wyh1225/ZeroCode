package com.ai.zerocodeuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.ai.zerocodeuser.mapper")
@ComponentScan("com.ai")
public class ZeroCodeUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZeroCodeUserApplication.class, args);
    }
}

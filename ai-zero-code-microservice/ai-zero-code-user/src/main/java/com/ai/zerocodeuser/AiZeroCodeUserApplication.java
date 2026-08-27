package com.ai.zerocodeuser;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDubbo
@MapperScan("com.ai.zerocodeuser.mapper")
@ComponentScan("com.ai")
public class AiZeroCodeUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(AiZeroCodeUserApplication.class, args);
    }
}

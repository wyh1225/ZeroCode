package com.zero.aizero;

import dev.langchain4j.community.store.embedding.redis.spring.RedisEmbeddingStoreAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {RedisEmbeddingStoreAutoConfiguration.class})
@MapperScan("com.zero.aizero.mapper")
public class AiZeroApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiZeroApplication.class, args);
        System.out.println("------启动成功------");
    }

}

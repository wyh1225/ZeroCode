package com.ai.zerocode;

import dev.langchain4j.community.store.embedding.redis.spring.RedisEmbeddingStoreAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@MapperScan("com.ai.zerocode.mapper")
@SpringBootApplication(exclude = {RedisEmbeddingStoreAutoConfiguration.class})
public class AiZeroCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiZeroCodeApplication.class, args);
        System.out.println("------启动成功------");
    }

}

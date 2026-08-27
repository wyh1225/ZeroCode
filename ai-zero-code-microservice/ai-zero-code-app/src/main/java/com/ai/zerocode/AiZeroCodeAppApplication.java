package com.ai.zerocode;

import dev.langchain4j.community.store.embedding.redis.spring.RedisEmbeddingStoreAutoConfiguration;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@EnableDubbo
@MapperScan("com.ai.zerocode.mapper")
@SpringBootApplication(exclude = {RedisEmbeddingStoreAutoConfiguration.class})
public class AiZeroCodeAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiZeroCodeAppApplication.class, args);
    }

}

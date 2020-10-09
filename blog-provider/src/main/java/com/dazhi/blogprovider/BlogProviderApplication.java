package com.dazhi.blogprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dazhi.blogprivider.*.mapper")
public class BlogProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogProviderApplication.class, args);
    }

}

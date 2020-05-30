package com.xt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages ={"com.xt.sys.mapper"})
public class LayuicmsMbApplication {

    public static void main(String[] args) {
        SpringApplication.run(LayuicmsMbApplication.class, args);
    }

}

package com.sinosoft.wordweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication()
@MapperScan("com.sinosoft.wordweb.chat.mapper")
public class WordWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WordWebApplication.class, args);
    }


}

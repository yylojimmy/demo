package com.example.db.dbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
//@MapperScan("com.example.db.dbdemo.mapper")
public class DbdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbdemoApplication.class, args);
    }

}

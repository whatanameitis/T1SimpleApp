package ru.karpunin.t1simpleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class T1SimpleAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(T1SimpleAppApplication.class, args);
    }

}

package com.target.retail;

import com.target.retail.handler.InboundHttpRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(InboundHttpRequest.class, args);
    }
}

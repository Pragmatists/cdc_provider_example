package com.pragmatists.cdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(BooksEndpointConfiguration.class)
public class BooksProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksProviderApplication.class, args);
    }
}

package com.pragmatists.cdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(BooksEndpointConfiguration.class)
public class BooksProviderApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BooksProviderApplication.class);
        app.setAdditionalProfiles("live");
        app.run(args);
    }
}

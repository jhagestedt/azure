package com.blueprint.azure;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        Environment environment = app.run(args).getEnvironment();
        log.info("\n----------------------------------------------------------\n"
                + "Application '{}' is running!\n"
                + "Url:      \thttp://127.0.0.1:{}\n"
                + "Profiles: \t{}"
                + "\n----------------------------------------------------------",
            environment.getProperty("spring.application.name"),
            environment.getProperty("server.port"),
            Arrays.toString(environment.getActiveProfiles()));
    }

}
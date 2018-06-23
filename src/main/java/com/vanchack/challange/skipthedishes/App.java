package com.vanchack.challange.skipthedishes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    public static String getAppNameVersion() {
        final Optional<String> version = Optional.ofNullable(App.class.getPackage().getImplementationVersion());
        return "vanhack/skip-the-dishes:" + version.orElse("development");
    }

}

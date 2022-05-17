package com.mercury;

import java.sql.SQLException;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {
    public App() {
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

//        try {
//            Console.main(args);
//        } catch (SQLException var3) {
//            throw new RuntimeException(var3);
//        }
    }
}

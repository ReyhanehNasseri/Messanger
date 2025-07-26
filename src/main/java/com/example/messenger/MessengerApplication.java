package com.example.messenger;

import com.example.messenger.service.GroupManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class MessengerApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(MessengerApplication.class, args);
    }

}

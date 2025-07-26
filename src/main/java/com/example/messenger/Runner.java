package com.example.messenger;

import com.example.messenger.model.Message;
import com.example.messenger.service.GroupManager;
import com.example.messenger.service.GroupRoom;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class Runner implements CommandLineRunner {
    private final GroupRoom grouproom;
    private final GroupManager groupManager;

    public Runner(GroupRoom groupRoom , GroupManager groupManager ) {
        this.groupManager = groupManager;
        this.grouproom= groupRoom;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}

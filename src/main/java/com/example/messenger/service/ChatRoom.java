package com.example.messenger.service;

import com.example.messenger.model.Group;
import com.example.messenger.model.Message;

import java.util.List;

public interface ChatRoom {
    public void send(Message message, String id);

    public void delete(String messageId, String id);

    public List<Message> viewMessages(String id);

}

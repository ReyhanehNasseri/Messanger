package com.example.messenger.repository;

import com.example.messenger.model.Chat;
import com.example.messenger.model.GroupChat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupChatRepository<T> extends JpaRepository <GroupChat, String> {
}

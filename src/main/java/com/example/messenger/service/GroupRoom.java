package com.example.messenger.service;
import com.example.messenger.model.Group;
import com.example.messenger.model.GroupChat;
import com.example.messenger.model.Message;
import com.example.messenger.repository.GroupChatRepository;
import com.example.messenger.repository.GroupRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupRoom implements ChatRoom {
    private final GroupChatRepository groupChatRepository;
    private final GroupRepository groupRepository;

    @Autowired
    public GroupRoom(GroupChatRepository groupChatRepository, GroupRepository groupRepository){
        this.groupChatRepository=groupChatRepository;
        this.groupRepository = groupRepository;
    }
    @Override
    @Transactional
    public void send(Message message, String groupId) {
      Optional<Group> groupOptional = groupRepository.findById(groupId);
      if(groupOptional.isPresent()){
        Group group = groupOptional.get();
        GroupChat groupChat = group.getGroupChat();
        List<Message>messages = groupChat.getMessages();
        messages.add(message);
        groupChat.setMessages(messages);
        groupChatRepository.save(groupChat);
      }
      else{
          throw new RuntimeException("Group not found");
      }
    }

    @Transactional
    @Override
    public void delete(String messageId, String groupId) {
        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if(groupOptional.isPresent()){
            Group group = groupOptional.get();
            GroupChat groupChat = group.getGroupChat();
            List<Message>messages = groupChat.getMessages();
            messages.removeIf(i -> i.getId().equals(messageId)) ;
            groupChat.setMessages(messages);
            groupChatRepository.save(groupChat);
        }
        else{
            throw new RuntimeException("Group not found");
        }
    }

    @Override
    @Transactional
    public List<Message> viewMessages(String groupId) {
        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if(groupOptional.isPresent()){
            Group group = groupOptional.get();
            GroupChat groupChat = group.getGroupChat();
            return groupChat.getMessages();
        }
        else{
            throw new RuntimeException("Group not found");
        }
    }
}

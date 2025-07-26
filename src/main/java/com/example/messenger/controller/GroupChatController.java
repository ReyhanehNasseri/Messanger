package com.example.messenger.controller;

import com.example.messenger.model.Message;
import com.example.messenger.service.GroupRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/GroupChat")
public class GroupChatController {
    private final GroupRoom groupRoom;

    @Autowired
    public GroupChatController(GroupRoom groupRoom) {
        this.groupRoom = groupRoom;
    }

    @PostMapping(path = "/{groupId}")
    public void sendMessage(@PathVariable("groupId") String groupId , @RequestBody Message message){
        groupRoom.send(message , groupId);
    }

    @DeleteMapping(path = "/{groupId}")
    public void deleteMessage(@PathVariable("groupId") String groupId, @RequestParam String messageId){
        groupRoom.delete(messageId,groupId);
    }

    @GetMapping(path = "/{groupId}")
    public List<Message> viewMessages (@PathVariable("groupId") String groupId){
        return groupRoom.viewMessages(groupId);
    }
}

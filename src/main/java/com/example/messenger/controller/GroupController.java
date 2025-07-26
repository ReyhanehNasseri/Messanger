package com.example.messenger.controller;

import com.example.messenger.model.Group;
import com.example.messenger.model.User;
import com.example.messenger.service.GroupManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/group")
public class GroupController  {
    private final GroupManager groupManager;

    @Autowired
    public GroupController(GroupManager groupManager) {
        this.groupManager = groupManager;
    }

    @PostMapping(path = "/{name}")
    public void createGroup (@PathVariable("name") String name){
        groupManager.createGroup(name);
    }

    @GetMapping(path = "/{groupId}")
    public List<String> getMembersId(@PathVariable("groupId") String groupId){
       return groupManager.getMembersId(groupId);
    }

    @PutMapping(path = "/{userId}")
    public void addMember(@PathVariable("userId") String userId , @RequestParam String groupId){
        groupManager.addMember(userId , groupId);
    }

    @DeleteMapping(path = "/{userId}")
    public void removeMember(@PathVariable("userId") String userId , @RequestParam String groupId){
        groupManager.removeMember(userId , groupId);
    }

    @GetMapping
    public List<String> getGroups(){
        return groupManager.getAllGroups();
    }
}

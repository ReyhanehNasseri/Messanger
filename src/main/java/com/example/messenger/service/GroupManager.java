package com.example.messenger.service;

import com.example.messenger.model.Group;
import com.example.messenger.model.GroupChat;
import com.example.messenger.model.User;
import com.example.messenger.repository.GroupRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import java.util.List;
import java.util.Optional;

@Service
public class GroupManager {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupManager(GroupRepository groupRepository){
        this.groupRepository=groupRepository;
    }

    @Transactional
    public void createGroup(String name) {
        Group group = new Group(name);
        groupRepository.save(group);
        System.out.println(group.getGroupChat());
    }

    public List<String> getMembersId(String groupId) {
        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if (groupOptional.isPresent()) {
            Group group = groupOptional.get();
            return group.getMembersId();
        }
        else {
            throw new RuntimeException("Group not found");
        }
    }

    @Transactional
    public void removeMember(String memberId , String groupId){
        Optional<Group> groupOptional = groupRepository.findById(groupId);

        if (groupOptional.isPresent()) {
            Group group = groupOptional.get();
            List<String> membersId = group.getMembersId();
            membersId.remove(memberId);
            group.setMembersId(membersId);
            groupRepository.save(group);
        }
        else {
            throw new RuntimeException("Group not found");
        }
    }

    @Transactional
    public void addMember(String memberId , String groupId) {
        Optional<Group> groupOptional = groupRepository.findById(groupId);

        if (groupOptional.isPresent()) {
            Group group = groupOptional.get();
            List<String> membersId = group.getMembersId();
            membersId.add(memberId);
            group.setMembersId(membersId);
            groupRepository.save(group);
        }
        else {
            throw new RuntimeException("Group not found");
        }
    }

    public List<String> getAllGroups() {
        return groupRepository.findAllGroupIds();
    }
}

package com.example.messenger.service;

import com.example.messenger.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.messenger.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserManager {

    private final UserRepository userRepository;
    private final GroupManager groupManager;

    @Autowired
    public UserManager(UserRepository userRepository,GroupManager groupManager) {
        this.userRepository = userRepository;
        this.groupManager = groupManager;

    }

    public void addUser(User user){
        Optional<User> studentByEmail = userRepository.findUserByEmail(user.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        userRepository.save(user);
    }


    public void updateUserName(String name , String userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        user.setName(name);
        userRepository.save(user);
    }

    public void removeUser(String userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        userRepository.delete(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
}

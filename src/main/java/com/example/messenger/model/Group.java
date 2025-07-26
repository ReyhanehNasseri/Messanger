package com.example.messenger.model;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Table
@Entity
public class Group {

    @Id
    private final String id =UUID.randomUUID().toString();
    private String name;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable
    private List<String> membersId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "group_chat_id")
    private  GroupChat groupChat;


    public Group(String name){
        this.name = name;
        this.groupChat = new GroupChat();
        this.groupChat.setGroup(this);
    }

    public Group() {
        this.groupChat = new GroupChat();
    }


    public List<String> getMembersId() {
        return membersId;
    }

    public GroupChat getGroupChat() {
        return groupChat;
    }

    public String getId() {
        return id;
    }

    public void setMembersId(List <String> membersId) {
        this.membersId = membersId;
    }

    public void setGroupChat(GroupChat groupChat) {
        this.groupChat = groupChat;
    }
}

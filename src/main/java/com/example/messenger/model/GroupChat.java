package com.example.messenger.model;

import jakarta.persistence.*;


@Entity
@DiscriminatorValue("GROUP")
public class GroupChat extends Chat {

    @OneToOne(mappedBy = "groupChat", fetch = FetchType.LAZY)
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public GroupChat() {
        super();
    }

}

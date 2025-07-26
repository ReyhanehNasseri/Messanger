package com.example.messenger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.UUID;

public class Message implements Serializable {

    private String id = UUID.randomUUID().toString();;
    private String senderId;
    private String text;

    @JsonCreator
    public Message( @JsonProperty("text") String text,  @JsonProperty("senderId") String senderId) {
        this.text = text;
        this.senderId = senderId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }
}

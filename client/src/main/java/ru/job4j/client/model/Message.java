package ru.job4j.client.model;

import java.util.Objects;

public class Message {

    private int id;
    private String message;
    private String sender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Message message1 = (Message) o;
        return Objects.equals(message, message1.message) && Objects.equals(sender, message1.sender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, sender);
    }
}

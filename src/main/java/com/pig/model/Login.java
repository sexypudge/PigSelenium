package com.pig.model;

public class Login extends Model{

    private String email;

    private String password;

    private String messageResult;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessageResult() {
        return messageResult;
    }

    public void setMessageResult(String messageResult) {
        this.messageResult = messageResult;
    }
}

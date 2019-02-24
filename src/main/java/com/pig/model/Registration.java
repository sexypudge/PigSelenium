package com.pig.model;

public class Registration extends Model{
    private String name;

    private String email;

    private String pass;

    private String passRepeat;

    private String address;

    private String phone;

    private String messageResult;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPassRepeat() {
        return passRepeat;
    }

    public void setPassRepeat(String passRepeat) {
        this.passRepeat = passRepeat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessageResult() {
        return messageResult;
    }

    public void setMessageResult(String messageResult) {
        this.messageResult = messageResult;
    }
}

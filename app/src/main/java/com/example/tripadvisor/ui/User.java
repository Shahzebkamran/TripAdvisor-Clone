package com.example.tripadvisor.ui;

public class User {
    private String UserEmail;
    private String UserName;
    public User(String UserEmail,String UserName){
        this.UserName = UserName;
        this.UserEmail = UserEmail;
    }
    public String getUserEmail(){
        return this.UserEmail;
    }
    public String getUserName(){
        return this.UserName;
    }
    public void setUserName(String UserName){
        this.UserName = UserName;
    }
    public void setUserEmail(String UserEmail){
        this.UserEmail = UserEmail;
    }
}

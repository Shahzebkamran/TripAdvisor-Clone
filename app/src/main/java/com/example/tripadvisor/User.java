package com.example.tripadvisor;

public class User {
    private String UserEmail;
    private String UserName;
    private String Password;
    public User(String UserEmail,String UserName,String Password){
        this.UserName = UserName;
        this.UserEmail = UserEmail;
        this.Password = Password;
    }
    public String getUserEmail(){
        return this.UserEmail;
    }
    public String getUserName(){
        return this.UserName;
    }
    public String getPassword(){
        return this.Password;
    }
    public void setPassword(String Password){
        this.Password = Password;
    }
    public void setUserName(String UserName){
        this.UserName = UserName;
    }
    public void setUserEmail(String UserEmail){
        this.UserEmail = UserEmail;
    }
}

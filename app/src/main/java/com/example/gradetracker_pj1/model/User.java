package com.example.gradetracker_pj1.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int userid;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String first_name;
    @NonNull
    private String last_name;

    public User(){}
    @Ignore
    public User(int userid, String username, String password,String first_name, String last_name){
        this.username=username;
        this.password=password;
        this.userid = userid;
        this.first_name = first_name;
        this.last_name = last_name;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUserid(int id){this.userid = userid;}
    public void setFirst_name(String first_name){this.first_name = first_name;}
    public void setLast_name(String last_name){this.last_name = last_name;}
    public int getUserid(){
        return userid;
    }
    public String getFirst_name()
    {
        return first_name;
    }
    public String getLast_name()
    {
        return last_name;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

}

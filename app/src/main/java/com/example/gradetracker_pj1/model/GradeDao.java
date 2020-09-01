package com.example.gradetracker_pj1.model;
import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface GradeDao {
    @Query("select * from User")
    List<User> getAllUsers();
    @Insert
    void addUser(User user);
}

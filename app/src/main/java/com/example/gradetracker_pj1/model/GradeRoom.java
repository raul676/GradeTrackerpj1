package com.example.gradetracker_pj1.model;


import android.content.Context;
import android.util.Log;

import java.util.List;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Assignment.class}, version =1)
public abstract class GradeRoom extends RoomDatabase {
    private static GradeRoom instance;

    public abstract GradeDao dao();
    public static GradeRoom getGradeRoom(final Context context){
        if(instance ==null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    GradeRoom.class,
                    "GradeRoomDB").allowMainThreadQueries().build();
        }
        return instance;
    }


    public void loadData(Context context){
        List<User> user_list = GradeRoom.getGradeRoom(context).dao().getAllUsers();
        if(user_list.size() ==0)
        {
            Log.d("GradeRoom", "loading data");
        }
    }

    private void loadUsers(Context context){
        GradeDao dao = getGradeRoom(context).dao();
        User user1 = new User(1000, "raul676", "raulpjp1", "Raul","Perez");
        dao.addUser(user1);
        Log.d("GradeRoom", "1 User added to database");
    }
}

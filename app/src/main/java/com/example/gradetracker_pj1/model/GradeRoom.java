package com.example.gradetracker_pj1.model;
import android.content.Context;
import android.util.Log;

import java.util.List;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Assignment.class,Course.class,Enrollment.class,Grade.class,GradeCategory.class,User.class}, version =1)
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
        List<User> user_list = GradeRoom.getGradeRoom(context).dao().getAllUser();
        if(user_list.size() ==0)
        {
            Log.d("GradeRoom", "loading data");
            loadAssignment(context);
            loadCourse(context);
            loadEnrollment(context);
            loadGradeCategory(context);
            loadUsers(context);
            loadGrade(context);
        }
    }

    private void loadUsers(Context context){
        GradeDao dao = getGradeRoom(context).dao();
        User user1 = new User(10000, "raul676", "raulpjp1", "Raul","Perez");
        User user2 = new User(10001, "athena23", "athena1234", "Athena","Raya");
        dao.addUser(user1);
        dao.addUser(user2);
        Log.d("GradeRoom", "1 User added to database");
    }
    private void loadAssignment(Context context){
        GradeDao dao = getGradeRoom(context).dao();
        Assignment assignment1 = new Assignment(1111, 438, 1, 10, 8, "Insert Details here", "8/26/20", "9/05/20");
        dao.addAssignment(assignment1);
        Log.d("GradeRoom", "1 Assignment added to Database");
    }
    private void loadCourse(Context context){
        GradeDao dao = getGradeRoom(context).dao();
        Course course1 = new Course(438, "Dr. C", "Software Engineering" ,"Students will work together to work on large scaled software design projects", "8/24/20", "12/16/20" );
        dao.addCourse(course1);
        Log.d("GradeRoom", "1 Course added to Database");
    }
    private void loadEnrollment(Context context){
        GradeDao dao = getGradeRoom(context).dao();
        Enrollment enrollment1 = new Enrollment(438,1000, "8/20/20");
        dao.addEnrollment(enrollment1);
        Log.d("GradeRoom", "1 Enrollment added to Database");
    }
    private void loadGradeCategory(Context context){
        GradeDao dao = getGradeRoom(context).dao();
        GradeCategory gradeCategory1 = new GradeCategory(1, 10, .25, "Software Engineering", "8/26/20");
        dao.addGradeCategory(gradeCategory1);
        Log.d("GradeRoom", "1 GradeCategory added to Database");
    }
    private void loadGrade(Context context){
        GradeDao dao = getGradeRoom(context).dao();
        Grade grade1 = new Grade(10, 8, 1111, 438, 10000, "9/1/20" );
        dao.addGrade(grade1);
        Log.d("GradeRoom", "1 Grade added to Database");

    }
}

package com.example.gradetracker_pj1.model;
import android.content.Context;
import android.util.Log;

import java.util.List;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Update;

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
        User user3 = new User(10002, "daniel12", "daniel112", "Daniel", "Kufer");
        User user4 = new User(10003, "emory45", "emory123", "Emory", "Schmitt");
        dao.addUser(user1);
        dao.addUser(user2);
        dao.addUser(user3);
        dao.addUser(user4);
        Log.d("GradeRoom", "4 Users added to database");
    }
    private void loadAssignment(Context context){
        GradeDao dao = getGradeRoom(context).dao();
        //Class 438 Assignments
        Assignment assignment1 = new Assignment(43810, 438, 10, 10,  "Homework 1: Login Screen", "8/26/20", "9/05/20");
        Assignment assignment2 = new Assignment(43811, 438,10, 10, "Homework 2: Create DAO/DB", "10/2/20", "10/22/20");
        Assignment assignment3 = new Assignment(43820, 438,20,10, "Project 1: Grade Tracker App", "9/2/20", "10/28/20" );
        Assignment assignment4 = new Assignment(43821, 438,20,10, "Project 2: Weather App", "11/2/20", "12/12/20" );
        Assignment assignment5 = new Assignment(43830, 438, 30, 10, "Midterm", "10/2/20", "10/2/20");
        Assignment assignment6 = new Assignment(43840, 438, 40, 10, "Final", "12/15/20", "12/15/20");

        //Class 334 Assignments
        Assignment assignment7 = new Assignment(33610, 336, 10, 10,  "Homework 1: First Web page", "8/26/20", "9/05/20");
        Assignment assignment8 = new Assignment(33611, 336,10, 10, "Homework 2: 4 Page Website", "10/2/20", "10/22/20");
        Assignment assignment9 = new Assignment(33620, 336,20,10, "Project 1: SE Website", "9/2/20", "10/28/20" );
        Assignment assignment10 = new Assignment(33621, 336,20,10, "Project 2: JavaScript Website", "11/2/20", "12/12/20" );
        Assignment assignment11 = new Assignment(33630, 336, 30, 10, "Midterm", "10/2/20", "10/2/20");
        Assignment assignment12 = new Assignment(33640, 336, 40, 10, "Final", "12/15/20", "12/15/20");

        //Class 334 Assignments
        Assignment assignment13 = new Assignment(33410, 334, 10, 10,  "Homework 1:Binary Conversion", "8/26/20", "9/05/20");
        Assignment assignment14 = new Assignment(33411, 334,10, 10, "Homework 2: Hardware Assignment", "10/2/20", "10/22/20");
        Assignment assignment15 = new Assignment(33420, 334,20,10, "Project 1: Unix Project", "9/2/20", "10/28/20" );
        Assignment assignment16 = new Assignment(33421, 334,20,10, "Project 2: OS Project", "11/2/20", "12/12/20" );
        Assignment assignment17 = new Assignment(33430, 334, 30, 10, "Midterm", "10/2/20", "10/2/20");
        Assignment assignment18 = new Assignment(33440, 334, 40, 10, "Final", "12/15/20", "12/15/20");

        //Class 462s Class is used for a test. No one will be enrolled unless student enrolls
        Assignment assignment19 = new Assignment(46210, 462, 10, 10,  "Homework 1:Research on a Justice Topic", "8/26/20", "9/05/20");
        Assignment assignment20 = new Assignment(46211, 462,10, 10, "Homework 2: Paper on Injustice", "10/2/20", "10/22/20");
        Assignment assignment21 = new Assignment(46220, 462,20,10, "Project 1: Justice Project", "9/2/20", "10/28/20" );
        Assignment assignment22 = new Assignment(46221, 462,20,10, "Project 2: Injustice Project", "11/2/20", "12/12/20" );
        Assignment assignment23 = new Assignment(46230, 462, 30, 10, "Midterm", "10/2/20", "10/2/20");
        Assignment assignment24 = new Assignment(46240, 462, 40, 10, "Final", "12/15/20", "12/15/20");

        dao.addAssignment(assignment1);
        dao.addAssignment(assignment2);
        dao.addAssignment(assignment3);
        dao.addAssignment(assignment4);
        dao.addAssignment(assignment5);
        dao.addAssignment(assignment6);
        dao.addAssignment(assignment7);
        dao.addAssignment(assignment8);
        dao.addAssignment(assignment9);
        dao.addAssignment(assignment10);
        dao.addAssignment(assignment11);
        dao.addAssignment(assignment12);
        dao.addAssignment(assignment13);
        dao.addAssignment(assignment14);
        dao.addAssignment(assignment15);
        dao.addAssignment(assignment16);
        dao.addAssignment(assignment17);
        dao.addAssignment(assignment18);
        dao.addAssignment(assignment19);
        dao.addAssignment(assignment20);
        dao.addAssignment(assignment21);
        dao.addAssignment(assignment22);
        dao.addAssignment(assignment23);
        dao.addAssignment(assignment24);

        Log.d("GradeRoom", "24 Assignments added to Database");
    }
    private void loadCourse(Context context){
        GradeDao dao = getGradeRoom(context).dao();
        Course course438 = new Course(438, "Dr. C", "Software Engineering" ,"Students will work together to work on large scaled software design projects", "8/24/20", "12/16/20" );
        Course course336= new Course(336, "Dr. Lara", "Internet Programming" ,"Students will learn how to Design Websites using HTML CSS & Java Script", "8/24/20", "12/16/20" );
        Course course334 = new Course(334, "Dr. Islam", "Operating Systems" ,"Students will learn Linux and C to learn how an OS works", "8/24/20", "12/16/20" );
        Course course462 = new Course(462, "Dr. Robertson", "Race Gender & Class Digital World" ,"Students will group together to discuss Race Gender and other controversial topics", "8/24/20", "12/16/20" );

        dao.addCourse(course438);
        dao.addCourse(course336);
        dao.addCourse(course334);
        dao.addCourse(course462);
        Log.d("GradeRoom", "4 Course added to Database");
    }
    @Update
    private void loadEnrollment(Context context){
        GradeDao dao = getGradeRoom(context).dao();
        //Only for raul, he will be enrolled.
        Enrollment enrollment1 = new Enrollment(46200,462,10000, "8/20/20");

        Enrollment enrollment2 = new Enrollment(43000,438,10000, "8/20/20");
        Enrollment enrollment3 = new Enrollment(43801,438,10001, "8/20/20");
        Enrollment enrollment4 = new Enrollment(43802,438,10002, "8/20/20");
        Enrollment enrollment5 = new Enrollment(43803,438,10003, "8/20/20");

        Enrollment enrollment6 = new Enrollment(33400,334,10000, "8/20/20");
        Enrollment enrollment7 = new Enrollment(33401,334,10001, "8/20/20");
        Enrollment enrollment8 = new Enrollment(33402,334,10002, "8/20/20");
        Enrollment enrollment9 = new Enrollment(33403,334,10003, "8/20/20");

        Enrollment enrollment10 = new Enrollment(33600, 336,10000, "8/20/20");
        Enrollment enrollment11 = new Enrollment(33601, 336,10001, "8/20/20");
        Enrollment enrollment12 = new Enrollment(33602, 336,10002, "8/20/20");
        Enrollment enrollment13 = new Enrollment(33603,336,10003, "8/20/20");


        dao.addEnrollment(enrollment1);
        dao.addEnrollment(enrollment2);
        dao.addEnrollment(enrollment3);
        dao.addEnrollment(enrollment4);
        dao.addEnrollment(enrollment5);
        dao.addEnrollment(enrollment6);
        dao.addEnrollment(enrollment7);
        dao.addEnrollment(enrollment8);
        dao.addEnrollment(enrollment9);
        dao.addEnrollment(enrollment10);
        dao.addEnrollment(enrollment11);
        dao.addEnrollment(enrollment12);
        dao.addEnrollment(enrollment13);

        Log.d("GradeRoom", "13 Enrollment added to Database");
    }
    private void loadGradeCategory(Context context){
        GradeDao dao = getGradeRoom(context).dao();
        GradeCategory gradeCategory1 = new GradeCategory(43810, 10, .25, "Software Engineering", "8/26/20",438);
        GradeCategory gradeCategory2 = new GradeCategory(43820, 20, .25, "Software Engineering", "8/26/20",438);
        GradeCategory gradeCategory3 = new GradeCategory(43830, 30, .25, "Software Engineering", "8/26/20",438);
        GradeCategory gradeCategory4 = new GradeCategory(43840, 40, .25, "Software Engineering", "8/26/20",438);

        GradeCategory gradeCategory5 = new GradeCategory(33610, 10, .25, "Internet Programming", "8/26/20",336);
        GradeCategory gradeCategory6 = new GradeCategory(33620, 20, .25, "Internet Programming", "8/26/20",336);
        GradeCategory gradeCategory7 = new GradeCategory(33630, 30, .25, "Internet Programming", "8/26/20",336);
        GradeCategory gradeCategory8 = new GradeCategory(33640, 40, .25, "Internet Programming", "8/26/20",336);

        GradeCategory gradeCategory9 = new GradeCategory(33410, 10, .25, "Operating Systems", "8/26/20",334);
        GradeCategory gradeCategory10 = new GradeCategory(33420, 20, .25, "Operating Systems", "8/26/20",334);
        GradeCategory gradeCategory11 = new GradeCategory(33430, 30, .25, "Operating Systems", "8/26/20",334);
        GradeCategory gradeCategory12 = new GradeCategory(33440, 40, .25, "Operating Systems", "8/26/20",334);

        GradeCategory gradeCategory13 = new GradeCategory(46210, 10, .25, "Race Gender & Class Digital World", "8/26/20",462);
        GradeCategory gradeCategory14 = new GradeCategory(46220, 20, .25, "Race Gender & Class Digital World", "8/26/20",462);
        GradeCategory gradeCategory15 = new GradeCategory(46230, 30, .25, "Race Gender & Class Digital World", "8/26/20",462);
        GradeCategory gradeCategory16 = new GradeCategory(46240, 40, .25, "Race Gender & Class Digital World", "8/26/20",462);

        dao.addGradeCategory(gradeCategory1);
        dao.addGradeCategory(gradeCategory2);
        dao.addGradeCategory(gradeCategory3);
        dao.addGradeCategory(gradeCategory4);
        dao.addGradeCategory(gradeCategory5);
        dao.addGradeCategory(gradeCategory6);
        dao.addGradeCategory(gradeCategory7);
        dao.addGradeCategory(gradeCategory8);
        dao.addGradeCategory(gradeCategory9);
        dao.addGradeCategory(gradeCategory10);
        dao.addGradeCategory(gradeCategory11);
        dao.addGradeCategory(gradeCategory12);
        dao.addGradeCategory(gradeCategory13);
        dao.addGradeCategory(gradeCategory14);
        dao.addGradeCategory(gradeCategory15);
        dao.addGradeCategory(gradeCategory16);

        Log.d("GradeRoom", "16 GradeCategory added to Database");
    }
    private void loadGrade(Context context){
        GradeDao dao = getGradeRoom(context).dao();
        // Grades for Course 438
        Grade raul1 = new Grade(1,10, 4, 43810, 438, 10000, "12/15/20" );
        Grade raul2 = new Grade(2,10, 3, 43811, 438, 10000, "12/16/20" );
        Grade raul3 = new Grade(3,20, 1, 43820, 438, 10000, "12/15/20" );
        Grade raul4 = new Grade(4,20, 5, 43821, 438, 10000, "12/15/20" );
        Grade raul5 = new Grade(5,30, 6, 43830, 438, 10000, "12/15/20" );
        Grade raul6 = new Grade(6,40, 4, 43840, 438, 10000, "12/15/20" );

        Grade emory1 = new Grade(7,10, 7, 43810, 438, 10003, "12/15/20" );
        Grade emory2 = new Grade(8,10, 9, 43811, 438, 10003, "12/16/20" );
        Grade emory3 = new Grade(9,20, 10, 43820, 438, 10003, "12/15/20" );
        Grade emory4 = new Grade(10,20, 7, 43821, 438, 10003, "12/15/20" );
        Grade emory5 = new Grade(11,30, 8, 43830, 438, 10003, "12/15/20" );
        Grade emory6 = new Grade(12,40, 9, 43840, 438, 10003, "12/15/20" );

        Grade daniel1 = new Grade(13,10, 9, 43810, 438, 10002, "12/15/20" );
        Grade daniel2 = new Grade(14,10, 9, 43811, 438, 10002, "12/16/20" );
        Grade daniel3 = new Grade(15,20, 10, 43820, 438, 10002, "12/15/20" );
        Grade daniel4 = new Grade(16,20, 10, 43821, 438, 10002, "12/15/20" );
        Grade daniel5 = new Grade(17,30, 8, 43830, 438, 10002, "12/15/20" );
        Grade daniel6 = new Grade(18,40, 7, 43840, 438, 10002, "12/15/20" );

        Grade athena1 = new Grade(19,10, 8, 43810, 438, 10001, "12/15/20" );
        Grade athena2 = new Grade(20,10, 9, 43811, 438, 10001, "12/16/20" );
        Grade athena3 = new Grade(21,20, 10, 43820, 438, 10001, "12/15/20" );
        Grade athena4 = new Grade(22,20, 5, 43821, 438, 10001, "12/15/20" );
        Grade athena5 = new Grade(23,30, 6, 43830, 438, 10001, "12/15/20" );
        Grade athena6 = new Grade(24,40, 7, 43840, 438, 10001, "12/15/20" );

        //Grades for Course 336
        Grade raul7 = new Grade(25,10, 2, 33610, 336, 10000, "12/15/20" );
        Grade raul8 = new Grade(26,10, 7, 33611, 336, 10000, "12/16/20" );
        Grade raul9 = new Grade(27,20, 6, 33620, 336, 10000, "12/15/20" );
        Grade raul10 = new Grade(28,20, 4, 33621, 336, 10000, "12/15/20" );
        Grade raul11 = new Grade(29,30, 3, 33630, 336, 10000, "12/15/20" );
        Grade raul12 = new Grade(30,40, 2, 33640, 336, 10000, "12/15/20" );

        Grade emory7 = new Grade(31,10, 8, 33610, 336, 10003, "12/15/20" );
        Grade emory8 = new Grade(32,10, 10, 33611, 336, 10003, "12/16/20" );
        Grade emory9 = new Grade(33,20, 7, 33620, 336, 10003, "12/15/20" );
        Grade emory10 = new Grade(34,20, 9, 33621, 336, 10003, "12/15/20" );
        Grade emory11 = new Grade(35,30, 8, 33630, 336, 10003, "12/15/20" );
        Grade emory12 = new Grade(36,40, 9, 33640, 336, 10003, "12/15/20" );

        Grade daniel7 = new Grade(37,10, 7, 33610, 336, 10002, "12/15/20" );
        Grade daniel8 = new Grade(38,10, 6, 33611, 336, 10002, "12/16/20" );
        Grade daniel9 = new Grade(39,20, 10, 33620, 336, 10002, "12/15/20" );
        Grade daniel10 = new Grade(40,20, 9, 33621, 336, 10002, "12/15/20" );
        Grade daniel11 = new Grade(41,30, 8, 33630, 336, 10002, "12/15/20" );
        Grade daniel12 = new Grade(42,40, 9, 33640, 336, 10002, "12/15/20" );

        Grade athena7 = new Grade(43,10, 4, 33610, 336, 10001, "12/15/20" );
        Grade athena8 = new Grade(44,10, 10, 33611, 336, 10001, "12/16/20" );
        Grade athena9 = new Grade(45,20, 7, 33620, 336, 10001, "12/15/20" );
        Grade athena10 = new Grade(46,20, 8, 33621, 336, 10001, "12/15/20" );
        Grade athena11 = new Grade(47,30, 8, 33630, 336, 10001, "12/15/20" );
        Grade athena12 = new Grade(48,10, 7, 33640, 336, 10001, "12/15/20" );

        // Grades for Course 334
        Grade raul13 = new Grade(49,10, 3, 33410, 334, 10000, "12/15/20" );
        Grade raul14 = new Grade(50,10, 4, 33411, 334, 10000, "12/16/20" );
        Grade raul15 = new Grade(51,20, 3, 33420, 334, 10000, "12/15/20" );
        Grade raul16 = new Grade(52,20, 4, 33421, 334, 10000, "12/15/20" );
        Grade raul17 = new Grade(53,30, 3, 33430, 334, 10000, "12/15/20" );
        Grade raul18 = new Grade(54,40, 5, 33440, 334, 10000, "12/15/20" );

        Grade emory13 = new Grade(55,10, 6, 33410, 334, 10003, "12/15/20" );
        Grade emory14 = new Grade(56,10, 7, 33411, 334, 10003, "12/16/20" );
        Grade emory15 = new Grade(57,20, 7, 33420, 334, 10003, "12/15/20" );
        Grade emory16 = new Grade(58,20, 8, 33421, 334, 10003, "12/15/20" );
        Grade emory17 = new Grade(59,30, 8, 33430, 334, 10003, "12/15/20" );
        Grade emory18 = new Grade(60,40, 5, 33440, 334, 10003, "12/15/20" );

        Grade daniel13 = new Grade(61,10, 8, 33410, 334, 10002, "12/15/20" );
        Grade daniel14 = new Grade(62,10, 6, 33411, 334, 10002, "12/16/20" );
        Grade daniel15 = new Grade(63,20, 4, 33420, 334, 10002, "12/15/20" );
        Grade daniel16 = new Grade(64,20, 9, 33421, 334, 10002, "12/15/20" );
        Grade daniel17 = new Grade(65,30, 3, 33430, 334, 10002, "12/15/20" );
        Grade daniel18 = new Grade(66,40, 7, 33440, 334, 10002, "12/15/20" );

        Grade athena13 = new Grade(67,10, 2, 33410, 334, 10001, "12/15/20" );
        Grade athena14 = new Grade(68,10, 8, 33411, 334, 10001, "12/16/20" );
        Grade athena15 = new Grade(69,20, 7, 33420, 334, 10001, "12/15/20" );
        Grade athena16 = new Grade(70,20, 4, 33421, 334, 10001, "12/15/20" );
        Grade athena17 = new Grade(71,30, 8, 33430, 334, 10001, "12/15/20" );
        Grade athena18 = new Grade(72,40, 9, 33440, 334, 10001, "12/15/20" );

        // Grades for Course 462  ONLY Raul will have grades since he's the only one enrolled.
        Grade raul19 = new Grade(73,10, 4, 46210, 462, 10000, "12/15/20" );
        Grade raul20 = new Grade(74,10, 3, 46211, 462, 10000, "12/16/20" );
        Grade raul21 = new Grade(75,20, 8, 46220, 462, 10000, "12/15/20" );
        Grade raul22 = new Grade(76,20, 7, 46221, 462, 10000, "12/15/20" );
        Grade raul23 = new Grade(77,30, 9, 46230, 462, 10000, "12/15/20" );
        Grade raul24 = new Grade(78,40, 10, 46240, 462, 10000, "12/15/20" );

        dao.addGrade(raul1);
        dao.addGrade(raul2);
        dao.addGrade(raul3);
        dao.addGrade(raul4);
        dao.addGrade(raul5);
        dao.addGrade(raul6);
        dao.addGrade(raul7);
        dao.addGrade(raul8);
        dao.addGrade(raul9);
        dao.addGrade(raul10);
        dao.addGrade(raul11);
        dao.addGrade(raul12);
        dao.addGrade(raul13);
        dao.addGrade(raul14);
        dao.addGrade(raul15);
        dao.addGrade(raul16);
        dao.addGrade(raul17);
        dao.addGrade(raul18);
        dao.addGrade(raul19);
        dao.addGrade(raul20);
        dao.addGrade(raul21);
        dao.addGrade(raul22);
        dao.addGrade(raul23);
        dao.addGrade(raul24);

        dao.addGrade(emory1);
        dao.addGrade(emory2);
        dao.addGrade(emory3);
        dao.addGrade(emory4);
        dao.addGrade(emory5);
        dao.addGrade(emory6);
        dao.addGrade(emory6);
        dao.addGrade(emory7);
        dao.addGrade(emory8);
        dao.addGrade(emory9);
        dao.addGrade(emory10);
        dao.addGrade(emory11);
        dao.addGrade(emory12);
        dao.addGrade(emory13);
        dao.addGrade(emory14);
        dao.addGrade(emory15);
        dao.addGrade(emory16);
        dao.addGrade(emory17);
        dao.addGrade(emory18);

        dao.addGrade(daniel1);
        dao.addGrade(daniel2);
        dao.addGrade(daniel3);
        dao.addGrade(daniel4);
        dao.addGrade(daniel5);
        dao.addGrade(daniel6);
        dao.addGrade(daniel7);
        dao.addGrade(daniel8);
        dao.addGrade(daniel9);
        dao.addGrade(daniel10);
        dao.addGrade(daniel11);
        dao.addGrade(daniel12);
        dao.addGrade(daniel13);
        dao.addGrade(daniel14);
        dao.addGrade(daniel15);
        dao.addGrade(daniel16);
        dao.addGrade(daniel17);
        dao.addGrade(daniel18);

        dao.addGrade(athena1);
        dao.addGrade(athena2);
        dao.addGrade(athena3);
        dao.addGrade(athena4);
        dao.addGrade(athena5);
        dao.addGrade(athena6);
        dao.addGrade(athena7);
        dao.addGrade(athena8);
        dao.addGrade(athena9);
        dao.addGrade(athena10);
        dao.addGrade(athena11);
        dao.addGrade(athena12);
        dao.addGrade(athena13);
        dao.addGrade(athena14);
        dao.addGrade(athena15);
        dao.addGrade(athena16);
        dao.addGrade(athena17);
        dao.addGrade(athena18);
        Log.d("GradeRoom", "78 Grade added to Database");

    }
}

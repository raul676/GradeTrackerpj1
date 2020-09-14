package com.example.gradetracker_pj1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Delete;

import com.example.gradetracker_pj1.model.Course;
import com.example.gradetracker_pj1.model.GradeDao;
import com.example.gradetracker_pj1.model.GradeRoom;
import com.example.gradetracker_pj1.model.User;


import java.util.List;

public class DeleteCourse extends AppCompatActivity {

    List<Course> deleteCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("DeleteCourse", "onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletecourse_activity);

        GradeRoom.getGradeRoom(DeleteCourse.this).loadData(this);

        Button enter_button = findViewById(R.id.enter_button);

        enter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("DeleteCourse", "Enter the Course id");

                EditText id = findViewById(R.id.courseID);
                String coursenum = id.getText().toString();
                int course_id =Integer.parseInt(coursenum);

                GradeDao dao = GradeRoom.getGradeRoom(DeleteCourse.this).dao();
               // course = GradeRoom.getGradeRoom(DeleteCourse.this).dao().getAllCourses();
                //Course deletecourse = dao.searchCourse(course_id);

                if (coursenum != null) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(DeleteCourse.this);
                    builder.setTitle("This course will be deleted ");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //deleting
                         GradeDao dao = GradeRoom.getGradeRoom(DeleteCourse.this).dao();
                            dao.deleteCourse(course_id);
                            Log.d("DeleteCourse", "deletingcourse");
                            //once deleting go to main menu
                            Intent intent = new Intent(DeleteCourse.this, MainMenu.class);
                            startActivity(intent);
                        }

                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();


                }
            }


        });


    }
}


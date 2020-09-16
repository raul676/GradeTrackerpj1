package com.example.gradetracker_pj1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;

import com.example.gradetracker_pj1.model.Enrollment;
import com.example.gradetracker_pj1.model.GradeRoom;


public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MainMenu", "onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menumain_activity);

        TextView msg = findViewById(R.id.welcome_user_msg);
        msg.setText("Welcome " + MainActivity.username);
        /**
         * There is a lot of buttons here: please use them to check if your class loads up (all
         * buttons are set to editcourse) we can always get rid of a lot of these buttons. Also
         * the Back button needs to be changed to the log out button.
         */
        Button back_button = findViewById(R.id.back_button);
        Button assignment_button = findViewById(R.id.assignment_button);
        Button courseView_button = findViewById(R.id.courseView_button);
        Button gradesView_button = findViewById(R.id.gradesView_button);

        //view courses
        courseView_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, ViewCourseActivity.class);
                startActivity(intent);
            }
        });

        //view assignments
        assignment_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, ViewAssignmentsActivity.class);
                startActivity(intent);
            }
        });

        //view grades
        gradesView_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, ViewGradeActivity.class);
                startActivity(intent);
            }
        });


      //change this to logout
      back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }



}

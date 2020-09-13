package com.example.gradetracker_pj1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.Button;


public class MainMenu extends AppCompatActivity {

    /**
     * This method contains all the buttons for the user to click to navigate through the app, each button leads to a new page
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MainMenu", "onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menumain_activity);


        Button edit_button = findViewById(R.id.edit_button);
        Button back_button = findViewById(R.id.back_button);
        Button assignment_button = findViewById(R.id.assignment_button);
        Button assignmentEdit_button = findViewById(R.id.assignmentEdit_button);
        Button gradesView_button = findViewById(R.id.gradesView_button);
        Button courseView_button = findViewById(R.id.courseView_button);
        Button course_button = findViewById(R.id.courseView_button);

        //enrollment
        course_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, EditCourse.class);
                startActivity(intent);
            }
        });

        //view courses
        courseView_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, ViewCourseActivity.class);
                startActivity(intent);
            }
        });

        //edit courses
       edit_button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainMenu.this, EditCourse.class);
               startActivity(intent);
           }
       });

       //views assignments
        assignment_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, EditCourse.class);
                startActivity(intent);
            }
        });

        //edit assignments
        assignmentEdit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, EditCourse.class);
                startActivity(intent);
            }
        });

        //view grades
        gradesView_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent = new Intent(MainMenu.this, ViewGradesActivity.class);
                //startActivity(intent);
            }
        });


      //Logout button
      back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }



}

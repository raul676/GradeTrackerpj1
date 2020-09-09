package com.example.gradetracker_pj1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainMenu extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MainMenu", "onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button edit_course = findViewById(R.id.editCourse);
        Button view_assignments = findViewById(R.id.viewAssignments);
        Button enroll_course = findViewById(R.id.viewCourse);
        Button back_main = findViewById(R.id.back_Main);

        enroll_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainMenu.this, ViewCourseActivity.class);
                //startActivity(intent);
            }
        });

        edit_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, EditCourse.class);
                startActivity(intent);
            }
        });

        back_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }



}

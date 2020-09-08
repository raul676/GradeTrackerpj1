package com.example.gradetracker_pj1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class EditCourse extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("EditCourse", "onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editcourse_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button add_course = findViewById(R.id.addCourse);
        Button delete_course = findViewById(R.id.deleteCourse);
        Button back_main = findViewById(R.id.back_Main);

        add_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditCourse.this, AddCourse.class);
                startActivity(intent);
            }
        });

        delete_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditCourse.this, DeleteCourse.class);
                startActivity(intent);
            }
        });

     back_main.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //not sure about main act lead back just yet need to update this code
            Intent intent = new Intent(EditCourse.this, MainActivity.class);
            startActivity(intent);
        }
    });
}


    }



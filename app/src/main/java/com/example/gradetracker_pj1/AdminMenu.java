package com.example.gradetracker_pj1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
public class AdminMenu extends AppCompatActivity {
    /** This is the main menu for when the admin logs in*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView msg = findViewById(R.id.welcome_user_msg_admin);
        msg.setText("Welcome " + MainActivity.admin_user + "\n Please select an option to proceed.");

        Button back_button = findViewById(R.id.back_button_admin);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /** Each button leads to a page the admin has access to */
        Button add_assignment = findViewById(R.id.add_assignment_button);
        add_assignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminMenu.this, AddAssignment.class);
                startActivity(intent);
            }
        });

        Button add_course = findViewById(R.id.add_course_button);
        add_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminMenu.this, AddCourse.class);
                startActivity(intent);
            }
        });

        Button delete_assignment = findViewById(R.id.delete_assignment_button);
        delete_assignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminMenu.this, DeleteAssignment.class);
                startActivity(intent);
            }
        });

        Button delete_course = findViewById(R.id.delete_course_button);
        delete_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminMenu.this, DeleteCourse.class);
                startActivity(intent);
            }
        });

        Button edit_assignment = findViewById(R.id.edit_assignment_button);
        edit_assignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminMenu.this, EditAssignment.class);
                startActivity(intent);
            }
        });

        Button edit_course = findViewById(R.id.edit_course_button);
        edit_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminMenu.this, EditCourse.class);
                startActivity(intent);
            }
        });
    }
}

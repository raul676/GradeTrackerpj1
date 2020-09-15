package com.example.gradetracker_pj1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class EditAssignment extends AppCompatActivity {

    // this is a update check
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("EditAssignment", "onCreate called");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.editassignment_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button addAssignment = findViewById(R.id.AddAssignmentBtn);
        Button deleteAssignment = findViewById(R.id.DeleteAssignmentBtn);
        Button backBtn = findViewById(R.id.BackBtn);


        addAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditAssignment.this, AddAssignment.class);
                startActivity(intent);
            }
        });

        deleteAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditAssignment.this, DeleteAssignment.class);
                startActivity(intent);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //not sure about main act lead back just yet need to update this code
                Intent intent = new Intent(EditAssignment.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

package com.example.gradetracker_pj1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gradetracker_pj1.model.GradeDao;

import org.w3c.dom.Text;

public class DeleteAssignment extends AppCompatActivity {

    EditText deleteAssignmentId;
    Button deleteAssignmentBtn;
    Button backBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState){ // starts application
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_assignments);

        deleteAssignmentId = findViewById(R.id.deleteAssignmentId);
        deleteAssignmentBtn = findViewById(R.id.submitBtn);
        backBtn = findViewById(R.id.backBtn);


    }
    // QUERY IN DB
      //-SEARCH, FIND AND REMOVE






}

package com.example.gradetracker_pj1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gradetracker_pj1.model.Assignment;
import com.example.gradetracker_pj1.model.Course;
import com.example.gradetracker_pj1.model.GradeDao;
import com.example.gradetracker_pj1.model.GradeRoom;

public class AddAssignment extends AppCompatActivity {
    /** References */
    EditText assignmentId, courseId, categoryId, maxScore, earnedScore, details, assignedDate, dueDate;
    Button submit, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){ // starts application
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_assignment);

        assignmentId = findViewById(R.id.assignmentId);
        courseId = findViewById(R.id.courseId);
        categoryId = findViewById(R.id.categoryId);
        maxScore = findViewById(R.id.maxScore);
        details = findViewById(R.id.details);
        assignedDate = findViewById(R.id.assignmentDate);
        dueDate = findViewById(R.id.dueDate);
        submit = findViewById(R.id.btnAddAssignments);
        backBtn = findViewById(R.id.backBtn);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /** A try catch used to catch if the user input was invaild when adding an assignment*/
                try {
                    GradeDao dao = GradeRoom.getGradeRoom(AddAssignment.this).dao();
                    Assignment assignmenttemp = dao.searchAssignment2(Integer.parseInt(assignmentId.getText().toString()));
                    if (assignmenttemp == null) {
                        Assignment assignment = new Assignment(Integer.parseInt(assignmentId.getText().toString()), Integer.parseInt(courseId.getText().toString()), Integer.parseInt(categoryId.getText().toString()), Integer.parseInt(maxScore.getText().toString()), details.getText().toString(), assignedDate.getText().toString(), dueDate.getText().toString());
                        dao.addAssignment(assignment);
                        Toast.makeText(AddAssignment.this, assignment.toString() + "\nHas been added.", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(AddAssignment.this, "Assignment ID already being used", Toast.LENGTH_SHORT).show();

                    }
                }catch (Exception e){
                    Toast.makeText(AddAssignment.this, "Enter valid input", Toast.LENGTH_SHORT).show();

                }
            }

        });

        /** Returns the user back to the main page */
        Button backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
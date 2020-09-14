package com.example.gradetracker_pj1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gradetracker_pj1.model.Assignment;
import com.example.gradetracker_pj1.model.Course;
import com.example.gradetracker_pj1.model.GradeDao;

public class AddAssignment extends AppCompatActivity {
    // references
    EditText assignmentId, courseId, categoryId, maxScore, earnedScore, details, assignedDate, dueDate;
    Button submit;

    GradeDao gradeDao;
     




    @Override
    protected void onCreate(Bundle savedInstanceState){ // starts application
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_assignment);

        //variables

        assignmentId = findViewById(R.id.assignmentId);
        courseId = findViewById(R.id.courseId);
        categoryId = findViewById(R.id.categoryId);
        maxScore = findViewById(R.id.maxScore);
        earnedScore = findViewById(R.id.earnedScore);
        details = findViewById(R.id.details);
        assignedDate = findViewById(R.id.assignmentDate);
        dueDate = findViewById(R.id.dueDate);
        submit = findViewById(R.id.btnAddCourse);

        // button listener

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Assignment assignment;
                try {

                    assignment = new Assignment(Integer.parseInt(assignmentId.getText().toString()), Integer.parseInt(courseId.getText().toString()), Integer.parseInt(categoryId.getText().toString()),Integer.parseInt(maxScore.getText().toString()), Integer.parseInt(earnedScore.getText().toString()), details.getText().toString(), assignedDate.getText().toString(), dueDate.getText().toString());

                 //   assignment = new Assignment(Integer.parseInt(assignmentId.getText().toString(), Integer.parseInt(courseId.getText().toString(), Integer.parseInt(categoryId.getText().toString(),Integer.parseInt(maxScore.getText().toString(), Integer.parseInt(earnedScore.getText().toString(), details.getText().toString(), Integer.parseInt(assignedDate.getText().toString(), Integer.parseInt(dueDate.getText().toString())));

                  //  Toast.makeText(AddAssignment.this, assignment.toString(), Toast.LENGTH_SHORT).show();


                   // assignment = new Assignment(Integer.parseInt(assignmentId.getText().toString(), Integer.parseInt(courseId.getText().toString(), Integer.parseInt(categoryId.getText().toString(),Integer.parseInt(maxScore.getText().toString(), Integer.parseInt(earnedScore.getText().toString(), details.getText().toString(), Integer.parseInt(assignedDate.getText().toString(), Integer.parseInt(dueDate.getText().toString())))))));


                   // Toast.makeText(AddAssignment.this, assignment.toString(), Toast.LENGTH_SHORT).show();

                   // Toast.makeText(AddAssignment.this, "submit button works", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(AddAssignment.this,"Error ", Toast.LENGTH_SHORT).show(); // non integer input
                    assignment = new Assignment(-1,-1,-1,-1,"error","error","error"); // default values
                }



              //  gradeDao.addAssignment(assignment);
                //gradeDao.addAssignment(assignment);



            }
        });

    }

}

package com.example.gradetracker_pj1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gradetracker_pj1.model.Course;
import com.example.gradetracker_pj1.model.GradeDao;
import com.example.gradetracker_pj1.model.GradeRoom;

public class AddCourse extends AppCompatActivity{

    // references
    EditText courseId, instructor, course_title, startDate, description, endDate;
    Button submit;

    GradeDao gradeDao;




    @Override
    protected void onCreate(Bundle savedInstanceState){ // starts application


        super.onCreate(savedInstanceState);



        setContentView(R.layout.addcourse);

        //variables

        courseId = findViewById(R.id.course_id);
        instructor = findViewById(R.id.instructor_name);
        course_title = findViewById(R.id.course_title);
        startDate = findViewById(R.id.startDate);
        endDate = findViewById(R.id.endDate);
        submit = findViewById(R.id.btnAddCourse);

        // button listener

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Course course;
                try {

                    course = new Course(Integer.parseInt(courseId.getText().toString()), instructor.getText().toString(), course_title.getText().toString(), description.getText().toString(), startDate.getText().toString(), endDate.getText().toString());

                    Toast.makeText(AddCourse.this, course.toString(), Toast.LENGTH_SHORT).show();
                    // Toast.makeText(AddCourse.this, "submit button works", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(AddCourse.this,"Error ", Toast.LENGTH_SHORT).show(); // non integer input
                    course = new Course(-1,"error","error","error","error","error"); // default values
                }


               gradeDao.addCourse(course);


            }
        });
        /** Returns the user back to the main page */
        Button back_button = findViewById(R.id.back_button_add);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }






}

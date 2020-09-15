package com.example.gradetracker_pj1;

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

    GradeDao gradeDao = GradeRoom.getGradeRoom(this).dao();

    @Override
    protected void onCreate(Bundle savedInstanceState){ // starts application
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcourse);

        //variables

        courseId = findViewById(R.id.course_id);
        instructor = findViewById(R.id.instructor_name);
        course_title = findViewById(R.id.course_title);
        description = findViewById(R.id.Discription);
        startDate = findViewById(R.id.startDate);
        endDate = findViewById(R.id.endDate);


        submit = findViewById(R.id.btnAddCourse);

        // button listener

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(gradeDao.searchCourse(Integer.parseInt(courseId.getText().toString())) != null)
                    {
                        Toast.makeText(AddCourse.this,"Course ID already exists ", Toast.LENGTH_SHORT).show(); // non integer input
                    }
                    else {
                        Course course = new Course(Integer.parseInt(courseId.getText().toString()), instructor.getText().toString(), course_title.getText().toString(), description.getText().toString(), startDate.getText().toString(), endDate.getText().toString());
                        gradeDao.addCourse(course);

                        Toast.makeText(AddCourse.this, course.toString(), Toast.LENGTH_SHORT).show();
                        // Toast.makeText(AddCourse.this, "submit button works", Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e) {
                    Toast.makeText(AddCourse.this,"Error ", Toast.LENGTH_SHORT).show(); // non integer input
                   // course = new Course(-1,"error","error","error","error","error"); // default values
                }

            }
        });

        Button back_button = findViewById(R.id.back_button_add);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }






}

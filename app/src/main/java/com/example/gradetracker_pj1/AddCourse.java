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

    /**References */
    EditText courseId, instructor, course_title, startDate, description, endDate;
    Button submit;
    GradeDao gradeDao = GradeRoom.getGradeRoom(this).dao();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcourse);

        courseId = findViewById(R.id.course_id);
        instructor = findViewById(R.id.instructor_name);
        course_title = findViewById(R.id.course_title);
        description = findViewById(R.id.Discription);
        startDate = findViewById(R.id.startDate);
        endDate = findViewById(R.id.endDate);
        submit = findViewById(R.id.btnAddCourse);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**A try to see if the course ID exists or can be added */
                try {
                    if(gradeDao.searchCourse(Integer.parseInt(courseId.getText().toString())) != null)
                    {
                        Toast.makeText(AddCourse.this,"Course ID already exists ", Toast.LENGTH_SHORT).show(); // non integer input
                    }
                    else {
                        Course course = new Course(Integer.parseInt(courseId.getText().toString()), instructor.getText().toString(), course_title.getText().toString(), description.getText().toString(), startDate.getText().toString(), endDate.getText().toString());
                        gradeDao.addCourse(course);

                        Toast.makeText(AddCourse.this, course.toString(), Toast.LENGTH_SHORT).show();
                    }

                } /**A catch if there is invaild input */
                catch (Exception e) {
                    Toast.makeText(AddCourse.this,"Error ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /**Returns user to the main page */
        Button back_button = findViewById(R.id.back_button_add);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }






}

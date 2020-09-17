package com.example.gradetracker_pj1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Delete;

import com.example.gradetracker_pj1.model.Assignment;
import com.example.gradetracker_pj1.model.Course;
import com.example.gradetracker_pj1.model.Enrollment;
import com.example.gradetracker_pj1.model.Grade;
import com.example.gradetracker_pj1.model.GradeCategory;
import com.example.gradetracker_pj1.model.GradeDao;
import com.example.gradetracker_pj1.model.GradeRoom;
import com.example.gradetracker_pj1.model.User;


import java.util.List;

public class DeleteCourse extends AppCompatActivity {

    List<Course> courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("DeleteCourse", "onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletecourse_activity);

        GradeRoom.getGradeRoom(DeleteCourse.this).loadData(this);

        Button enter_button = findViewById(R.id.enter_button);

        enter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("DeleteCourse", "Enter the Course id");

                /**Finding the course Id by parsing the string to an int */
                EditText id = findViewById(R.id.courseID);
                String course = id.getText().toString();
                int course_id =Integer.parseInt(course);

                /**A simple try catch to test the parsing of an string to an int */
                try {
                    Integer.parseInt(course);
                } catch (NumberFormatException e ){
                    id.setError("wrong Input");
                }

                GradeDao dao = GradeRoom.getGradeRoom(DeleteCourse.this).dao();
                courses = GradeRoom.getGradeRoom(DeleteCourse.this).dao().getAllCourses();
                Course course1 = dao.searchCourse(course_id);
/** if the course is not not the course will be deleted along with the grades */
                if (course1 != null) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(DeleteCourse.this);
                    builder.setTitle("This course will be deleted ");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            List<Grade> grades = GradeRoom.getGradeRoom(DeleteCourse.this).dao().searchGrades_toDelete(course_id);
                            List<Assignment> assignments = GradeRoom.getGradeRoom(DeleteCourse.this).dao().searchAssignment_to_delete(course_id);
                            List<Enrollment> enrollments = GradeRoom.getGradeRoom(DeleteCourse.this).dao().searchEnrolledCourses_to_delete(course_id);
                            List<GradeCategory> gradeCategories = GradeRoom.getGradeRoom(DeleteCourse.this).dao().searchGradeCategorys_to_deltet(course_id);

                            GradeDao dao = GradeRoom.getGradeRoom(DeleteCourse.this).dao();
                            dao.deleteCourse(course1);
                            dao.deleteAssignments(assignments);
                            dao.deleteEnrollments(enrollments);
                            dao.deleteGradeCategorys(gradeCategories);
                            dao.deleteGrades(grades);

                            Log.d("DeleteCourse", "deletingcourse");
                            finish();
                        }

                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(DeleteCourse.this);
                    builder.setTitle("Course does not exist.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //finish();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }


        });
        /** Returns the user back to the main page */
        Button backBtn = findViewById(R.id.back_button);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}

package com.example.gradetracker_pj1;

import android.content.DialogInterface;
import android.media.ExifInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gradetracker_pj1.model.Course;
import com.example.gradetracker_pj1.model.Enrollment;
import com.example.gradetracker_pj1.model.GradeDao;
import com.example.gradetracker_pj1.model.GradeRoom;

public class ViewCourseActivity extends AppCompatActivity {

    List<Course> courses;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        Log.d("LoginActivity", "onCreate called");
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_view_course);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button select_course = findViewById(R.id.select_course);
        select_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    EditText course = findViewById(R.id.course_id);
                    int course_id = Integer.parseInt(course.getText().toString());

                    Course course1 = GradeRoom.getGradeRoom(ViewCourseActivity.this).dao().searchCourse(course_id);
                    if (course1 == null) {
                        Toast.makeText(ViewCourseActivity.this, "Course ID doesn't exist ", Toast.LENGTH_SHORT).show(); // non integer input
                    } else {
                        Random random = new Random();
                        int random_var = random.nextInt(99999 - 1);
                        Enrollment enr = GradeRoom.getGradeRoom(ViewCourseActivity.this).dao().searchEnrollment(course_id, MainActivity.userid);
                        if (enr == null) {
                            Enrollment enrollment = new Enrollment(random_var, course_id, MainActivity.userid, "9/01/20");
                            GradeDao dao = GradeRoom.getGradeRoom(ViewCourseActivity.this).dao();
                            dao.addEnrollment(enrollment);
                            AlertDialog.Builder builder = new AlertDialog.Builder(ViewCourseActivity.this);
                            builder.setTitle("You are now enrolled in this course!");
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(ViewCourseActivity.this);
                            builder.setTitle("You're already enrolled in this course.");
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
                }catch (Exception e){
                    AlertDialog.Builder builder = new AlertDialog.Builder(ViewCourseActivity.this);
                    builder.setTitle("Enter valid course ID.");
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



        Button return_main_button = findViewById(R.id.main_menu_course);
        return_main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ViewCourseActivity",  "onClick return called");
                finish();
            }
        });

        courses = GradeRoom.getGradeRoom(this).dao().getAllCourses();
        Log.d("ViewCourseActivity", "Courses's" + courses.size());
        RecyclerView rv = findViewById(R.id.recycler_view_2);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new Adapter());

    }
    private class Adapter extends RecyclerView.Adapter<ItemHolder> {

        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(ViewCourseActivity.this);
            return new  ItemHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ItemHolder holder, int position){
            holder.bind(courses.get(position));
        }

        @Override
        public int getItemCount() { return courses.size(); }
    }

    private class ItemHolder extends RecyclerView.ViewHolder {

        public ItemHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item, parent, false));
        }

        public void bind(Course f ) {
            TextView item = itemView.findViewById(R.id.item_id);
            item.setText(f.toString());
        }
    }

}

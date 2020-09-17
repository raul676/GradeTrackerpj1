package com.example.gradetracker_pj1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gradetracker_pj1.model.Assignment;
import com.example.gradetracker_pj1.model.Enrollment;
import com.example.gradetracker_pj1.model.Grade;
import com.example.gradetracker_pj1.model.Course;
import com.example.gradetracker_pj1.model.GradeDao;
import com.example.gradetracker_pj1.model.GradeRoom;
public class ViewGradeActivity extends  AppCompatActivity{
    List <Enrollment> enrollments;
    public static int course_id_sat;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        Log.d("LoginActivity", "onCreate called");
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_view_grades);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button main_menu = findViewById(R.id.main_menu_grades);
        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /** A recycler view to get courses the student can enroll in  */
        enrollments= GradeRoom.getGradeRoom(this).dao().searchEnrolledCourse(MainActivity.userid);
        Log.d("ViewCourseActivity", "Courses's" + enrollments.size());
        RecyclerView rv = findViewById(R.id.recycler_view_grades);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new Adapter());

    }
    /**
     * The Adapter for the RecyclerView for ItemHolders, the constructor helps create the view
     * and the bind view binds the items to the holder
     */
    private class Adapter extends RecyclerView.Adapter<ItemHolder> {

        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(ViewGradeActivity.this);
            return new ItemHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ItemHolder holder, int position) {
            holder.bind(enrollments.get(position));
        }

        @Override
        public int getItemCount() {
            return enrollments.size();
        }

    }
        private class ItemHolder extends RecyclerView.ViewHolder {

            public ItemHolder(LayoutInflater inflater, ViewGroup parent) {
                super(inflater.inflate(R.layout.item, parent, false));
            }

            public void bind(Enrollment f) {
                TextView item = itemView.findViewById(R.id.item_id);
                item.setText(f.toString());

                item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            int course_id = f.getCourse_id();

                            //GradeDao daoo = GradeRoom.getGradeRoom(ViewGradeActivity.this).dao();
                            //Grade grades = daoo.searchGrade(course_id,MainActivity.userid);
                            List<Grade> grades = GradeRoom.getGradeRoom(ViewGradeActivity.this).dao().searchGrades(course_id, MainActivity.userid);
                            if (grades != null) {
                                ViewGradeActivity.course_id_sat = course_id;
                                Intent intent = new Intent(ViewGradeActivity.this,ViewGradeActivity2.class );
                                startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(ViewGradeActivity.this);
                                builder.setTitle("No course found.");
                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //finish();
                                    }
                                });
                                AlertDialog dialog = builder.create();
                                dialog.show();
                            }
                            /**A catch if the user has input a wrong course ID */
                        }catch (Exception e)
                        {
                            AlertDialog.Builder builder = new AlertDialog.Builder(ViewGradeActivity.this);
                            builder.setTitle("Please enter a valid course ID.");
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
            }
        }
    }


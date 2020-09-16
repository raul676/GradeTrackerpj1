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

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gradetracker_pj1.model.Course;
import com.example.gradetracker_pj1.model.GradeRoom;

import java.util.List;

public class EditCourse extends AppCompatActivity {
    List<Course> courseList;
    public int course_id =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("EditCourse", "onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editcourse_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button search_button = findViewById(R.id.search_course_edit);
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** A try to get the course Id and parse the course Id into an integer */
                try {
                    EditText course = findViewById(R.id.enter_course_id_edit);
                    course_id = Integer.parseInt(course.getText().toString());

                    courseList = GradeRoom.getGradeRoom(EditCourse.this).dao().searchCourse2(course_id);
                  /** If the course list is null the user is told the course can not be found */
                    if (courseList == null) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(EditCourse.this);
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
                    /** A catch to throw an expection if the user enters an invalid course id */
                }catch (Exception e){
                    AlertDialog.Builder builder = new AlertDialog.Builder(EditCourse.this);
                    builder.setTitle("Enter Valid course ID.");
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

        /** A  Recycler view is implemented to show courses that are retrieved from the Room*/
        courseList = GradeRoom.getGradeRoom(EditCourse.this).dao().searchCourse2(course_id);
        Log.d("ViewCourseActivity", "EditAssignments" + courseList.size());
        RecyclerView rv = findViewById(R.id.recycler_view_course_edit);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new Adapter());

        Button edit_course_final = findViewById(R.id.edit_course_final);
        edit_course_final.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**A try to allow users to edit course information, if the course list is null the user has to enter the course id, else
                 * the course will update with edited information
                 */
                try {
                    EditText instruc = findViewById(R.id.edit_instructor);
                    EditText enddate = findViewById(R.id.edit_end_date);
                    String instructor = instruc.getText().toString();
                    String end_date = enddate.getText().toString();

                    if (courseList == null) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(EditCourse.this);
                        builder.setTitle("Confirm Course ID first.");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //finish();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    } else {
                        courseList.get(0).setInstructor(instructor);
                        courseList.get(0).setEnd_date(end_date);
                        GradeRoom.getGradeRoom(EditCourse.this).dao().updateCourse(courseList);
                        AlertDialog.Builder builder = new AlertDialog.Builder(EditCourse.this);
                        builder.setTitle("Course has been edited!");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                    /** A catch used to throw an exception if the user has an invaild course */
                }catch (Exception e){
                    GradeRoom.getGradeRoom(EditCourse.this).dao().updateCourse(courseList);
                    AlertDialog.Builder builder = new AlertDialog.Builder(EditCourse.this);
                    builder.setTitle("Must choose valid course first");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

            }
        });

        /** If the user clicks the back button they will be lead back to main menu */
        Button back_button = findViewById(R.id.edit_course_back);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * The Adapter for the RecyclerView for ItemHolders, the constructor helps create the view
     * and the bind view binds the items to the holder
     */
    private class Adapter extends RecyclerView.Adapter<ItemHolder> {

        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(EditCourse.this);
            return new ItemHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ItemHolder holder, int position) {
            holder.bind(courseList.get(position));
        }

        @Override
        public int getItemCount() {
            return courseList.size();
        }

    }
    private class ItemHolder extends RecyclerView.ViewHolder {

        public ItemHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item, parent, false));
        }

        public void bind(Course f) {
            TextView item = itemView.findViewById(R.id.item_id);
            item.setText(f.toString());
        }
    }
}

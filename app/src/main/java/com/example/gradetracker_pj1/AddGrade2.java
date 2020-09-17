package com.example.gradetracker_pj1;

import android.content.DialogInterface;
import android.content.Intent;
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
import com.example.gradetracker_pj1.model.User;
public class AddGrade2 extends  AppCompatActivity{
    List<Enrollment> enrollments;
    public static int course_id_add;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        Log.d("LoginActivity", "onCreate called");
        super.onCreate(saveInstanceState);
        setContentView(R.layout.addgrade2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button next_button = findViewById(R.id.add_grade2_button);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    EditText coursetemp = findViewById(R.id.course_id_add);
                    String course_string = coursetemp.getText().toString();
                    int course_id = Integer.parseInt(course_string);

                    Course course = GradeRoom.getGradeRoom(AddGrade2.this).dao().searchCourse(course_id);
                    if (course != null) {
                        AddGrade2.course_id_add = course_id;
                        Intent intent = new Intent(AddGrade2.this, AddGrade3.class);
                        startActivity(intent);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(AddGrade2.this);
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
                }catch (Exception e){
                    AlertDialog.Builder builder = new AlertDialog.Builder(AddGrade2.this);
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

        enrollments = GradeRoom.getGradeRoom(this).dao().searchEnrolledCourse(AddGrade1.student_id_add);
        Log.d("ViewCourseActivity", "Courses's" + enrollments.size());
        RecyclerView rv = findViewById(R.id.recycler_view_enrolled_courses_student);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new Adapter());

        Button back = findViewById(R.id.main_menu_add_grade2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(AddGrade2.this,AdminMenu.class);
                startActivity(intent);
            }
        });

    }

    private class Adapter extends RecyclerView.Adapter<ItemHolder> {

        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(AddGrade2.this);
            return new ItemHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ItemHolder holder, int position){
            holder.bind(enrollments.get(position));
        }

        @Override
        public int getItemCount() { return enrollments.size(); }
    }

    private class ItemHolder extends RecyclerView.ViewHolder {

        public ItemHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item, parent, false));
        }

        public void bind(Enrollment f ) {
            TextView item = itemView.findViewById(R.id.item_id);
            item.setText(f.toString());
        }
    }
}


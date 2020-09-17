package com.example.gradetracker_pj1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.gradetracker_pj1.model.Course;
import com.example.gradetracker_pj1.model.Grade;
import com.example.gradetracker_pj1.model.GradeDao;
import com.example.gradetracker_pj1.model.GradeRoom;

import java.util.Random;

public class AddGrade3 extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        Log.d("LoginActivity", "onCreate called");
        super.onCreate(saveInstanceState);
        setContentView(R.layout.addgrade3);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button add_grade = findViewById(R.id.add_new_grade);
        add_grade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    EditText score = findViewById(R.id.new_score);
                    EditText date = findViewById(R.id.date_earned);
                    EditText category = findViewById(R.id.new_grade_category);

                    String score_str = score.getText().toString();
                    String date_str = date.getText().toString();
                    String category_str = category.getText().toString();

                    int score_int = Integer.parseInt(score_str);
                    int category_int = Integer.parseInt(category_str);

                    Random random = new Random();
                    int random_num = random.nextInt(10000);
                    int gradetracker = random_num;
                    String p1 = Integer.toString(category_int);
                    String p2 = Integer.toString(AddGrade2.course_id_add);
                    String p3 = p2 + p1;
                    int assignment_id = Integer.parseInt(p3);
                    boolean is_true1 = true;
                    boolean is_true2 = false;
                    if (score_int > 10) {
                        is_true1 = false;
                    }
                    int arr[] = {10, 20, 30, 40};
                    for (int i = 0; i < 4; i++) {
                        if (category_int == arr[i]) {
                            is_true2 = true;
                        }
                    }
                    if (!is_true1 || !is_true2) {
                        Toast.makeText(AddGrade3.this, "Correct values are needed!", Toast.LENGTH_SHORT).show(); // non integer input

                    }
                    if (is_true1 && is_true2) {
                        GradeDao dao = GradeRoom.getGradeRoom(AddGrade3.this).dao();
                        Grade grade = new Grade(gradetracker, category_int, score_int, assignment_id, AddGrade2.course_id_add, AddGrade1.student_id_add, date_str);
                        dao.addGrade(grade);
                        Toast.makeText(AddGrade3.this, "Grade has been added!", Toast.LENGTH_SHORT).show(); // non integer input
                        Intent intent = new Intent(AddGrade3.this, AdminMenu.class);
                        startActivity(intent);

                    }
                }catch (Exception e){
                    Toast.makeText(AddGrade3.this, "Input valid information!", Toast.LENGTH_SHORT).show(); // non integer input

                }
            }
        });

        Button back = findViewById(R.id.main_menu_add_grade3);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddGrade3.this, AdminMenu.class);
                startActivity(intent);
            }
        });

    }
}

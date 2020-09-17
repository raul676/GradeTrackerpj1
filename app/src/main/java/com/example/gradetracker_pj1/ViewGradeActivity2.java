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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gradetracker_pj1.model.Enrollment;
import com.example.gradetracker_pj1.model.Grade;
import com.example.gradetracker_pj1.model.Course;
import com.example.gradetracker_pj1.model.GradeCategory;
import com.example.gradetracker_pj1.model.GradeRoom;

import org.w3c.dom.Text;

public class ViewGradeActivity2 extends  AppCompatActivity{
    List <Grade> grades;
    List<GradeCategory>gradeCategories;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        Log.d("LoginActivity", "onCreate called");
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_view_grade2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView msg = findViewById(R.id.grade_text_course);
        msg.setText("Here are you grades for course: " + ViewGradeActivity.course_id_sat);

        /** A recycler view to get the grades for the corresponding course the user has input*/
        grades = GradeRoom.getGradeRoom(this).dao().searchGrades(ViewGradeActivity.course_id_sat,MainActivity.userid);
        Log.d("ViewCourseActivity", "Courses's" + grades.size());
        RecyclerView rv = findViewById(R.id.recycler_view_grades_2);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new ViewGradeActivity2.Adapter());

/** A recycler view to get the grade categories for the corresponding course the user has input*/
        gradeCategories = GradeRoom.getGradeRoom(this).dao().searchGradeCategory(ViewGradeActivity.course_id_sat);
        Log.d("ViewCourseActivity", "Courses's" + gradeCategories.size());
        RecyclerView rv2 = findViewById(R.id.recycler_view_grades_category);
        rv2.setLayoutManager(new LinearLayoutManager(this));
        rv2.setAdapter(new ViewGradeActivity2.Adapter2());

        /** An array list with the users grades the grades are added with the total score*/
        String letter_grade;
        ArrayList<Integer> listgrade = new ArrayList<>();
        int total =0;
        for(int i =0; i < grades.size(); i++) {
            listgrade.add(GradeRoom.getGradeRoom(this).dao().searchGrades(ViewGradeActivity.course_id_sat, MainActivity.userid).get(i).getScore());
        }
        for(int i =0; i < listgrade.size(); i++)
        {
            total = total + listgrade.get(i);
        }

        /**A message to show the user their final grade for a course */
        TextView msg2 = findViewById(R.id.grade_letter);
        if(grades.size() != 0) {
            total = total / grades.size();
        }
       String final_letter_grade =  returnLetterGrade(total);
        msg2.setText("Total Letter Grade: " + final_letter_grade);

        Button main_menu = findViewById(R.id.back_button_grade);
        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewGradeActivity2.this, ViewGradeActivity.class);
                startActivity(intent);
            }
        });

    }
    private class Adapter extends RecyclerView.Adapter<ItemHolder> {

        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(ViewGradeActivity2.this);
            return new ItemHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ItemHolder holder, int position) {
            holder.bind(grades.get(position));
        }

        @Override
        public int getItemCount() {
            return grades.size();
        }

    }
    private class ItemHolder extends RecyclerView.ViewHolder {

        public ItemHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item, parent, false));
        }

        public void bind(Grade f) {
            TextView item = itemView.findViewById(R.id.item_id);
            item.setText(f.toString());
        }
    }

    private class Adapter2 extends RecyclerView.Adapter<ItemHolder2> {

        @Override
        public ItemHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(ViewGradeActivity2.this);
            return new ItemHolder2(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ItemHolder2 holder, int position) {
            holder.bind(gradeCategories.get(position));
        }

        @Override
        public int getItemCount() {
            return gradeCategories.size();
        }

    }
    private class ItemHolder2 extends RecyclerView.ViewHolder {

        public ItemHolder2(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item2, parent, false));
        }

        public void bind(GradeCategory f) {
            TextView item = itemView.findViewById(R.id.item_id_2);
            item.setText(f.toString());
        }
    }

    public String returnLetterGrade(int score)
    {
        if(score >=9){return "A";}
        if(score ==8){return "B";}
        if(score ==7){return "C";}
        if(score ==6){return "D";}
        else return "F";
    }
}



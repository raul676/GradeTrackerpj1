package com.example.gradetracker_pj1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gradetracker_pj1.model.Grade;
import com.example.gradetracker_pj1.model.GradeRoom;

import java.util.List;


    public class ViewGradesActivity extends AppCompatActivity {

        List<Grade> grade;
        @Override
        protected void onCreate(Bundle saveInstanceState) {
            Log.d("LoginActivity", "onCreate called");
            super.onCreate(saveInstanceState);
            setContentView(R.layout.viewgrades_activity);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            Button return_main_button = findViewById(R.id.main_menu_course);
            return_main_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("ViewGradesActivity", "onClick return called");
                    finish();
                }
            });

            grade = GradeRoom.getGradeRoom(this).dao().getAllGrades();
            Log.d("ViewGradesActivity", "Grades" + grade.size());
            RecyclerView rv = findViewById(R.id.recycler_view_2);
            rv.setLayoutManager(new LinearLayoutManager(this));
            rv.setAdapter(new com.example.gradetracker_pj1.ViewGradesActivity.Adapter());

        }
        private class Adapter extends RecyclerView.Adapter<ViewGradesActivity.ItemHolder>  {

            @Override
            public com.example.gradetracker_pj1.ViewGradesActivity.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType){
                LayoutInflater layoutInflater = LayoutInflater.from(com.example.gradetracker_pj1.ViewGradesActivity.this);
                return new com.example.gradetracker_pj1.ViewGradesActivity.ItemHolder(layoutInflater, parent);
            }

            @Override
            public void onBindViewHolder(com.example.gradetracker_pj1.ViewGradesActivity.ItemHolder holder, int position){
                holder.bind(grade.get(position));
            }

            @Override
            public int getItemCount() { return grade.size(); }
        }

        private class ItemHolder extends RecyclerView.ViewHolder {

            public ItemHolder(LayoutInflater inflater, ViewGroup parent) {
                super(inflater.inflate(R.layout.item, parent, false));
            }

            public void bind(Grade f ) {
                TextView item = itemView.findViewById(R.id.item_id);
                item.setText(f.toString());
            }
        }

    }



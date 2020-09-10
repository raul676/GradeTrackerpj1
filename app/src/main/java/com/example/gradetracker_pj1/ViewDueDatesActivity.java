package com.example.gradetracker_pj1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gradetracker_pj1.model.Course;
import com.example.gradetracker_pj1.model.GradeRoom;

public class ViewDueDatesActivity extends AppCompatActivity {
    List<String> dueDates;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        Log.d("LoginActivity", "onCreate called");
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_view_course);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button return_main_button = findViewById(R.id.main_menu_course);
        return_main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ViewDueDatesActivity", "onClick return called");
                finish();
            }
        });

        List<Course> courses = GradeRoom.getGradeRoom(this).dao().getAllCourses();
        for(Course i : courses) {
            dueDates.add(i.getCourse_id() + " Ends on " + i.getEnd_date());
        }
        Log.d("ViewDueDatesActivity", "Courses's" + dueDates.size());
        RecyclerView rv = findViewById(R.id.recycler_view_2);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new ViewDueDatesActivity.Adapter());

    }

    private class Adapter extends RecyclerView.Adapter<ViewDueDatesActivity.ItemHolder> {

        @Override
        public ViewDueDatesActivity.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(ViewDueDatesActivity.this);
            return new ViewDueDatesActivity.ItemHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ViewDueDatesActivity.ItemHolder holder, int position){
            holder.bind(dueDates.get(position));
        }

        @Override
        public int getItemCount() { return dueDates.size(); }
    }

    private class ItemHolder extends RecyclerView.ViewHolder {

        public ItemHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item, parent, false));
        }

        public void bind(String f ) {
            TextView item = itemView.findViewById(R.id.item_id);
            item.setText(f.toString());
        }
    }
}

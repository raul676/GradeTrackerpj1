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

import com.example.gradetracker_pj1.model.Assignment;
import com.example.gradetracker_pj1.model.Enrollment;
import com.example.gradetracker_pj1.model.Grade;
import com.example.gradetracker_pj1.model.GradeRoom;
import com.example.gradetracker_pj1.ViewAssignmentsInOneCourseActivity;

import java.util.ArrayList;
import java.util.List;

public class ViewAssignmentsActivity extends AppCompatActivity {
    static List<Assignment> assignments;
    List<Enrollment> enrollments;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        Log.d("LoginActivity", "onCreate called");
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_view_assignments);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /** If the user clicks the return button they are lead back to the main menu */
        Button return_main_button = findViewById(R.id.main_menu_course);
        return_main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ViewAssignmentsActivity", "onClick return called");
                finish();
            }
        });

        enrollments= GradeRoom.getGradeRoom(this).dao().searchEnrolledCourse(MainActivity.userid);
        Log.d("ViewCourseActivity", "Courses's" + enrollments.size());
        RecyclerView rv = findViewById(R.id.recycler_view_enrolled_courses);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new Adapter2());

        /** A list to get all assignments, then if the assignment is not null a Recycler view is implemented to show assignments */
        if(assignments == null) {
            assignments = GradeRoom.getGradeRoom(this).dao().getAllAssignments();
            ArrayList<Assignment> assignments2 = new ArrayList<Assignment>();

            boolean here;
            int number = assignments.size();
            for(Assignment i : assignments) {
                here = false;
                for (Enrollment j : enrollments) {
                    if (i.getCourse_id() == j.getCourse_id()) {
                        here = true;
                        break;
                    }
                }
                if (here){
                    assignments2.add(i);
                }
            }

            assignments = assignments2;
        }

        if(assignments != null)
            Log.d("ViewAssignmentsActivity", "Assignments's" + assignments.size());

        RecyclerView rv2 = findViewById(R.id.recycler_view_assignments);
        rv2.setLayoutManager(new LinearLayoutManager(this));
        rv2.setAdapter(new Adapter());
    }

    /**
     * The Adapter for the RecyclerView for ItemHolders, the constructor helps create the view
     * and the bind view binds the items to the holder
     */
    private class Adapter extends RecyclerView.Adapter<ItemHolder> {

        @Override
        public ViewAssignmentsActivity.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(ViewAssignmentsActivity.this);
            return new ViewAssignmentsActivity.ItemHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ViewAssignmentsActivity.ItemHolder holder, int position){
            holder.bind(assignments.get(position));


        }

        @Override
        public int getItemCount() {
            if(assignments == null){
                return 0;
            }
            return assignments.size();
        }
    }

    private class ItemHolder extends RecyclerView.ViewHolder {

        public ItemHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item, parent, false));
        }

        public void bind(Assignment f ) {
            TextView item = itemView.findViewById(R.id.item_id);
            item.setText(f.toString());
        }
    }


    private class Adapter2 extends RecyclerView.Adapter<ItemHolder2> {

        @Override
        public ItemHolder2 onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(ViewAssignmentsActivity.this);
            return new ItemHolder2(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ItemHolder2 holder, int position){
            holder.bind(enrollments.get(position));
        }

        @Override
        public int getItemCount() {
            if(enrollments == null){
                return 0;
            }
            return enrollments.size();
        }
    }

    private class ItemHolder2 extends RecyclerView.ViewHolder {

        public ItemHolder2(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item2, parent, false));
        }

        public void bind(Enrollment f ) {
            TextView item = itemView.findViewById(R.id.item_id_2);
            item.setText(f.toString());

            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //use position value  to get clicked data from list
                    try {
                        int course_id = f.getCourse_id();

                        //GradeDao daoo = GradeRoom.getGradeRoom(ViewAssignmentsActivity.this).dao();
                        //Grade grades = daoo.searchGrade(course_id,MainActivity.userid);
                        ArrayList<Assignment> assignmentsFilter = new ArrayList<Assignment>();
                        for(Assignment i : assignments) {
                            if(i.getCourse_id() == course_id){
                                assignmentsFilter.add(i);
                            }
                        }

                        ViewAssignmentsInOneCourseActivity.assignments = assignmentsFilter;
                        Intent intent = new Intent(ViewAssignmentsActivity.this, ViewAssignmentsInOneCourseActivity.class);
                        startActivity(intent);
                    }catch (Exception e)
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(ViewAssignmentsActivity.this);
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

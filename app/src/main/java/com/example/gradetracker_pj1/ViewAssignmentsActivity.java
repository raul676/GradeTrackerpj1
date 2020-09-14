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

import com.example.gradetracker_pj1.model.Assignment;
import com.example.gradetracker_pj1.model.Assignment;
import com.example.gradetracker_pj1.model.GradeRoom;

public class ViewAssignmentsActivity extends AppCompatActivity {
    List<String> assignments;

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
                Log.d("ViewAssignmentsActivity", "onClick return called");
                finish();
            }
        });

        // Get all the assignments
        List<Assignment> assignments = GradeRoom.getGradeRoom(this).dao().getAllAssignments();
        // get their end dates
        Log.d("ViewAssignmentsActivity", "Assignments's" + assignments.size());
        //show it on screen
        RecyclerView rv = findViewById(R.id.recycler_view_2);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new ViewAssignmentsActivity.Adapter());

    }

    /*
     * Adapter is a RecyclerView for ItemHolders
     */
    private class Adapter extends RecyclerView.Adapter<ViewAssignmentsActivity.ItemHolder> {

        /*
         * Constructor
         */
        @Override
        public ViewAssignmentsActivity.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(ViewAssignmentsActivity.this);
            return new ViewAssignmentsActivity.ItemHolder(layoutInflater, parent);
        }

        /*
         * bind the items to the holder
         */
        @Override
        public void onBindViewHolder(ViewAssignmentsActivity.ItemHolder holder, int position){
            holder.bind(assignments.get(position));
        }

        @Override
        public int getItemCount() { return assignments.size(); }
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

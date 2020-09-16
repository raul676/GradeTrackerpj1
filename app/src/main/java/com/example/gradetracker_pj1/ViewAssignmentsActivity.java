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

import com.example.gradetracker_pj1.model.Assignment;
import com.example.gradetracker_pj1.model.GradeRoom;

import java.util.List;

public class ViewAssignmentsActivity extends AppCompatActivity {
    List<Assignment> assignments;

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

        /** A list to get all assignments, then if the assignment is not null a Recycler view is implemented to show assignments */
        List<Assignment> assignments = GradeRoom.getGradeRoom(this).dao().getAllAssignments();

        if(assignments != null)
            Log.d("ViewAssignmentsActivity", "Assignments's" + assignments.size());

        RecyclerView rv = findViewById(R.id.recycler_view_2);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new ViewAssignmentsActivity.Adapter());

    }

    /**
     * The Adapter for the RecyclerView for ItemHolders, the constructor helps create the view
     * and the bind view binds the items to the holder
     */
    private class Adapter extends RecyclerView.Adapter<ItemHolder> {

        @Override
        public ViewAssignmentsActivity.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType){
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
}

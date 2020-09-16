package com.example.gradetracker_pj1;

import android.content.DialogInterface;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gradetracker_pj1.model.Assignment;
import com.example.gradetracker_pj1.model.GradeRoom;

import java.util.List;

public class EditAssignment extends AppCompatActivity {
List <Assignment> assignmentList;
public int asign =0;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        Log.d("LoginActivity", "onCreate called");
        super.onCreate(saveInstanceState);
        setContentView(R.layout.editassignment_activity);


        Button edit_assignment=  findViewById(R.id.enter_course_edit_button);
        edit_assignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** A try to get the assignment Id and parse the assignment Id into an integer */
                try {
                    EditText assign_id = findViewById(R.id.edit_assignment_id);
                     asign   = Integer.parseInt(assign_id.getText().toString());
                    assignmentList = GradeRoom.getGradeRoom(EditAssignment.this).dao().searchAssignment(asign);

                    /** If the assignment list is null the user is told the course can not be found */
                    if (assignmentList == null) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(EditAssignment.this);
                        builder.setTitle("No assignment found.");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //finish();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                    /** A catch to throw an expection if the user enters an invalid assignment id */
                }catch (Exception e){
                    AlertDialog.Builder builder = new AlertDialog.Builder(EditAssignment.this);
                    builder.setTitle("Enter a valid Assignment ID.");
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

        /**The Recycler view to see the user's current Assignments */
        assignmentList = GradeRoom.getGradeRoom(EditAssignment.this).dao().searchAssignment(asign);
        Log.d("ViewCourseActivity", "EditAssignments" + assignmentList.size());
        RecyclerView rv = findViewById(R.id.recycler_view_edit_assignment);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new Adapter());

        Button edit_assingment2 = findViewById(R.id.edit_assignment_button2);
        edit_assingment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**A try to allow users to edit assignment information, if the assignment list is null the user has to enter the assignment id, else
                 * the assignment will update with edited information
                 */
                try {
                    EditText detail = findViewById(R.id.edit_details);
                    EditText date = findViewById(R.id.edit_due_date);
                    String details = detail.getText().toString();
                    String due_date = date.getText().toString();

                    if (assignmentList == null) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(EditAssignment.this);
                        builder.setTitle("Confirm Assignment ID first.");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //finish();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    } else {
                        assignmentList.get(0).setDetails(details);
                        assignmentList.get(0).setDue_date(due_date);
                        GradeRoom.getGradeRoom(EditAssignment.this).dao().updateAssignment(assignmentList);

                        AlertDialog.Builder builder = new AlertDialog.Builder(EditAssignment.this);
                        builder.setTitle("Assignment has been edited!");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                    /** A catch used to throw an exception if the user has an invaild Assignment */
                }catch (Exception e){
                    AlertDialog.Builder builder = new AlertDialog.Builder(EditAssignment.this);
                    builder.setTitle("Must search for valid hw assignment first!");
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

/** If the user clicks the back button they will be lead back to main menu */
        Button back_button = findViewById(R.id.BackBtn_2);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

/**The Adapter for the RecyclerView for ItemHolders, the constructor helps create the view
 * and the bind view binds the items to the holder
 */
    private class Adapter extends RecyclerView.Adapter<ItemHolder> {

        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(EditAssignment.this);
            return new ItemHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ItemHolder holder, int position) {
            holder.bind(assignmentList.get(position));
        }

        @Override
        public int getItemCount() {
            return assignmentList.size();
        }

    }
    private class ItemHolder extends RecyclerView.ViewHolder {

        public ItemHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item, parent, false));
        }

        public void bind(Assignment f) {
            TextView item = itemView.findViewById(R.id.item_id);
            item.setText(f.toString());
        }
    }
}

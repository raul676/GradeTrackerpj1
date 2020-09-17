package com.example.gradetracker_pj1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gradetracker_pj1.model.Assignment;
import com.example.gradetracker_pj1.model.Course;
import com.example.gradetracker_pj1.model.GradeDao;
import com.example.gradetracker_pj1.model.GradeRoom;

import org.w3c.dom.Text;

import java.util.List;

public class DeleteAssignment extends AppCompatActivity {

    EditText deleteAssignmentId;
    Button deleteAssignmentBtn;
    Button backBtn;


    List<Assignment> assignments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("DeleteAssignments", "onCreate called");

        super.onCreate(savedInstanceState);

        setContentView(R.layout.delete_assignments);

        // deleteAssignmentId = findViewById(R.id.deleteAssignmentId);
        deleteAssignmentBtn = findViewById(R.id.submitBtn);
        backBtn = findViewById((R.id.backBtn));


        GradeRoom.getGradeRoom(DeleteAssignment.this).loadData(this);


        deleteAssignmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("DeleteAssignment", "Enter the Assignment id");

                deleteAssignmentId = findViewById(R.id.deleteAssignmentId);
                String assignment = deleteAssignmentId.getText().toString();
                int assignment_id = Integer.parseInt(assignment);

                try {
                    Integer.parseInt(assignment);
                } catch (NumberFormatException e) {
                    deleteAssignmentId.setError("wrong Input");
                }

                GradeDao dao = GradeRoom.getGradeRoom(DeleteAssignment.this).dao();
                assignments = GradeRoom.getGradeRoom(DeleteAssignment.this).dao().getAllAssignments();


                Assignment assignment1 = dao.searchAssignment2(assignment_id);

                if (assignment != null) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(DeleteAssignment.this);
                    builder.setTitle("This Assignment will be deleted ");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //deleting
                            GradeDao dao = GradeRoom.getGradeRoom(DeleteAssignment.this).dao();
                            dao.deleteAssignment(assignment1);
                            //dao.deleteAssignment(course1);
                            Log.d("DeleteAssignment", "deletingAssignment");
                            Intent intent = new Intent(DeleteAssignment.this, MainMenu.class);


                            startActivity(intent);
                        }

                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();


                }
            }


        });


    }
}
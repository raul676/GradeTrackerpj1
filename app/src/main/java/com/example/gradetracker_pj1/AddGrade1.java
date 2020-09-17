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

import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gradetracker_pj1.model.GradeRoom;
import com.example.gradetracker_pj1.model.User;

/** This add grade allows admin to view students who are enrolled within the 'school'*/
public class AddGrade1 extends  AppCompatActivity {

    List<User> users;
    public static int student_id_add;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        Log.d("LoginActivity", "onCreate called");
        super.onCreate(saveInstanceState);
        setContentView(R.layout.addgrade1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button select_user = findViewById(R.id.select_student);
        select_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /** A try to get the student ID and parse from a string to an int if the student id is null student can not be found
                 * else the next activity (add grade 2) starts
                 */
                try {
                    EditText user = findViewById(R.id.student_id);
                    int student_id = Integer.parseInt(user.getText().toString());
                    User user1 = GradeRoom.getGradeRoom(AddGrade1.this).dao().searchUser(student_id);
                    if (user1 == null) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(AddGrade1.this);
                        builder.setTitle("No user found.");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                /**Closes alert Dialog after okay clicked*/
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    } else {
                        AddGrade1.student_id_add = student_id;
                        Intent intent = new Intent(AddGrade1.this, AddGrade2.class);
                        startActivity(intent);
                    }
                }catch (Exception e){
                    AlertDialog.Builder builder = new AlertDialog.Builder(AddGrade1.this);
                    builder.setTitle("Enter a valid User ID.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            /**Closes alert Dialog after okay clicked*/
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });

        /**A recyler view to view students  */
        users = GradeRoom.getGradeRoom(this).dao().getAllUser();
        Log.d("ViewCourseActivity", "Courses's" + users.size());
        RecyclerView rv = findViewById(R.id.recycler_view_users);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new Adapter());
        Button back = findViewById(R.id.main_menu_add_grade);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * The Adapter for the RecyclerView for ItemHolders, the constructor helps create the view
     * and the bind view binds the items to the holder
     */
    private class Adapter extends RecyclerView.Adapter<ItemHolder> {

        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(AddGrade1.this);
            return new ItemHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ItemHolder holder, int position){
            holder.bind(users.get(position));
        }

        @Override
        public int getItemCount() { return users.size(); }
    }

    private class ItemHolder extends RecyclerView.ViewHolder {

        public ItemHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item, parent, false));
        }

        public void bind(User f ) {
            TextView item = itemView.findViewById(R.id.item_id);
            item.setText(f.toString());
        }
    }
}

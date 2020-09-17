package com.example.gradetracker_pj1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.gradetracker_pj1.model.GradeDao;
import com.example.gradetracker_pj1.model.GradeRoom;
import com.example.gradetracker_pj1.model.User;

public class CreateLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        Log.d("CreateLoginActivity", "onCreate called");
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_create_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button new_user = findViewById(R.id.confirm_new_use);
        new_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    EditText fname = findViewById(R.id.first_name_user);
                    EditText lname = findViewById(R.id.last_name_user);
                    EditText user = findViewById(R.id.username_edit);
                    EditText pass = findViewById(R.id.password_edit);

                    String first_name = fname.getText().toString();
                    String last_name = lname.getText().toString();
                    String username = user.getText().toString();
                    String password = pass.getText().toString();
                    String numbers = "1234567890";
                    String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    boolean is_true_char = false;
                    boolean is_true_num = false;

                    for (int i = 0; i < username.length(); i++) {
                        for (int j = 0; j < numbers.length(); j++) {
                            if (username.charAt(i) == numbers.charAt(j)) {
                                is_true_num = true;
                                j = numbers.length();
                                i = username.length();
                                break;
                            }
                        }
                    }
                    for (int i = 0; i < username.length(); i++) {
                        for (int j = 0; j < chars.length(); j++) {
                            if (username.charAt(i) == chars.charAt(j)) {
                                is_true_char = true;
                                j = numbers.length();
                                i = username.length();
                                break;
                            }
                        }
                    }
                    if (is_true_char && is_true_num) {
                        Random random = new Random();
                        int random_var = random.nextInt(99999);
                        User user1 = new User(random_var, username, password, first_name, last_name);
                        GradeDao dao = GradeRoom.getGradeRoom(CreateLoginActivity.this).dao();
                        dao.addUser(user1);
                        Toast.makeText(CreateLoginActivity.this, "User added, Welcome " + first_name, Toast.LENGTH_SHORT).show(); // non integer input

                    } else {
                        Toast.makeText(CreateLoginActivity.this, "Username doesn't contain char & numbers ", Toast.LENGTH_SHORT).show(); // non integer input

                    }

                }catch (Exception e){
                    Toast.makeText(CreateLoginActivity.this, "Enter valid input", Toast.LENGTH_SHORT).show(); // non integer input

                }
            }
        });


        Button back = findViewById(R.id.back_new_user);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

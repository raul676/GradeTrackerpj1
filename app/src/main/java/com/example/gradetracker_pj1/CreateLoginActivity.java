package com.example.gradetracker_pj1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CreateLoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        Log.d("CreateLoginActivity", "onCreate called");
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_view_course);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        /*

        If we have time I will implement this
         */
    }
}

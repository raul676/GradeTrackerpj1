package com.example.gradetracker_pj1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.gradetracker_pj1.model.GradeDao;
import com.example.gradetracker_pj1.model.GradeRoom;
import com.example.gradetracker_pj1.model.User;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.security.cert.CRLException;
public class MainActivity extends AppCompatActivity {

    /**Variables needed for usernames and passwords */
    public static String username= "";
    public static int userid=0;
    public static final String admin_user = "dr.sithlord";
    public static final String admin_password = "dr.sithlord";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        GradeRoom.getGradeRoom(MainActivity.this).loadData(this);

        Button login_button = findViewById(R.id.loginbutton_main);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText user = findViewById(R.id.username_main);
                EditText pass = findViewById(R.id.password_main);

                String username = user.getText().toString();
                String password = pass.getText().toString();
                boolean is_true = false;

                /** A Loop to check if the Admin is logging in or not, if log in is successful a welcome message appears containing the Admin's name*/
                if(username.equals(MainActivity.admin_user) && password.equals(MainActivity.admin_password))
                {
                    Intent intent = new Intent(MainActivity.this, AdminMenu.class);
                    startActivity(intent);
                    is_true= true;
                }

                GradeDao dao = GradeRoom.getGradeRoom(MainActivity.this).dao();
                User user1 = dao.loginUser(username, password);

                /** A loop to check if user is logging in,if log in is successful a welcome message appears containing the user's name*/
                if(user1 != null)
                {
                    MainActivity.username = user1.getFirst_name() + " " + user1.getLast_name();
                    MainActivity.userid = user1.getUserid();
                    Intent intent = new Intent(MainActivity.this, MainMenu.class);
                    startActivity(intent);
                }
                else if(!is_true){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("No user found.");
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

        Button create_login = findViewById(R.id.create_login_button_main);
        create_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateLoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

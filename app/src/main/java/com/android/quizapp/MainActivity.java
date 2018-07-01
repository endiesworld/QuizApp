package com.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PublicKey;


public class MainActivity extends AppCompatActivity {
     private Button login ;
     private EditText user_name ;
     private EditText pass ;
     private TextView text;
     String user ;
     int passWord ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign id values to xml variables created
        user_name = findViewById(R.id.userName);
        pass = findViewById(R.id.passWord);
        login =  findViewById(R.id.logIn);
        text = findViewById(R.id.introText);

        // To know when the LOGIN button is clicked
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityTwo();
            }
        });

    }

    //Collects the LOGIN details and convert them to string
    private void logInDetails(){
        user = user_name.getText().toString();
        passWord = Integer.parseInt( pass.getText().toString());
    }

    //Checks LOGIN details validity
    public void checkLogInDetails(){

        if (!user.isEmpty()  && passWord > 0)   {
            openQuestionOne() ;
        }
        else if (user.isEmpty() || user == null ) {
            Toast.makeText(MainActivity.this, "PLS ENSURE YOU ENTER THE RiGHT USERNAME", Toast.LENGTH_SHORT).show();
        }

        else if ( passWord <=0) {
            Toast.makeText(MainActivity.this, "PLS ENSURE YOU ENTER THE RiGHT PASSWORD", Toast.LENGTH_SHORT).show();
        }
    }

    //confirms log in details and logs the user in.
    public void openActivityTwo(){
        logInDetails();
        checkLogInDetails();
        }

    //Opens question one if Login criteria is met
    public void openQuestionOne(){
        Intent activityTwo = new Intent(this, Question_One.class);
        startActivity(activityTwo);




    }


}

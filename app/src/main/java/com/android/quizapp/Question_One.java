package com.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;


public class Question_One extends AppCompatActivity {
    private RadioButton one, two,three,four ;
    private Button submmit, next ;
    public static final String EXTRA_TEXT = "com.android.QuizApp.EXTRA_TEXT";
    int scoreCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question__one);

        one = findViewById(R.id.answerOne);
        two = findViewById(R.id.answerTwo);
        three = findViewById(R.id.answerThree);
        four = findViewById(R.id.answerFour);
        submmit = findViewById(R.id.submitOne);
        next =  findViewById(R.id.nextOne);

       // Listening to know when the user presses the submit button
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonNext();
                            }
        });

        // Listening to know when the user presses the submit button
        submmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // If the correct answer is chosen, increases user score by 1
                if (one.isChecked()){
                    scoreCounter += 1 ;
                }
                buttonSubmit ();
                }

        });

            }

 //calls the next question once the submit button is pressed
    private void buttonSubmit (){
        Intent nextActivity = new Intent(Question_One.this, Question_two.class);

       // Transfers the user's current score to the next intent(question)
        nextActivity.putExtra(EXTRA_TEXT,scoreCounter);
        startActivity(nextActivity);
    }
    //calls the next question once the next button is pressed button is pressed
    private void buttonNext (){
        Intent nextActivity = new Intent(Question_One.this, Question_two.class);
        nextActivity.putExtra(EXTRA_TEXT,scoreCounter);
        startActivity(nextActivity);
    }
}

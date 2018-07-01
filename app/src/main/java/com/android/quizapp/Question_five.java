package com.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question_five extends AppCompatActivity {

    private RadioButton one, two,three,four ;

    private Button submit, next ;
    public static final String EXTRA_TEXT = "com.android.QuizApp.EXTRA_TEXT";
    int scoreCounter = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_five);

        one = findViewById(R.id.answerOne5);
        two = findViewById(R.id.answerTwo5);
        three = findViewById(R.id.answerThree5);
        four = findViewById(R.id.answerFour5);
        submit = findViewById(R.id.submitFive);
        next =  findViewById(R.id.nextFive);

        Intent getPreviousScore = getIntent();
        scoreCounter = getPreviousScore.getIntExtra(Question_two.score, 0);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonNext();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (one.isChecked()){
                    scoreCounter += 1;
                }
                buttonSubmit ();
            }

        });

    }


    public void buttonSubmit (){
        Intent activityThree = new Intent(this, question_six.class);
        activityThree.putExtra(EXTRA_TEXT,scoreCounter);
        startActivity(activityThree);

    }
    private void buttonNext (){
        Intent activityThree = new Intent(this, question_six.class);
        activityThree.putExtra(EXTRA_TEXT,scoreCounter);
        startActivity(activityThree);
    }
}

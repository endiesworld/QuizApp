package com.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question_three extends AppCompatActivity {

    private RadioButton one, two,three,four ;

    private Button submit, next ;
    public static final String score = "com.android.QuizApp.EXTRA_TEXT";
    int scoreCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_three);

        one = findViewById(R.id.answerOne3);
        two = findViewById(R.id.answerTwo3);
        three = findViewById(R.id.answerThree3);
        four = findViewById(R.id.answerFour3);
        submit = findViewById(R.id.submitThree);
        next =  findViewById(R.id.nextThree);

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
                    scoreCounter += 1 ;
                }
                buttonSubmit ();
            }

        });

    }


    public void buttonSubmit (){
        Intent activityThree = new Intent(this, Question_four.class);
        activityThree.putExtra(score,scoreCounter);
        startActivity(activityThree);

    }
    private void buttonNext (){
        Intent activityThree = new Intent(this, Question_four.class);
        activityThree.putExtra(score,scoreCounter);
        startActivity(activityThree);
    }
}

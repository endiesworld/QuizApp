package com.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question_two extends AppCompatActivity {

    private RadioButton one, two,three,four ;

    private Button submit, next ;
    public static final String score = "com.android.QuizApp.EXTRA_TEXT";
    int scoreCounter = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_two);

        one = findViewById(R.id.answerOne2);
        two = findViewById(R.id.answerTwo2);
        three = findViewById(R.id.answerThree2);
        four = findViewById(R.id.answerFour2);
        submit = findViewById(R.id.submitTwo2);
        next =  findViewById(R.id.nextTwo2);

        // Intent to receive the previous score
        Intent getPreviousScore = getIntent();
        scoreCounter = getPreviousScore.getIntExtra(Question_One.EXTRA_TEXT, 0);

        // Listening to know when the user presses the next button
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonNext();
            }
        });

        // Listening to know when the user presses the submit button
        submit.setOnClickListener(new View.OnClickListener() {
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

    //calls the next question once the submit button is pressed button is pressed
    private void buttonSubmit (){
        Intent activityThree = new Intent(this, Question_three.class);
        // Transfers the user's current score to the next intent(question)
        activityThree.putExtra(score,scoreCounter);
        startActivity(activityThree);

    }
    //calls the next question once the next button is pressed button is pressed
    private void buttonNext (){
        Intent activityThree = new Intent(this, Question_three.class);
        activityThree.putExtra(score,scoreCounter);
        startActivity(activityThree);
    }
}

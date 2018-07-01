package com.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class question_six extends AppCompatActivity {

    private TextView totalScore ;

    private Button submit, next ;
    int scoreCounter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_six);


        totalScore = findViewById(R.id.finalScore);
        submit = findViewById(R.id.submitSix);
        next =  findViewById(R.id.nextSix);

        Intent getPreviousScore = getIntent();
        scoreCounter = getPreviousScore.getIntExtra(Question_two.score, 0);


        totalScore.setText("YOUR TOTAL SCORE IS  " + scoreCounter);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonNext();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buttonSubmit ();
            }

        });

    }


    public void buttonSubmit (){
        finish();
        Intent activityThree = new Intent(this, Question_One.class);
        startActivity(activityThree);

    }
    private void buttonNext (){
        Intent activityThree = new Intent(this, MainActivity.class);
        startActivity(activityThree);
    }
}

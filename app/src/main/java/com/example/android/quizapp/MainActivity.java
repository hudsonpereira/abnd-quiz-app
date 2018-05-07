package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void finish(View view) {
        if (! checkPresenceOfAllAnswers()) {
            Toast.makeText(this, "You have to answer all questions.", Toast.LENGTH_SHORT).show();

            return;
        }

        int rightAnswers = getRightAnswers();

        if (rightAnswers == 5) {
            Toast.makeText(this, "Amazing shape! You are the best! (5/5)", Toast.LENGTH_SHORT).show();
        } else if (rightAnswers == 0){
            Toast.makeText(this, "Shame on you! (0/5)", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You did it (" + rightAnswers + "/5)", Toast.LENGTH_SHORT).show();
        }

    }

    private int getRightAnswers() {
        int rightAnswers = 0;
        EditText answerOneEditText = findViewById(R.id.answer_question_1);
        EditText answerFourEditText = findViewById(R.id.answer_question_4);


        // First Question
        if (answerOneEditText.getText().toString().equals("690")) {
            rightAnswers++;
        }

        // Second Question
        if (isChecked(R.id.java_checkbox) && isChecked(R.id.kotlin_checkbox) && !isChecked(R.id.go_checkbox) && !isChecked(R.id.php_checkbox)) {
            rightAnswers++;
        }

        // Third Question
        if (((RadioButton) findViewById(R.id.as_radio)).isChecked()) {
            rightAnswers++;
        }

        // Fourth Question
        if (answerFourEditText.getText().toString().equals("int score;")) {
            rightAnswers++;
        }

        // Fifth Question
        if (!isChecked(R.id.assign_1) && isChecked(R.id.assign_2) && isChecked(R.id.assign_3) && isChecked(R.id.assign_4)) {
            rightAnswers++;
        }


        return rightAnswers;
    }

    public boolean checkPresenceOfAllAnswers() {
        return true;
    }

    private boolean isChecked(int res) {
        return ((CheckBox) findViewById(res)).isChecked();
    }
}

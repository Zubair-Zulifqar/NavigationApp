package com.example.navigationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Test extends AppCompatActivity {

    private TextView letterTextView, answerTextView;
    DbHelper db;
    EditText name;
    private char[] skyLetters = {'b', 'd', 'f', 'h', 'k', 'l', 't'};
    private char[] grassLetters = {'g', 'j', 'p', 'q', 'y'};
    private char[] rootLetters = {'a', 'c', 'e', 'i', 'm', 'n', 'o', 'r', 's', 'u', 'v', 'w', 'x', 'z'};
    private String answerString = "";
    int correct = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        name = findViewById(R.id.name);
        db = new DbHelper(this);
        letterTextView = findViewById(R.id.letter_text_view);
        letterTextView.setText(getRandomLetter());

        answerTextView = findViewById(R.id.answer_text_view);

        Button skyButton = findViewById(R.id.sky_button);
        skyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerString.equals("Sky Letter")) {
                    answerTextView.setText("Awesome your answer is right");
                    correct++;
                } else {
                    answerTextView.setText("Incorrect! the answer is " + answerString);
                }

                // Wait for 5 seconds and create a new question
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        letterTextView.setText(getRandomLetter());
                        answerTextView.setText("");
                    }
                }, 5000); // 5000 milliseconds = 5 seconds
            }
        });

        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.insertStudent(name.getText().toString(), correct);
            }
        });

        Button grassButton = findViewById(R.id.grass_button);
        grassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerString.equals("Grass Letter")) {
                    answerTextView.setText("Awesome your answer is right");
                    correct++;
                } else {
                    answerTextView.setText("Incorrect! the answer is " + answerString);
                }
                // Wait for 5 seconds and create a new question
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        letterTextView.setText(getRandomLetter());
                        answerTextView.setText("");
                    }
                }, 5000); // 5000 milliseconds = 5 seconds
            }
        });

        Button rootButton = findViewById(R.id.root_button);
        rootButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerString.equals("Root Letter")) {
                    answerTextView.setText("Awesome your answer is right");
                    correct++;
                } else {
                    answerTextView.setText("Incorrect! the answer is " + answerString);
                }
                // Wait for 5 seconds and create a new question
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        letterTextView.setText(getRandomLetter());
                        answerTextView.setText("");
                    }
                }, 5000); // 5000 milliseconds = 5 seconds
            }
        });
    }

    private String getRandomLetter() {
        Random random = new Random();
        int category = random.nextInt(3);
        char letter;
        switch (category) {
            case 0:
                letter = skyLetters[random.nextInt(skyLetters.length)];
                answerString = "Sky Letter";
                break;
            case 1:
                letter = grassLetters[random.nextInt(grassLetters.length)];
                answerString = "Grass Letter";
                break;
            default:
                letter = rootLetters[random.nextInt(rootLetters.length)];
                answerString = "Root Letter";
                break;
        }
        return String.valueOf(letter);
    }
}

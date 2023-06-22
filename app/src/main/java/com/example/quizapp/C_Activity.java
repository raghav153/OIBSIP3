package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class C_Activity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup optionRadioGroup;
    private RadioButton option1RadioButton, option2RadioButton, option3RadioButton, option4RadioButton;
    private Button nextButton;

    private String[] questions = {
            "Question 1: Which of the following is NOT a valid C variable type?",
            "Question 2: What does the \"sizeof\" operator return in C?",
            "Question 3: Which of the following is used to terminate a switch statement in C?",
            "Question 4: Which of the following is NOT a valid logical operator in C?",
            "Question 5: Which keyword is used to define a constant in C?"
    };

    private String[][] options = {
            {"int", "float", "String", "char"},
            {"The size of the data type in bytes", "The address of the variable", " The value of the variable", "The data type of the variable"},
            {"break", "continue", "return", "exit"},
            {"&&", "||", "!", "< >"},
            {"define", "const", "constant", "def"}
    };

    private int[] correctAnswers = {2, 0, 0, 3, 1}; // Indices of correct options

    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cactivity);

        questionTextView = findViewById(R.id.questionTextView);
        optionRadioGroup = findViewById(R.id.optionRadioGroup);
        option1RadioButton = findViewById(R.id.option1RadioButton);
        option2RadioButton = findViewById(R.id.option2RadioButton);
        option3RadioButton = findViewById(R.id.option3RadioButton);
        option4RadioButton = findViewById(R.id.option4RadioButton);
        nextButton = findViewById(R.id.nextButton);

        displayQuestion(currentQuestionIndex);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (optionRadioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(C_Activity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
                else {
                    int selectedOption = optionRadioGroup.indexOfChild(findViewById(optionRadioGroup.getCheckedRadioButtonId()));
                    checkAnswer(selectedOption);
                    clearSelection();
                    currentQuestionIndex++;

                    if (currentQuestionIndex < questions.length) {
                        displayQuestion(currentQuestionIndex);
                    } else {
                        showResult();
                        Toast.makeText(C_Activity.this, "Restart the app for play again", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    private void displayQuestion(int index) {
        questionTextView.setText(questions[index]);
        option1RadioButton.setText(options[index][0]);
        option2RadioButton.setText(options[index][1]);
        option3RadioButton.setText(options[index][2]);
        option4RadioButton.setText(options[index][3]);
    }

    private void checkAnswer(int selectedOption) {
        if (selectedOption == correctAnswers[currentQuestionIndex]) {
            score++;
        }
    }

    private void clearSelection() {
        optionRadioGroup.clearCheck();
    }

    private void showResult() {
        String resultMessage = "Quiz completed. Your score is " + score + " out of " + questions.length;
        Toast.makeText(this, resultMessage, Toast.LENGTH_LONG).show();
        nextButton.setEnabled(false);
    }
}


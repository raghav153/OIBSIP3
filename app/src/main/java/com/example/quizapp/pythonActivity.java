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

public class pythonActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup optionRadioGroup;
    private RadioButton option1RadioButton, option2RadioButton, option3RadioButton, option4RadioButton;
    private Button nextButton;

    private final String[] questions = {
            "Question 1: What is the file extension for Python source code files?",
            "Question 2: Which of the following is a Python framework for web development?",
            "Question 3: What is the process of combining different data types called in Python?",
            "Question 4: Which keyword is used to define a function in Python?",
            "Question 5: Which Python library is used for data manipulation and analysis?"
    };

    private final String[][] options = {
            {".py", ".px", ".txt", ".pyth"},
            {"Django", "Java", "Ruby", "C#"},
            {"Typecasting", "converting", "concatenation", "merging"},
            {"func", "def", "function", "define"},
            {"NumPy", "PyGame", "Tkinter", "SciPy"}
    };

    private final int[] correctAnswers = {0, 0, 0, 1, 0}; // Indices of correct options

    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python);

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
                    Toast.makeText(pythonActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(pythonActivity.this, "Restart the app for play again", Toast.LENGTH_SHORT).show();
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
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

public class CppActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup optionRadioGroup;
    private RadioButton option1RadioButton, option2RadioButton, option3RadioButton, option4RadioButton;
    private Button nextButton;

    private final String[] questions = {
            "Question 1: Which of the following is NOT a fundamental data type in C++?",
            "Question 2: Which keyword is used to inherit a base class in C++?",
            "Question 3: Which operator is used for dynamic memory deallocation in C++?",
            "Question 4: What is the purpose of the \"new\" operator in C++?",
            "Question 5: What is the purpose of the \"virtual\" keyword in C++?"
    };

    private final String[][] options = {
            {"int", "float", "char", "string"},
            {"inherit", "extends", "derive", "public"},
            {"new", "delete", "free", "malloc"},
            {"It creates a new instance of a class.", "It dynamically allocates memory.", "It initializes an object.", "It overloads an operator."},
            {"It declares a pure virtual function.", "It prevents a class from being inherited.", "It enables runtime polymorphism.", "It declares a static member variable."}
    };

    private final int[] correctAnswers = {3, 3, 1, 1, 2}; // Indices of correct options

    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpp);

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
                    Toast.makeText(CppActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(CppActivity.this, "Restart the app for play again", Toast.LENGTH_SHORT).show();
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
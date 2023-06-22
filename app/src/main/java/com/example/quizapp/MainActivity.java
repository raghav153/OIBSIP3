package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1, imageView2, imageView3, imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                openActivity1(v1);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                openActivity2(v2);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                openActivity3(v3);
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v4) {
                openActivity4(v4);
            }
        });

    }

    public void openActivity1(View v1){
        Intent intent = new Intent(this,C_Activity.class);
        startActivity(intent);
    }

    public void openActivity2(View v2){
        Intent intent = new Intent(this,CppActivity.class);
        startActivity(intent);
    }
    public void openActivity3(View v3){
        Intent intent = new Intent(this,javaActivity.class);
        startActivity(intent);
    }
    public void openActivity4(View v4){
        Intent intent = new Intent(this,pythonActivity.class);
        startActivity(intent);
    }

}
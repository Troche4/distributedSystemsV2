package com.example.distributedsystemsphase2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HostQuiz extends AppCompatActivity {

    private Button loadButton;
    private Button makeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_quiz);

        loadButton = (Button) findViewById(R.id.loadButton);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoadActivity();
            }
        });
        makeButton = (Button) findViewById(R.id.makeButton);
        makeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMakeActivity();
            }
        });
    }

    public void openLoadActivity() {
        Intent intent = new Intent(this, LoadQuiz.class);
        startActivity(intent);
    }

    public void openMakeActivity() {
        Intent intent = new Intent(this, MakeQuiz.class);
        startActivity(intent);
    }
}

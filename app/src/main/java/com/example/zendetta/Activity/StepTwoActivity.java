package com.example.zendetta.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zendetta.R;

public class StepTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_two);

        Button btnNext = findViewById(R.id.btnNextTwo);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StepTwoActivity.this, StepThreeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
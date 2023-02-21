package com.example.zendetta.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zendetta.R;
import com.example.zendetta.SideBarActivity;

public class StepFourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_four);

        Button btnNext = findViewById(R.id.btnConfirm);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StepFourActivity.this, SideBarActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
package com.example.covid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Options extends AppCompatActivity {
    private Button medical, mental_health, plasma;
    private String phoneNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        phoneNo = getIntent().getStringExtra("PhoneNo");
        medical = (Button) findViewById(R.id.BUTTON_MEDICAL_FACILITY);
        mental_health = (Button) findViewById(R.id.BUTTON_MENTAL_HEALTH);
        plasma = (Button) findViewById(R.id.BUTTON_PLASMA);

        plasma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent plasma = new Intent(Options.this, PlasmaActivity.class);
                plasma.putExtra("PhoneNo", phoneNo);
                finish();
                startActivity(plasma);
            }
        });
    }
}
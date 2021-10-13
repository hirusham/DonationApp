package com.sam.donationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class RegistrationReceiver extends AppCompatActivity {

    TextView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_receiver);

        next = findViewById(R.id.button6);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationReceiver.this,RegistrationReceiverNext.class);
                startActivity(intent);
            }
        });

    }
}
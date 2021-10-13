package com.sam.donationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegistrationDonor extends AppCompatActivity {

    Button signUp;
    TextView recceiverActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_donor);

        signUp = findViewById(R.id.button4);
        recceiverActivity = findViewById(R.id.textView6);

        recceiverActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationDonor.this,RegistrationReceiver.class);
                startActivity(intent);
            }
        });


    }
}
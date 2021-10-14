package com.sam.donationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class RegistrationReceiver extends AppCompatActivity {

    Button next;
    TextView recceiverActivity,firstNameTxt,lastNameTxt,emailTxt,mobileNumberTxt;
    EditText firstName,lastName,email,mobileNumber;
    boolean firstNameBoolean,lastNameBoolean,emailBoolean,mobileNumberBoolean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_receiver);

        next = findViewById(R.id.button6);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!firstName.getEditableText().toString().equals("")&&!lastName.getEditableText().toString().equals("")&&!mobileNumber.getEditableText().toString().equals("")) {
                    if (firstNameBoolean && lastNameBoolean && emailBoolean && mobileNumberBoolean) {
                        Intent intent = new Intent(RegistrationReceiver.this,RegistrationReceiverNext.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(RegistrationReceiver.this, "Please fill all the fields with proper details!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegistrationReceiver.this, "Please fill all the fields!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        firstName = findViewById(R.id.editTextTextPersonName4);
        lastName = findViewById(R.id.editTextTextPersonName);
        email = findViewById(R.id.editTextTextPersonName2);
        mobileNumber = findViewById(R.id.editTextTextPersonName3);

        firstNameTxt = findViewById(R.id.nameTxt3);
        lastNameTxt = findViewById(R.id.nameTxt);
        emailTxt = findViewById(R.id.emailTxt);
        mobileNumberTxt = findViewById(R.id.mobileTxt);

        firstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String val = firstName.getEditableText().toString();
                if (val.isEmpty()) {
                    firstNameTxt.setText("Field cannot be empty");
                } else if (val.length() >= 15) {
                    firstNameTxt.setText("Username too long");
                } else if (val.matches("^[a-zA-Z\\s]*$")) {
                    firstNameTxt.setText(null);
                    firstNameBoolean = true;
                } else {
                    firstNameTxt.setText("Please enter proper name");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        lastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String val = lastName.getEditableText().toString();
                if (val.isEmpty()) {
                    lastNameTxt.setText("Field cannot be empty");
                } else if (val.length() >= 15) {
                    lastNameTxt.setText("Username too long");
                } else if (val.matches("^[a-zA-Z\\s]*$")) {
                    lastNameTxt.setText(null);
                    lastNameBoolean = true;
                } else {
                    lastNameTxt.setText("Please enter proper name");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString().toLowerCase()).matches()) {
                    emailTxt.setText("");
                    emailTxt.setText("Enter valid email please");
                    email.requestFocus();

                } else {
                    emailTxt.setText("");
                    emailBoolean = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mobileNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String val = mobileNumber.getEditableText().toString();
                String passwordVal = "^" +
                        "mobileNumber" +         //at least 1 digit
                        ".{10,}" +               //at least 4 characters
                        "$";


                if (val.isEmpty()) {
                    mobileNumberTxt.setText("Field cannot be empty");

                } else if (!val.matches(passwordVal)) {
                    mobileNumberTxt.setText("Please enter proper mobile number");
                } else {
                    mobileNumberTxt.setText(null);
                    mobileNumberBoolean = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
package com.sam.donationapp;

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

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class RegistrationDonor extends AppCompatActivity {

    Button signUp;
    TextView recceiverActivity,firstNameTxt,lastNameTxt,emailTxt,mobileNumberTxt,passwordTxt,rePasswordTxt;
    EditText firstName,lastName,email,mobileNumber,password,rePassword;
    boolean firstNameBoolean,lastNameBoolean,emailBoolean,mobileNumberBoolean,passwordBoolean,rePasswordBoolean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_donor);


        signUp = findViewById(R.id.button4);

        //EditTexts
        firstName = findViewById(R.id.editTextTextPersonName4);
        lastName = findViewById(R.id.editTextTextPersonName);
        email = findViewById(R.id.editTextTextPersonName2);
        mobileNumber = findViewById(R.id.editTextTextPersonName3);
        password = findViewById(R.id.editTextTextPassword);
        rePassword = findViewById(R.id.editTextTextPassword2);

        //Error displaying text views
        firstNameTxt = findViewById(R.id.nameTxt3);
        lastNameTxt = findViewById(R.id.nameTxt);
        emailTxt = findViewById(R.id.emailTxt);
        mobileNumberTxt = findViewById(R.id.mobileTxt);
        passwordTxt = findViewById(R.id.passwordTxt);
        rePasswordTxt = findViewById(R.id.repasswordTxt);

        recceiverActivity = findViewById(R.id.textView6);

        recceiverActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationDonor.this,RegistrationReceiver.class);
                startActivity(intent);
            }
        });

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

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String val = password.getEditableText().toString();
                String passwordVal = "^" +
                        "(?=.*[0-9])" +         //at least 1 digit
                        "(?=.*[a-z])" +         //at least 1 lower case letter
                        "(?=.*[A-Z])" +         //at least 1 upper case letter
                        "(?=.*[a-zA-Z])" +      //any letter
                        "(?=.*[@#$%^&+=])" +    //at least 1 special character
                        ".{4,}" +               //at least 4 characters
                        "$";

                if (val.isEmpty()) {
                    passwordTxt.setText("Field cannot be empty");

                } else if (!val.matches(passwordVal)) {
                    passwordTxt.setText("Password is too weak");
                } else {
                    passwordTxt.setText(null);
                    passwordBoolean = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        rePassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String val = rePassword.getEditableText().toString();
                String passwordVal = "^" +
                        "(?=.*[0-9])" +         //at least 1 digit
                        "(?=.*[a-z])" +         //at least 1 lower case letter
                        "(?=.*[A-Z])" +         //at least 1 upper case letter
                        "(?=.*[a-zA-Z])" +      //any letter
                        "(?=.*[@#$%^&+=])" +    //at least 1 special character
                        ".{6,}" +               //at least 4 characters
                        "$";

                if (val.isEmpty()) {
                    rePasswordTxt.setText("Password cannot be empty");
                } else if (!rePassword.getEditableText().toString().equals(password.getEditableText().toString())) {
                    rePasswordTxt.setText("Password doesn't match with this password");
                } else {
                    rePasswordTxt.setText(null);
                    rePasswordBoolean = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!firstName.getEditableText().toString().equals("")&&!lastName.getEditableText().toString().equals("")&&!password.getEditableText().toString().equals("")&&!mobileNumber.getEditableText().toString().equals("")&&!password.getEditableText().toString().equals("")&&!rePassword.getEditableText().toString().equals("")) {
                    if (firstNameBoolean && lastNameBoolean && emailBoolean && mobileNumberBoolean && passwordBoolean && rePasswordBoolean) {



                    } else {
                        Toast.makeText(RegistrationDonor.this, "Please fill all the fields with proper details!", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(RegistrationDonor.this, "Please fill all the fields!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
package com.example.do_an_nhom9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class UserProfile extends AppCompatActivity {

    TextInputLayout fullNameLayout, emailLayout, phoneNumberLayout, passwordLayout;
    TextInputEditText fullName, email, phoneNumber, password;
    TextView fullNameLabel, usernameLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

    fullName = findViewById(R.id.full_name_profile);
    email = findViewById(R.id.email_profile);
    phoneNumber = findViewById(R.id.phone_number_profile);
    password = findViewById(R.id.password_profile);
    fullNameLabel = findViewById(R.id.full_name_field);
    usernameLabel = findViewById(R.id.user_name_field);

    showAllUserData();



    }

    public void showAllUserData() {
        Intent intent = getIntent();
        String user_username = intent.getStringExtra("username");
        String user_name = intent.getStringExtra("name");
        String user_email = intent.getStringExtra("email");
        String user_phoneNumber = intent.getStringExtra("phoneNumber");
        String user_password= intent.getStringExtra("password");

        fullNameLabel.setText(user_name);
        usernameLabel.setText(user_username);
        fullName.setText(user_name);
        email.setText(user_email);
        phoneNumber.setText(user_phoneNumber);
        password.setText(user_password);
    }

}
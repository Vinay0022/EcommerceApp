package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
//    UI views
private EditText emailET,passwordET;
private TextView forgotTv,noAccountTv;
private Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailET = findViewById(R.id.emailET);
        passwordET= findViewById(R.id.passwordET);
        forgotTv= findViewById(R.id.forgotTv);
        noAccountTv= findViewById(R.id.noAccountTv);
        loginBtn= findViewById(R.id.loginBtn);

        noAccountTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           startActivity(new Intent(LoginActivity.this,RegisterUserActivity.class));
            }
        });

forgotTv.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
            startActivity(new Intent(LoginActivity.this,ForgotPasswordActivity.class));
    }
});


    }
}
package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseUser mUser;
//    UI views
//private
EditText emailET,passwordET;
//private
TextView forgotTv,noAccountTv;
//private
Button loginBtn,SignUpBtn;
String emailPattern = "[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+";
ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

      emailET = findViewById(R.id.emailET);
        passwordET= findViewById(R.id.passwordET);
//        forgotTv= findViewById(R.id.forgotTv);
//        noAccountTv= findViewById(R.id.noAccountTv);
        loginBtn= findViewById(R.id.loginBtn);
        SignUpBtn = findViewById(R.id.SignUpBtn);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        SignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(),RegisterUserActivity.class);
                startActivity(in);
            }
        });
loginBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
       perforLogin();
    }
                                private void perforLogin() {
                                    String email = emailET.getText().toString();
                                    String password = passwordET.getText().toString();
                                    if (!email.matches(emailPattern)){
                                        emailET.setError("Enter Correct Email");
                                    }
                                    else if (password.isEmpty()|| password.length()<6){
                                        passwordET.setError("Enter Proper Password");
                                    }
                                    else{
                                        progressDialog.setMessage("Please Wait While Login");
                                        progressDialog.setTitle("Login");
                                        progressDialog.setCanceledOnTouchOutside(false);
                                        progressDialog.show();

                                        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                            @Override
                                            public void onComplete(@NonNull Task<AuthResult> task) {
                                                if (task.isSuccessful()){
                                                    progressDialog.dismiss();
                                                    sendUserToNextActivity();
                                                    Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                                                }else{
                                                    progressDialog.dismiss();
                                                    Toast.makeText(LoginActivity.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                                    }
                                }
                                private void sendUserToNextActivity(){
                                    Intent intent = new Intent(LoginActivity.this,SplashActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                }
                            });

//        noAccountTv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//           startActivity(new Intent(LoginActivity.this,RegisterUserActivity.class));
//            }
//        });

//forgotTv.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//            startActivity(new Intent(LoginActivity.this,ForgotPasswordActivity.class));
//    }
//});


    }}



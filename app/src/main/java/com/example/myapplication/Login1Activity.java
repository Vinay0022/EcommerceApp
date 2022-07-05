package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
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

public class Login1Activity extends AppCompatActivity {
Button signUp1Btn,login;
FirebaseAuth mAuth;
FirebaseUser mUser;
    EditText mName,mEmail,mPass;
    ProgressDialog progressDialog1;
    String emailPattern = "[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        signUp1Btn = findViewById(R.id.signUp1Btn);
        mName = findViewById(R.id.name1et);
        mEmail = findViewById(R.id.username_input);
        mPass = findViewById(R.id.pass);
        login = findViewById(R.id.logintv);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        progressDialog1 = new ProgressDialog(this);

        signUp1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(),Register1Activity.class);
                startActivity(in);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perforeLogin();}
            private void perforeLogin() {
                String email = mEmail.getText().toString();
                String password = mPass.getText().toString();
                if (!email.matches(emailPattern)){
                    mEmail.setError("Enter Correct Email");
                }
                else if (password.isEmpty()|| password.length()<6){
                    mPass.setError("Enter Proper Password");
                }
                else{
                    progressDialog1.setMessage("Please Wait While Login");
                    progressDialog1.setTitle("Login");
                    progressDialog1.setCanceledOnTouchOutside(false);
                    progressDialog1.show();

                    mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                progressDialog1.dismiss();
                                sendUserToNextActivity();
                                Toast.makeText(Login1Activity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                            }else{
                                progressDialog1.dismiss();
                                Toast.makeText(Login1Activity.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
            private void sendUserToNextActivity(){
                Intent intent = new Intent(Login1Activity.this,HomePageActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        signUp1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(),Register1Activity.class);
                startActivity(in);
            }
        });
    }
}
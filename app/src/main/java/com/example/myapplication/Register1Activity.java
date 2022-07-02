package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register1Activity extends AppCompatActivity {
EditText mName,mEmail,mPass,mCpass;
TextView signup;
ProgressDialog progressDialog1;
FirebaseAuth mAuth;
    String emailPattern = "[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        mName = findViewById(R.id.name1et);
        mEmail = findViewById(R.id.email1et);
        mPass = findViewById(R.id.pass1et);
        mCpass = findViewById(R.id.cpass1et);
        signup = findViewById(R.id.signup1tv);
        mAuth = FirebaseAuth.getInstance();
        progressDialog1 = new ProgressDialog(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String pass = mPass.getText().toString().trim();
                if (!email.matches(emailPattern)) {
                    mEmail.setError("Enter Correct Email");
                } else if (pass.isEmpty() || pass.length() < 6) {
                    mPass.setError("Enter Proper Password");
                } else {
                    progressDialog1.setMessage("Please Wait ");
                    progressDialog1.setTitle("UserAccount");
                    progressDialog1.setCanceledOnTouchOutside(false);
                    progressDialog1.show();

                    mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                progressDialog1.dismiss();
                                sendUserToNextActivity();
                                Toast.makeText(Register1Activity.this, "User created", Toast.LENGTH_SHORT).show();
                            } else {
                                progressDialog1.dismiss();
                                Toast.makeText(Register1Activity.this, "" + task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }

            private void sendUserToNextActivity() {
                Intent intent = new Intent(Register1Activity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

    });
}}

//               if (TextUtils.isEmpty(email)){
//                  mEmail.setError("Email is required");
//                  return;
//               }
//               if (TextUtils.isEmpty(pass)){
//                   mPass.setError("Password is required");
//               }
//               if (pass.length()<6){
//                   mPass.setError("Password must be of 6 characters");
//               }
////               create a user account
//              mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                  @Override
//                  public void onComplete(@NonNull Task<AuthResult> task) {
//                  if (task.isSuccessful()){
//                      Toast.makeText(Register1Activity.this, "User Created", Toast.LENGTH_SHORT).show();
//                      startActivity(new Intent(getApplicationContext(),RegisterUserActivity.class));
//                  }
//                  else{
//                      Toast.makeText(Register1Activity.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                  }
//                  }
//              });
//           }
//       });


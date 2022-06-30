package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class RegisterUserActivity extends AppCompatActivity {
    private ImageButton backBtn,gpsBtn;
    private ImageButton profileIv;
    private EditText nameET,phoneET,passwordET,cPasswordET,countryET,stateET,cityET,addressET,emailET;
    private Button registerBtn;
    private TextView registerSellerTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        // init ui views
        backBtn = findViewById(R.id.backBtn);
        gpsBtn= findViewById(R.id.gpsBtn);
        profileIv =findViewById(R.id.profileIv);
        nameET= findViewById(R.id.nameET);
        phoneET= findViewById(R.id.phoneET);
        countryET= findViewById(R.id.countryET);
        stateET= findViewById(R.id.stateET);
        cityET =findViewById(R.id.cityET);
        addressET=findViewById(R.id.addressET);
        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordET);
        cPasswordET = findViewById(R.id.cPasswordET);
        registerBtn= findViewById(R.id.recoverBtn);
        registerSellerTv= findViewById(R.id.registerSellerTv);

backBtn.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v){

    }
});
gpsBtn.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v){
        // detect current location
         }
        });
profileIv.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

    }
});
 registerBtn.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
//         register User
     }
 });
}
    }
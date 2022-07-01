package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;
import java.util.Locale;

public class RegisterUserActivity extends AppCompatActivity  {
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private ImageButton backBtn, gpsBtn;
    private ImageButton profileIv;
    private EditText nameET, phoneET, passwordET, cPasswordET, countryET, stateET, cityET, addressET, emailET;
    private Button registerBtn;
    private TextView registerSellerTv;

//    private static final int LOCATION_REQUEST_CODE = 100;
//    // permission constants
//    private static final int CAMERA_REQUEST_CODE = 200;
//    private static final int STORAGE_REQUEST_CODE = 200;
//    private static final int IMAGE_PICK_GALLARY_CODE = 400;
//    private static final int IMAGE_PICK_CAMERA_CODE= 400;
//    // permission arrays
//    private String[] locationPermissions;
//    private String[] cameraPermissions;
//    private String[] storagePermissions;
//    // image picked uri
//    private Uri image_url;
//    private String[] locationPermission;
//    private String[] cameraPermission;
//    private LocationManager locationManager;
//
//    private double latitude, longitude;
//    private Location location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);


//        // init ui views
//        backBtn = findViewById(R.id.backBtn);
//        gpsBtn = findViewById(R.id.gpsBtn);
//        profileIv = findViewById(R.id.profileIv);
//        nameET = findViewById(R.id.nameET);
//        phoneET = findViewById(R.id.phoneET);
//        countryET = findViewById(R.id.countryET);
//        stateET = findViewById(R.id.stateET);
//        cityET = findViewById(R.id.cityET);
//        addressET = findViewById(R.id.addressET);
//        emailET = findViewById(R.id.emailET);
//        passwordET = findViewById(R.id.passwordET);
//        cPasswordET = findViewById(R.id.cPasswordET);
//        registerBtn = findViewById(R.id.recoverBtn);
//        registerSellerTv = findViewById(R.id.registerSellerTv);
//
//        // init permissions array
//
//        locationPermissions = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
//        cameraPermissions = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
//        storagePermissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
//
//        firebaseAuth = FirebaseAuth.getInstance();
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setTitle("Please Wait");
//        progressDialog.setCanceledOnTouchOutside(false);

//        backBtn.setOnClickListener(view ->{onBackPressed();} );
//        gpsBtn.setOnClickListener(view -> {
//            if (checkLocationPermission()
//            detectLocation();
//
//        });
//        profileIv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//        registerBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////         register User
//            }
//        });
//    }
//    private boolean checkLocationPermission(){
//        boolean result = ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)==(PackageManager.PERMISSION_GRANTED):
//        return result;
//    }
//    private void requestLocationPermission(){
//        ActivityCompat.requestPermissions(this,locationPermissions,LOCATION_REQUEST_CODE);
//    }
//    @Override
//    public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions,@NonNull int[] grantResults){
//        switch (requestCode){
//            case LOCATION_REQUEST_CODE:{
//                if (grantResults.length>0){
//                    boolean locationAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
//                    if (locationAccepted){
//                        detectLocation();
//                    }
//                    else {
//                        Toast.makeText(this,"Locationo permission is neessary",Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        }
//
//
//        private String fullName, phoneNumber, country, state, city, address, email, password, confirmPassword;
//
//        private void inputData() {
//            // input data
//            fullName = nameET.getText().toString().trim();
//            phoneNumber = phoneET.getText().toString().trim();
//            country = countryET.getText().toString().trim();
//            state = stateET.getText().toString().trim();
//            city = cityET.getText().toString().trim();
//            address = addressET.getText().toString().trim();
//            email = emailET.getText().toString().trim();
//            password = passwordET.getText().toString().trim();
//            confirmPassword = cPasswordET.getText().toString().trim();
//            // validate data
//            if (TextUtils.isEmpty(fullName)) {
//                Toast.makeText(this, "Enter Name ...", Toast.LENGTH_SHORT).show();
//                return;
//            }
//            if (TextUtils.isEmpty(phoneNumber)) {
//                Toast.makeText(this, "Enter Phone Number ...", Toast.LENGTH_SHORT).show();
//                return;
//            }
//        }
//        if(latitude ==0.0||longitude ==0.0)
//        {
//            Toast.makeText(this, "Please click GPS button to detect location ...", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
//            Toast.makeText(this, "Invalid email pattern ...", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if(password.length()<6){
//            Toast.makeText(this, "Password must be atleast6characters long ...", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if(!password.equals(confirmPassword)){
//            Toast.makeText(this, "Password doesn't match ...", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        createAccount();
//    }
//    private void createAccount() {
//        progressDialog.setMessage("Creating Account ...");
//        progressDialog.show();
//        // create account
//        firebaseAuth.createUserWithEmailAndPassword(email, password)
//                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
//                    @Override
//                    public void onSuccess(AuthResult authResult) {
//                        // account created
//                        saverFirebaseData();
//                    }
//                });
//
//            .addOnFailureListener(new OnFailureListener(){
//            @Override
//            public void onFailure(@NonNull Exceptione){
//                // failed creating account
//                progressDialog.dismiss();
//                Toast.makeText(RegisterUserActivity.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
//            };
//
//
//
//
//            private void detectLocation() {
//                Toast.makeText(this, "Please wait...", Toast.LENGTH_SHORT).show();
//                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
//
//            }
//            private boolean checkLocationPermission() {
//                boolean result = ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) ==
//                        (PackageManager.PERMISSION_GRANTED);
//                return result;
//            }
//            private void requestLocationPermission() {
//                ActivityCompat.requestPermissions(this, locationPermissions, LOCATION_REQUEST_CODE);
//            }
//            @Override
//            public void onLocationChanged(Location location){
//                latitude = location.getLatitude();
//                longitude = location.getLongitude();
//                findAddress();
//            }
//            private void findAddress() {
//                // find address,country,state,city
//                Geocoder geocoder;
//                List<Address> addresses;
//                geocoder = new Geocoder(this, Locale.getDefault());
//                try {
//                    addresses = geocoder.getFromLocation(latitude, longitude, 1);
//                    String address = addresses.get(0).getAddressLine(0);// complete address
//                    String city = addresses.get(0).getLocality();
//                    String state = addresses.get(0).getAdminArea();
//                    String country = addresses.get(0).getCountryName();
//                    // set addresses
//                    countryET.setText(country);
//                    stateET.setText(state);
//                    cityET.setText(city);
//                    addressET.setText(address);
//                } catch (Exceptione e) {
//                    Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//
//
//            @Override
//            public void onStatusChanged(String provider,int status,Bundle extras){}
//
//            @Override
//            public void onProviderEnabled(String provider){}
//            @Override
//            public void onProviderDisabled(String provider){
//                Toast.makeText(this,"Please turn on location ...",Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onRequestPermissionsResult(int requestCode,@NonNull String[] permissions,@NonNull int[] grantResults)
//
//            {
//                switch (requestCode){
//                    case LOCATION: REQUEST_CODE: {
//                        if (grantResults.length > 0) {
//                            boolean locationAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
//                            if (locationAccepted){
//                                // permission allowed
//                                detectLocation();
//                            }
//                            else{
//                                // permission denied
//                                Toast.makeText(this, "Location permission is necessary", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    }
//                        break;
//                }
//                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//            }
//        }

    }}



package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.adapter.NewReleaseAdapterRecyclerAdapter;
import com.example.myapplication.model.NewRelease;

import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {
private RecyclerView recyclerView;
NewReleaseAdapterRecyclerAdapter newReleaseAdapterRecyclerAdapter;
ArrayList<NewRelease> newReleaseList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

       // getSupportActionBar().setHomeButtonEnabled(true);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_nike);

        recyclerView = findViewById(R.id.recylcerview);

        newReleaseList = new ArrayList<>();
        NewRelease product1 = new NewRelease("AIR max",R.drawable.shoes1,"Mens","1000");
        NewRelease product2 = new NewRelease("Air",R.drawable.shoes1,"Mens","2000");
        NewRelease product3 = new NewRelease("air",R.drawable.shoes1,"Mens","3000");
        NewRelease product4 = new NewRelease("aIr",R.drawable.shoes1,"Mens","4000");
        NewRelease product5 = new NewRelease("air",R.drawable.shoes1,"Mens","5000");

        newReleaseList.add(product1);
        newReleaseList.add(product2);
        newReleaseList.add(product3);
        newReleaseList.add(product4);
        newReleaseList.add(product5);

        NewReleaseAdapterRecyclerAdapter adapter = new NewReleaseAdapterRecyclerAdapter(this,newReleaseList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(adapter);

    }
}
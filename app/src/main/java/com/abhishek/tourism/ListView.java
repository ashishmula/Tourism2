package com.abhishek.tourism;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ListView extends AppCompatActivity {
    RecyclerView.Adapter madapter;
    RecyclerView.LayoutManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        RecyclerView rcView=findViewById(R.id.recylerview);
        rcView.setHasFixedSize(true);
        Intent i=getIntent();
        Bundle args=i.getBundleExtra("places1");
        ArrayList<Place> places=(ArrayList<Place>)args.getSerializable("places");
        manager=new LinearLayoutManager(this);
        madapter=new PlaceAdapter(places);
        rcView.setLayoutManager(manager);
        rcView.setAdapter(madapter);


    }
}
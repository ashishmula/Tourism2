package com.abhishek.tourism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class Home extends AppCompatActivity {
    ArrayList<Country> countries=new ArrayList<>();
    ArrayList<Place> places=new ArrayList<>();
    ArrayList<String> countryNames=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Spinner spinnerCountry=findViewById(R.id.spinnerCountry);
        TextView txtCountry=findViewById(R.id.txtCountry);
        Button btnGo=findViewById(R.id.btnGo);
        ImageView imgCountry=findViewById(R.id.imgCountry);
        fillData();
        ArrayAdapter aa=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,countryNames);
        spinnerCountry.setAdapter(aa);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Home.this,ListView.class);
               Bundle args=new Bundle();
               args.putSerializable("places",(Serializable)places);
               i.putExtra("places1",args);
                startActivity(i);
            }
        });
        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txtCountry.setText(countries.get(position).getName());
                imgCountry.setImageResource(countries.get(position).getImage());
                places=countries.get(position).getPlaces();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    private void fillData() {
        ArrayList<Place> p1s=new ArrayList<>();
        ArrayList<Place> p2s=new ArrayList<>();
        ArrayList<Place> p3s=new ArrayList<>();
        p2s.add(new Place("Statue of Liberty",90,R.drawable.statueofliberty));
        p2s.add(new Place("White House",60,R.drawable.whitehouse));
        p2s.add(new Place("Times Square",75,R.drawable.timessquare));
        p3s.add(new Place("Big ben",30,R.drawable.belltowe));
        p3s.add(new Place("Westminister Abbey",25,R.drawable.westminister));
        p3s.add(new Place("Hyde Park",15,R.drawable.hydeprk));

        Place p1=new Place("Niagara",100,R.drawable.niagara);
        Place p2=new Place("CN Tower",30,R.drawable.cntower);
        Place p3=new Place("The Butchart Gardens",30,R.drawable.btchartgardens);
        Place p4=new Place("Notre Dame Basilica",50,R.drawable.notre);
        p1s.add(p1);
        p1s.add(p2);
        p1s.add(p3);
        p1s.add(p4);

        Country c1=new Country("Canada","Ottawa",R.drawable.canada,p1s);
        Country c2=new Country("USA","Washington",R.drawable.usa,p2s);
        Country c3=new Country("England","London",R.drawable.england,p3s);
        countries.add(c1);
        countries.add(c2);
        countries.add(c3);
        for(Country c:countries){
            countryNames.add(c.getName());
        }
        System.out.println(countryNames);

    }
}
package com.abhishek.tourism;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView txtHeading=findViewById(R.id.txtheading);
        Button btnCalculate=findViewById(R.id.btnCalculate);
        EditText edtCount=findViewById(R.id.txtcount);
        ImageView imgPlace=findViewById(R.id.imgPlace);
        Intent i=getIntent();
        Bundle args=i.getBundleExtra("places1");
        Place place= (Place) args.getSerializable("places");
        imgPlace.setImageResource(place.getImage());
        txtHeading.setText(place.getName());
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtCount.getText().toString().equals("")) {
                    AlertDialog.Builder myalertq = new AlertDialog.Builder(Detail.this);
                    myalertq.setTitle("Please enter Quantity to Continue");
                    myalertq.setNeutralButton("Ok", null);
                    myalertq.show();

                } else {
                    int count = Integer.parseInt(edtCount.getText().toString());
                    System.out.println(count);

                    if (count > 15) {
                        AlertDialog.Builder myalertq = new AlertDialog.Builder(Detail.this);
                        int s = 100 - 5;
                        int markedprice = count * place.getTicketPrice();
                        myalertq.setTitle("Total Price: $" + markedprice);
                        myalertq.setMessage("After Discount: $" + (s * markedprice) / 100);
                        myalertq.setNeutralButton("Ok", null);
                        myalertq.show();
                    } else if (count < 15) {
                        AlertDialog.Builder myalertw = new AlertDialog.Builder(Detail.this);
                        myalertw.setTitle("Total Price: $" + count * place.getTicketPrice());
                        myalertw.setNeutralButton("Ok", null);
                        myalertw.show();
                    }

                }
            }
        });
    }
}
package com.example.halfblood.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Que extends AppCompatActivity {
ImageView image;
    Button start,stop,next,back;
    TextView current,remainig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_que);

        image =(ImageView)findViewById(R.id.imgman);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newint = new Intent(getApplicationContext(),Transaction.class);
                startActivity(newint);
            }
        });
         start = (Button)findViewById(R.id.button9);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop = (Button)findViewById(R.id.btnstop);
                stop.setVisibility(View.VISIBLE);
            }
        });
        stop = (Button)findViewById(R.id.btnstop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop.setVisibility(View.INVISIBLE);
            }
        });
        next =(Button)findViewById(R.id.btnnext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i =0;i<=10;i++){
                    current =(TextView)findViewById(R.id.txtcurrent);
                    current.setText(i);
                }
            }
        });



    }
}

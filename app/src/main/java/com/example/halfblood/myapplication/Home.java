package com.example.halfblood.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
TextView textView;
    Button today,schedule,message1,history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textView=(TextView)findViewById(R.id.txtwecom);
        String message=getIntent().getStringExtra("message");
        textView.setText(message);

        today=(Button)findViewById(R.id.btntodayh);
        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnew = new Intent(getApplicationContext(),Today.class);
                startActivity(intnew);
            }
        });

        message1 = (Button)findViewById(R.id.btnmessageh);
        message1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnew = new Intent(getApplicationContext(),Create_Message.class);
                startActivity(intnew);
            }
        });
        history = (Button)findViewById(R.id.btnhistoryh);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newint = new Intent(getApplicationContext(),Search.class);
                startActivity(newint);
            }
        });
        schedule = (Button)findViewById(R.id.btnsheduleh);
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newint = new Intent(getApplicationContext(),List_Schedule1.class);
                startActivity(newint);
            }
        });
    }
}

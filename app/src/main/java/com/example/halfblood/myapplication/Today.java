package com.example.halfblood.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Today extends AppCompatActivity {
    private ListView listView;
    private String names[] = {
            "Hemas Hospital",
            "Browns Hospital",
            "Lesons Hospital",
            "Nawaloka Hospital"
    };

    private String desc[] = {
            "Patient 2",
            "Patient 4",
            "Patient 5",
            "Patient 6"
    };
    private String timea[] = {
            "8.00-12.00",
            "12.30-2.30",
            "3.00-4.00",
            "5.00-7.00"
    };


    private Integer imageid[] = {
            R.drawable.five,
            R.drawable.one,
            R.drawable.three,
            R.drawable.two
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);

        CustomList customList = new CustomList(this,names, desc,timea, imageid);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(customList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent newint =new Intent(getApplicationContext(),Que.class);
                startActivity(newint);
            }
        });
        Button home =(Button)findViewById(R.id.btnhome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newint = new Intent(getApplicationContext(),Home.class);
                startActivity(newint);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}

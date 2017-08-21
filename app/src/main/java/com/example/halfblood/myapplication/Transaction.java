package com.example.halfblood.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Transaction extends AppCompatActivity {
ImageView image;
    Button save;
    EditText discription;
    TextView name;
    Spinner spinner,spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
         discription =(EditText)findViewById(R.id.txtdiscription);
         name = (TextView)findViewById(R.id.txtname);

         spinner = (Spinner) findViewById(R.id.spinner);
         spinner1 = (Spinner) findViewById(R.id.spinner2);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner1.setAdapter(adapter1);

        image =(ImageView)findViewById(R.id.imgman);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newint = new Intent(getApplicationContext(),Patient_History.class);
                startActivity(newint);
            }
        });
        save=(Button)findViewById(R.id.btnsavet);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundTask backgroundTask =new BackgroundTask(Transaction.this);
                backgroundTask.execute("insert",name.getText().toString(),discription.getText().toString(),spinner.getSelectedItem().toString(),spinner1.getSelectedItem().toString());
            }
        });




    }
}

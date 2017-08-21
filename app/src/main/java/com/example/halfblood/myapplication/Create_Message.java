package com.example.halfblood.myapplication;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Create_Message extends AppCompatActivity {
ListView listView=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__message);
        listView=new ListView(this);
        String[] items = {"Plaase Call me...","Contact the Hospital","I am Sorry I cant Come Today","Change the Schedule date"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_items,R.id.txtitems,items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ViewGroup vg =(ViewGroup)view;
                TextView txt = (TextView)vg.findViewById(R.id.txtitems);
                EditText messagew = (EditText)findViewById(R.id.txtmessagew);
                messagew.setText(txt.getText().toString());


            }

        });


    }
    public void showDialogListView(View view){
        AlertDialog.Builder builder =new AlertDialog.Builder(Create_Message.this);
        builder.setCancelable(true);
        builder.setPositiveButton("OK",null);
        builder.setView(listView);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

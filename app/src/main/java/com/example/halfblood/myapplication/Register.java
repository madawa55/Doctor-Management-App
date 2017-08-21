package com.example.halfblood.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    EditText Name,Email,Pass,ConPass;
    Button reg_button;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Name=(EditText)findViewById(R.id.txtuname);
        Email=(EditText)findViewById(R.id.txtemail);
        Pass = (EditText)findViewById(R.id.txtpassword);
        ConPass =(EditText)findViewById(R.id.txtcompass);
        reg_button =(Button)findViewById(R.id.btnreg);
        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Name.getText().toString().equals("")||Email.getText().toString().equals("")||Pass.getText().toString().equals("")){
                    builder =new AlertDialog.Builder(Register.this);
                    builder.setTitle("Somthing Want Wrong");
                    builder.setMessage("Please fill all the Filds...");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog alertDialog =builder.create();
                    alertDialog.show();
                }
                else if(!(Pass.getText().toString().equals(ConPass.getText().toString()))){
                    builder =new AlertDialog.Builder(Register.this);
                    builder.setTitle("Somthing Want Wrong");
                    builder.setMessage("Your Password are Not matching...");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Pass.setText("");
                            ConPass.setText("");
                        }
                    });
                    AlertDialog alertDialog =builder.create();
                    alertDialog.show();
                }
                else{
                    BackgroundTask backgroundTask =new BackgroundTask(Register.this);
                    backgroundTask.execute("register",Name.getText().toString(),Email.getText().toString(),Pass.getText().toString());

                }
            }
        });

    }
}
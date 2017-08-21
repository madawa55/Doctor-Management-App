package com.example.halfblood.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
    Button btnlogin,test;
    EditText username,password;
    TextView singup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnlogin = (Button)findViewById(R.id.btnlogin);
        username=(EditText)findViewById(R.id.txtusername);
        password= (EditText)findViewById(R.id.txtpassword);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final String email = username.getText().toString();
                if (!isValidEmail(email)) {
                    //Set error message for email field
                    username.setError("Invalid Email");
                }

                final String pass = password.getText().toString();
                if (!isValidPassword(pass)) {
                    //Set error message for password field
                    password.setError("Password cannot be empty");
                }

                if(isValidEmail(email) && isValidPassword(pass))
                {
                    // Validation Completed
                }
                else{

                }
                BackgroundTask backgroundTask =new BackgroundTask(Login.this);
                backgroundTask.execute("login",username.getText().toString(),password.getText().toString());

                //Intent newint = new Intent(getApplicationContext(),Transaction.class);
                //startActivity(newint);

            }
        });
               singup =(TextView) findViewById(R.id.txtsingup);
        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newint = new Intent(getApplicationContext(),Register.class);
                startActivity(newint);
            }
        });

    }
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // validating password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() >= 4) {
            return true;
        }
        return false;
    }
}

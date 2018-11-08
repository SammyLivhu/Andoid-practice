package com.example.student.fgscleaningservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final DataBaseHandler db = new DataBaseHandler(this);
        final EditText surname = findViewById(R.id.edtSurname);
        final EditText initials = findViewById(R.id.edtInitials);
        final EditText phone = findViewById(R.id.edtPhone);
        final EditText email = findViewById(R.id.edtEmail);
        final EditText username = findViewById(R.id.edtUsername);
        final EditText password = findViewById(R.id.edtPassword);

        Button btnHome = (Button) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), HomeActivity.class);

                startActivity(startIntent);
            }
        });

        Button btnAbout = (Button) findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), AboutActivity.class);

                startActivity(startIntent);
            }
        });
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), LogInActivity.class);

                startActivity(startIntent);
            }
        });

        Button btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), RegisterActivity.class);

                startActivity(startIntent);
            }
        });

        Button btnReg = (Button) findViewById(R.id.btnReg);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView display = findViewById(R.id.txtDisplay);

                try{

                    db.addClient(new Customer(surname.getText().toString(),initials.getText().toString(),phone.getText().toString(),email.getText().toString(),username.getText().toString(),password.getText().toString()));
                    display.setText("You have been successfully registered!");

                }
                catch (Exception ex){
                    display.setText("An error occurred, re-enter your details");


                }

            }
        });

    }
}

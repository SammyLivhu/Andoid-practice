package com.example.student.fgscleaningservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        final DataBaseHandler db = new DataBaseHandler(this);
        final EditText username = findViewById(R.id.edtxtUsername);
        final EditText password = findViewById(R.id.edtxtPassword);
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

        Button btnProceed = (Button) findViewById(R.id.btnProceed);
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView display = findViewById(R.id.txtDisplay);
                try {
                    Customer mycustomer = db.getCustomer(username.getText().toString());
                    String user = mycustomer.getUsername();
                    String name = mycustomer.getSurname();
                    String init = mycustomer.getInitials();
                    Intent startIntent = new Intent(getApplicationContext(), AddBookingActivity.class);
                    startIntent.putExtra("com.example.student.fgscleaningservices.SURNAME",name);
                    startIntent.putExtra("com.example.student.fgscleaningservices.INITIALS",init);
                    startActivity(startIntent);

                }
               catch (Exception ex){
                    display.setText("An error occured, Please try to register!");
                }
            }


        });
    }
}

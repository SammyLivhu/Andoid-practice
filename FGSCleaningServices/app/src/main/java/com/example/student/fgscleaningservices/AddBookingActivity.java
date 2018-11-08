package com.example.student.fgscleaningservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddBookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_booking);

        String surname = getIntent().getExtras().getString("com.example.student.fgscleaningservices.SURNAME");
        String initials = getIntent().getExtras().getString("com.example.student.fgscleaningservices.INITIALS");
        TextView cust = findViewById(R.id.txtName);
        cust.setText("Hello, " + surname + " " + initials + "!");

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), LogInActivity.class);

                startActivity(startIntent);
            }
        });

        Button btnAddBooking = (Button) findViewById(R.id.btnAddBooking);
        btnAddBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), AddBookingActivity.class);

                startActivity(startIntent);
            }
        });

        Button btnViewBooking = (Button) findViewById(R.id.btnViewBook);
        btnViewBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), ViewBooking.class);

                startActivity(startIntent);
            }
        });

    }
}

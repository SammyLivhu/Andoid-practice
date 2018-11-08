package com.example.student.fgscleaningservices;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ViewBooking extends AppCompatActivity
{
    @Override
    protected  void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_booking);
        DataBaseHandler DataBaseHandler =  new DataBaseHandler(this);

    }
}

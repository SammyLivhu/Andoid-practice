package com.example.student.fgscleaningservices;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHandler extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "cleaning";
    private static final String TABLE_CUSTOMER = "customer";
    private static final String KEY_ID = "id";
    private static final String KEY_SURNAME = "surname";
    private static final String KEY_INITIALS = "initials";
    private static final String KEY_PH_NO = "phone_number";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    public DataBaseHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_TABLE_CUSTOMER = "CREATE TABLE " + TABLE_CUSTOMER  + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_SURNAME + " TEXT," + KEY_INITIALS + " TEXT,"
                + KEY_PH_NO + " TEXT," + KEY_EMAIL + " TEXT,"  + " TEXT," + KEY_USERNAME + " TEXT," + KEY_PASSWORD  + " TEXT" + ")";
        db.execSQL(CREATE_TABLE_CUSTOMER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CUSTOMER);
        onCreate(db);

    }

    void addClient(Customer customer)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_SURNAME,customer.getSurname());
        values.put(KEY_INITIALS,customer.getInitials());
        values.put(KEY_PH_NO,customer.getPhone());
        values.put(KEY_EMAIL,customer.getEmail());
        values.put(KEY_USERNAME,customer.getUsername());
        values.put(KEY_PASSWORD,customer.getPassword());

        db.insert(TABLE_CUSTOMER,null,values);
        //insert
        db.close();

    }

    Customer getCustomer(String username)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CUSTOMER, new String[]{KEY_ID,KEY_SURNAME,KEY_INITIALS,KEY_PH_NO,KEY_EMAIL,KEY_USERNAME,KEY_PASSWORD},KEY_USERNAME+"=?",new String[]{String.valueOf(username)},null,null,null,null);
        Customer customer;
        if(cursor!=null)
        {
            cursor.moveToFirst();
            String key = cursor.getString(0);
            String surname = cursor.getString(1);
            String initials = cursor.getString(2);
            String phone = cursor.getString(3);
            String email = cursor.getString(4);
            String login_name = cursor.getString(5);
            String password = cursor.getString(6);
            customer = new Customer(Integer.parseInt(key),surname,initials,phone,email,login_name,password);

        }
        else
        {
            customer = new Customer(1,"defaultname","defaultInit","defaultNumber","defaultemail","defaultusername","defaultpassword");

        }
        return customer;

    }

}

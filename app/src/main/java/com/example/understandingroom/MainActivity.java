package com.example.understandingroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText firstNameEdittext;
    private EditText lastNameEdittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void addNewUser(View view) {
        firstNameEdittext = findViewById(R.id.user_firstname);
        lastNameEdittext = findViewById(R.id.user_lastname);
        String userFirstName = firstNameEdittext.getText().toString();
        String userLastName = lastNameEdittext.getText().toString();

        // Create new user
        User newUser = new User(userFirstName, userLastName);

        // Start new thread -- Insert new user in DB
        Thread cThread = new DBInsertThread(newUser, getApplicationContext());
        cThread.start();
    }

    public void showUsers(View view) {
        Thread dbGetAll = new DBGetAllThread(getApplicationContext());
        dbGetAll.start();

        Intent intent = new Intent(getApplicationContext(), ShowAllUsersActivity.class);
        startActivity(intent);
    }
}

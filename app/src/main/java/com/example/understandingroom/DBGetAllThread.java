package com.example.understandingroom;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import java.util.List;

public class DBGetAllThread extends Thread {
    private List<User> users;
    private AppDataBase DB;

    public DBGetAllThread(Context context) {
        DB = Room.databaseBuilder(context,
                AppDataBase.class, "user_database")
                .build();
    }

    public List<User> getAllUsers() {
        return DB.userDao().getAll();
    }

    public void run() {
        Log.d("cTHREAD", "RUNNING...");
        users = getAllUsers();
        for(User user : users) {
            String temp = "\n" + user.firstName + " " + user.lastName + " " + user.id + "\n";
            Log.d("USERS", temp);
        }
    }


}

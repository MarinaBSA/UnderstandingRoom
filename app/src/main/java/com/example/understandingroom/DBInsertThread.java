package com.example.understandingroom;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

public class DBInsertThread extends Thread {
    private User user;
    private AppDataBase DB;

    public DBInsertThread(User user, Context context) {
        this.user = user;
        DB = Room.databaseBuilder(context,
                AppDataBase.class, "user_database")
                .build();
    }

    public void run() {
        Log.d("cTHREAD", "RUNNING...");
        addNewUser(user);
    }

    public void addNewUser(User user) {
        DB.userDao().insert(user);
    }


}

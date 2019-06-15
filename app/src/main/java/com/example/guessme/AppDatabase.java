package com.example.guessme;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {word.class,user.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract wordDAO getWordDAO();
    public abstract userDAO getUserDAO();

}



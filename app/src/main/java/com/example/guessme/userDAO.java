package com.example.guessme;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface userDAO {
    @Insert
    public void insert(user...users);

    @Update
    public void update(user... users);

    @Delete
    public void delete(user user);

    @Query("SELECT * FROM users")
    public List<user> getUsers();

    @Query("SELECT * FROM users WHERE id = :number")
    public user getUserWithId(String number);
}

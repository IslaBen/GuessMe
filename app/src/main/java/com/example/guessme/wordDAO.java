package com.example.guessme;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface wordDAO {
    @Insert
    public void insert(word...words);

    @Update
    public void update(word... words);

    @Delete
    public void delete(word word);

    @Query("SELECT * FROM words")
    public List<word> getWords();

    @Query("SELECT * FROM words WHERE id = :number")
    public word getWordWithId(String number);
}

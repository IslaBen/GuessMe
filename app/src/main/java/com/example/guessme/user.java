package com.example.guessme;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "users")
public class user {

    @PrimaryKey(autoGenerate =true)
    Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String name;
    public int score;
    public int level;

    public user(String name) {

        this.name = name;
        this.score = 0;
        level=0;
    }

    @Override
    public boolean equals(Object obj) {
        user u = (user) obj;
        return this.name.equals(u.name);
    }

    public void levelUp(){
        this.level++;
    }

    public void correct(){
        this.score += 5;
    }
    public void wrong(){
        this.score -= 3;
    }

    public boolean won(){
        return this.level>7;
    }
}

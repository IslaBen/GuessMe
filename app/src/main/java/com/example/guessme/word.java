package com.example.guessme;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "words")
public class word {
    @PrimaryKey(autoGenerate = true) @NonNull
    public Integer id;

    String pre,missing,post;

    public word(String pre,String missing,String post){
        this.pre = pre;
        this.missing = missing;
        this.post = post;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre;
    }

    public String getMissing() {
        return missing;
    }

    public void setMissing(String missing) {
        this.missing = missing;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public boolean equals(String missing) {
        return this.missing.equals(missing);
    }
}

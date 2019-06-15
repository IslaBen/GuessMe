package com.example.guessme;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "db-contacts")
                .allowMainThreadQueries()   //Allows room to do operation on main thread
                .build();
        final wordDAO wbdd = database.getWordDAO();
        wbdd.insert(new word("he","ll","o"));
        wbdd.insert(new word("wel","co","me"));
        wbdd.insert(new word("ha","pp","y"));
        wbdd.insert(new word("an","gr","y"));
        wbdd.insert(new word("s","ai","d"));
        wbdd.insert(new word("f","oo","d"));
        wbdd.insert(new word("l","ov","e"));
        wbdd.insert(new word("fr","ie","nd"));

        final userDAO ubdd = database.getUserDAO();

        final EditText name = (EditText) findViewById(R.id.name);
        final LinearLayout uform = (LinearLayout) findViewById(R.id.userForm);
        final LinearLayout form = (LinearLayout) findViewById(R.id.form);
        final LinearLayout status = (LinearLayout) findViewById(R.id.status);

        Button start = (Button) findViewById(R.id.start);
        Button check = (Button) findViewById(R.id.check);
        final TextView level = (TextView) findViewById(R.id.level);
        final TextView score = (TextView) findViewById(R.id.score);
        final TextView X = (TextView) findViewById(R.id.X);

        final TextView pre = (TextView) findViewById(R.id.pre);
        final TextView post = (TextView) findViewById(R.id.post);
        final EditText missing = (EditText) findViewById(R.id.missing);

        final word[] theWord = new word[1];
        final user[] u = new user[1];
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                u[0] = new user(name.getText().toString());

                List<user> users = ubdd.getUsers();

                if (users.contains(u[0])){
                    u[0] = users.get(users.indexOf(u[0]));
                }else ubdd.insert(u[0]);

                score.setText(String.valueOf(u[0].score));
                level.setText(String.valueOf(u[0].level));
                uform.setVisibility(View.GONE);
                status.setVisibility(View.VISIBLE);
                theWord[0] = wbdd.getWords().get(u[0].level);
                pre.setText(theWord[0].pre);
                post.setText(theWord[0].post);
                form.setVisibility(View.VISIBLE);
           }
        });

        check.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(u[0].won()){
                    X.setTextSize(20);
                    X.setText("Winner!!!");
                    form.setVisibility(View.GONE);
                }else {
                    if (theWord[0].missing.equals(missing.getText().toString())) {
                        u[0].levelUp();
                        u[0].correct();
                        ubdd.update(u[0]);
                        level.setText(String.valueOf(u[0].level));
                        theWord[0] = wbdd.getWords().get(u[0].level);
                        pre.setText(theWord[0].pre);
                        post.setText(theWord[0].post);
                        X.setText("\u2713");
                        missing.setText("");
                    } else {
                        u[0].wrong();
                        X.setText("X");
                        ubdd.update(u[0]);
                    }

                    score.setText(String.valueOf(u[0].score));
                }
            }
        });



    }
}

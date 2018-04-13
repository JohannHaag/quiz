package com.example.otmane.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class quiz extends AppCompatActivity {

    Button b_continue;
    TextView tv_question;
    EditText ed_answer;

    List<item> itemdb;

/*
    Random r;
*/
    int thisone = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        b_continue = (Button) findViewById(R.id.buttonc);
        tv_question = (TextView) findViewById(R.id.tv_question);
        ed_answer = (EditText) findViewById(R.id.et_answer);

        b_continue.setVisibility(View.INVISIBLE);

        itemdb = new ArrayList<>();
        for (int i = 0 ; i < Database.question.length;i++){
            itemdb.add(new item(Database.question[i],Database.answers[i]));
        }

        Collections.shuffle(itemdb);

        tv_question.setText(itemdb.get(thisone).getQuestion());

        /*r = new Random();*/

        ed_answer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (ed_answer.getText().toString().equalsIgnoreCase(itemdb.get(thisone).getAnswer())){
                    b_continue.setVisibility(View.VISIBLE);
                }else {
                    b_continue.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        b_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (thisone < Database.question.length - 1 ){
                    thisone++;
                    tv_question.setText(itemdb.get(thisone).getQuestion());
                    b_continue.setVisibility(View.INVISIBLE);
                    ed_answer.setText("");
                }else {
                    Toast.makeText(quiz.this, "you won the game ",Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}

package com.mulodo.javascriptquiz.activity;

import java.util.ArrayList;

import com.mulodo.javascriptquiz.R;
import com.mulodo.javascriptquiz.model.QuizApplication;

import android.app.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuestionActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        QuizApplication app = (QuizApplication) this.getApplication();
        int sequence = app.getSequence();
        String question = app.quiz.getQuestion(sequence);
        ArrayList<String> choises = app.quiz.getChoises(sequence);

        TextView a = (TextView) findViewById(R.id.textView1);
        TextView b = (TextView) findViewById(R.id.textView3);
        Button p = (Button) findViewById(R.id.button1);
        Button q = (Button) findViewById(R.id.button2);
        Button r = (Button) findViewById(R.id.button3);

        switch (sequence) {
        case 0:
            a.setText("Question 1  [ EASY 30pts ]");
            break;
        case 1:
            a.setText("Question 2  [ MEDIUM 40pts ]");
            break;
        case 2:
            a.setText("Question 3  [ HARD 30pts ]");
            break;
        }

        b.setText(question);
        p.setText(choises.get(0));
        q.setText(choises.get(1));
        r.setText(choises.get(2));

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(v.getId());
                finish();
            }
        };

        findViewById(R.id.button1).setOnClickListener(listener);
        findViewById(R.id.button2).setOnClickListener(listener);
        findViewById(R.id.button3).setOnClickListener(listener);
    }

}

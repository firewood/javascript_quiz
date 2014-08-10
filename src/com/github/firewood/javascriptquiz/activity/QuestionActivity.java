package com.github.firewood.javascriptquiz.activity;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.github.firewood.javascriptquiz.model.QuizApplication;
import com.github.firewood.javascriptquiz.R;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class QuestionActivity extends Activity {

    private MediaPlayer mp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        QuizApplication app = (QuizApplication) getApplication();
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
                int choice = 0;
                switch (v.getId()) {
                case R.id.button1:
                    choice = 1;
                    break;
                case R.id.button2:
                    choice = 2;
                    break;
                case R.id.button3:
                    choice = 3;
                    break;
                }
                setResult(choice);

                QuizApplication app = (QuizApplication) getApplication();
                int sequence = app.getSequence();
                int answer = app.quiz.getAnswer(sequence);

                int wait;
                if (choice == answer) {
                    wait = 1000;
                    playSound(R.raw.seikai02_2);
                } else {
                    showCorrectAnswer(answer);
                    wait = 2000;
                    playSound(R.raw.huseikai02_3);
                }

                Timer t = new Timer();
                t.schedule(new TimerTask() {

                    @Override
                    public void run() {
                        finish();
                    }
                }, wait);
            }
        };

        findViewById(R.id.button1).setOnClickListener(listener);
        findViewById(R.id.button2).setOnClickListener(listener);
        findViewById(R.id.button3).setOnClickListener(listener);
    }

    private void playSound(int r) {
        mp = MediaPlayer.create(this, r);
        mp.start();
    }

    private void showCorrectAnswer(int answer) {
        int res = 0;
        switch (answer) {
        case 1:
            res = R.id.button1;
            break;
        case 2:
            res = R.id.button2;
            break;
        case 3:
            res = R.id.button3;
            break;
        }

        Button btn = (Button) findViewById(res);
        btn.setTextColor(Color.RED);
        btn.setTextSize(20);

    }

}

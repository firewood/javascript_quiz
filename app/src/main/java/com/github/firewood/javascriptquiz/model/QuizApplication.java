package com.github.firewood.javascriptquiz.model;

import java.util.ArrayList;

import android.app.Application;
import android.util.Log;

public class QuizApplication extends Application {
    private int sequence;
    public QuizModel quiz;

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int seq) {
        sequence = seq;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.v("jsq", "onCreate");

        quiz = new QuizModel();
        quiz.init(getApplicationContext());

    }

}

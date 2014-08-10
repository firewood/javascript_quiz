package com.mulodo.javascriptquiz.model;

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

        Log.v("app", "onCreate");

		quiz = new QuizModel();
		quiz.init(getApplicationContext());
		
	}	

/*
    public String getQuestion(int seq) {
        return quiz.getQuestion(seq);
    }

	public ArrayList<String> getChoises(int seq) {
	    return quiz.getChoises(seq);
	}
*/

}

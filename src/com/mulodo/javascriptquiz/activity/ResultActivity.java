package com.mulodo.javascriptquiz.activity;

import com.mulodo.javascriptquiz.R;
import com.mulodo.javascriptquiz.R.id;
import com.mulodo.javascriptquiz.R.layout;
import com.mulodo.javascriptquiz.model.QuizApplication;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {

	private int answer[];
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		Button btn = (Button)findViewById(R.id.button1);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		answer = new int[16];
		QuizApplication app = (QuizApplication) this.getApplication();
		app.setSequence(0);

		showNextQuestion();
	}	

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.v("jq_main", "onActivityResult " + resultCode);

		int choice = -1;
		switch (resultCode) {
		case R.id.button1:
			choice = 0;
			break;
		case R.id.button2:
			choice = 1;
			break;
		case R.id.button3:
			choice = 2;
			break;
		}

		QuizApplication app = (QuizApplication) this.getApplication();
		int sequence = app.getSequence();
		answer[sequence] = choice;
		++sequence;
		app.setSequence(sequence);

/*
		Log.v("choice", "CHOICE");
		int i;
		for (i = 0; i < sequence; ++i) {
			Log.v("choice", Integer.toString(answer[i]));
		}
*/
		
		if (sequence < 3) {
			showNextQuestion();
		} else {
			TextView r = (TextView)findViewById(R.id.textView3);
			TextView t = (TextView)findViewById(R.id.textView5);

			int c = 0;
			int score = 0;
			int f = 0;
			if (answer[0] == 1) {
				++c;
				score += 30;
				f |= 1;
			}
			if (answer[1] == 1) {
				++c;
				score += 40;
				f |= 2;
			}
			if (answer[2] == 1) {
				++c;
				score += 30;
				f |= 4;
			}

			String s;
			switch (f) {
			case 3:
				s = "[ Master of JavaScript ]";
				break;
			case 7:
				s = "[ God of JavaScript ]";
				break;
			default:
				s = "[ Let's enjoy JavaScript! ]";
				break;
			}
			
			r.setText(Integer.toString(c) + " of 3  :  " + Integer.toString(score) + " pts");
			t.setText(s);
		}
	}		

	private void showNextQuestion() {
		Intent t = new Intent(getApplicationContext(), QuestionActivity.class);
		startActivityForResult(t, 0);
	}
	
}


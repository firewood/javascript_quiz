package com.mulodo.javascriptquiz.activity;

import com.mulodo.javascriptquiz.R;
import com.mulodo.javascriptquiz.R.id;
import com.mulodo.javascriptquiz.R.layout;
import com.mulodo.javascriptquiz.R.menu;
import com.mulodo.javascriptquiz.model.QuizApplication;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(getApplicationContext(),
                        ResultActivity.class);
                startActivity(t);
            }
        });

        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(getApplicationContext(),
                        CopyrightActivity.class);
                startActivity(t);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}

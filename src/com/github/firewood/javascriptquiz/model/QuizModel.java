package com.github.firewood.javascriptquiz.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import com.github.firewood.javascriptquiz.R;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import au.com.bytecode.opencsv.CSVParser;
import au.com.bytecode.opencsv.CSVReader;

public class QuizModel {

    private ArrayList<String> question = new ArrayList<String>();
    private ArrayList<Integer> answer = new ArrayList<Integer>();
    private ArrayList<ArrayList<String>> choises = new ArrayList<ArrayList<String>>();

    public QuizModel() {

    }

    public void init(Context context) {

        Log.v("jsq", "QuizModel::init");

        try {
            Resources res = context.getResources();
            InputStream is = res.openRawResource(R.raw.quiz);
            InputStreamReader isreader = new InputStreamReader(is, "UTF-8");
            CSVReader csvreader = new CSVReader(isreader, ',',
                    CSVParser.DEFAULT_QUOTE_CHARACTER, 1);
            String[] csv;
            while ((csv = csvreader.readNext()) != null) {
                Log.v("app", csv[0]);

                int seq = Integer.parseInt(csv[0]);
                int points = Integer.parseInt(csv[1]);
                answer.add(Integer.parseInt(csv[2]));
                int num = Math.min(Integer.parseInt(csv[3]), csv.length - 5);
                question.add(csv[4]);

                ArrayList<String> l = new ArrayList<String>();
                for (int i = 0; i < num; ++i) {
                    l.add(csv[i + 5]);

                    Log.v("app", csv[i + 5]);
                }
                choises.add(l);
            }
            csvreader.close();
            isreader.close();
            is.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    };

    public String getQuestion(int seq) {
        return question.get(seq);
    }

    public int getAnswer(int seq) {
        return answer.get(seq);
    }

    public ArrayList<String> getChoises(int seq) {
        return choises.get(seq);
    }

}

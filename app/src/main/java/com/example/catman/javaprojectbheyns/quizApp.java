package com.example.catman.javaprojectbheyns;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
/**
 * Created by Bernard Heyns - DV2013-0499 on 2016-10-08.
 * Android Final Semester Project
 */
public class quizApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_app);
    }
    //This activity is the simple landing screen which calls the actual quiz , no logic happens in this class
    public void callQuiz(View view) {
        Intent intent = new Intent(this,quizScreens.class);
        startActivity(intent);
    }
}

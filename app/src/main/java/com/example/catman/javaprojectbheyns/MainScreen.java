package com.example.catman.javaprojectbheyns;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
/**
 * Created by Bernard Heyns - DV2013-0499 on 2016-10-08.
 * Android Final Semester Project
 */
public class MainScreen extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.catman.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }
    //Creates a new intent for the calculator when the calc button is clicked
    public void calculator(View view) {
        Intent intent = new Intent(this,Calculator.class);
        startActivity(intent);
    }
    //Creates a new intent for the quiz when the quiz button is clicked
    public void quiz(View view) {
        Intent intent = new Intent(this,quizApp.class);
        startActivity(intent);
    }
    //Creates a new intent for the paintBrush when the paint brush button is clicked
    public void paintBrush(View view) {
        Intent intent = new Intent(this,PaintTivity.class);
        startActivity(intent);
    }
    /** Called when the user clicks the Send button
    public void sendMessage(View view) {
        Intent intent = new Intent(this, Calculator.class);
        EditText editText = (EditText) findViewById(R.id.);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
*/
}

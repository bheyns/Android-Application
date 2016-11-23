package com.example.catman.javaprojectbheyns;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * Created by Bernard Heyns - DV2013-0499 on 2016-10-08.
 * Android Final Semester Project
 */
public class Calculator extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Sets the content and the layout of the app
        setContentView(R.layout.activity_calculator2);
        //Create an instance of intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainScreen.EXTRA_MESSAGE);
        //Create a new instance of a text view and specify the size
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        //Adds the layout and the textView to the layout
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_calculator2);
        layout.addView(textView);
    }
    //The method that is called when any button is clicked in the calculator
    public void calc(View view) {
        //Get the editable bars in the calculator and assign them
        EditText EL =(EditText)findViewById(R.id.number1);
        EditText EL2 =(EditText)findViewById(R.id.number2);
        // Create new decimal Formatter
        DecimalFormat df = new DecimalFormat(".##");
        //Initialise TextView
        TextView tt ;
        //Assign the text to String variables in order to check if they are empty
        String firstCheck = EL.getText().toString();
        String secondCheck = EL2.getText().toString();
        //Initialise the ints that is going to be used in the calculations
        double firstVal ;
        double secondVal;
        double result = 0;
    //Check which button is pressed
        if(view.getId()==R.id.addButton){
            //Get the result field
            tt = (TextView)findViewById(R.id.resultField);
            //Check if the First value and second value fields are empty
            if (firstCheck.equals("") || secondCheck.equals("")){
                //Let the user know that the fields are empty
                Toast.makeText(getApplicationContext(), "Please insert values to calculate", Toast.LENGTH_SHORT).show();
            }else {
                //Set the integers and do the calculation
                 firstVal = Double.parseDouble(EL.getText().toString());
                secondVal = Double.parseDouble(EL2.getText().toString());
                result = firstVal + secondVal;

                tt.setText(String.valueOf(df.format(result)));
            }
            //Check which button is pressed
        }else if(view.getId()==R.id.subButton) {
            //Get the result field
            tt = (TextView)findViewById(R.id.resultField);
            //Check if the First value and second value fields are empty
            if (firstCheck.equals("") || secondCheck.equals("")) {
                //Let the user know that the fields are empty
                Toast.makeText(getApplicationContext(), "Please insert values to calculate", Toast.LENGTH_SHORT).show();

            }else {
                //Set the integers and do the calculation
                firstVal = Double.parseDouble(EL.getText().toString());
                secondVal = Double.parseDouble(EL2.getText().toString());
                result = firstVal - secondVal;
                tt.setText(String.valueOf(df.format(result)));
            }

            //Check which button is pressed
        }else if(view.getId()==R.id.multButton) {
            //Get the result field
            tt = (TextView)findViewById(R.id.resultField);
            //Check if the First value and second value fields are empty
            if (firstCheck.equals("") || secondCheck.equals("")){
                //Let the user know that the fields are empty
                Toast.makeText(getApplicationContext(), "Please insert values to calculate", Toast.LENGTH_SHORT).show();
            }else {
                //Set the integers and do the calculation
                firstVal = Double.parseDouble(EL.getText().toString());
                secondVal = Double.parseDouble(EL2.getText().toString());
                result =firstVal*secondVal;
                tt.setText(String.valueOf(df.format(result)));
            }
            //Check which button is pressed
    }else if(view.getId()==R.id.divButton) {
            //Get the result field
            tt = (TextView)findViewById(R.id.resultField);
            //Check if the First value and second value fields are empty
            if (firstCheck.equals("") || secondCheck.equals("")){
                //Let the user know that the fields are empty
                Toast.makeText(getApplicationContext(), "Please insert values to calculate", Toast.LENGTH_SHORT).show();
            }else {
                //Set the integers and do the calculation
                firstVal = Double.parseDouble(EL.getText().toString());
                secondVal = Double.parseDouble(EL2.getText().toString());
                result =firstVal/secondVal;

                tt.setText(String.valueOf(df.format(result)));
            }

        }

        }
}

package com.example.catman.javaprojectbheyns;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
/**
 * Created by Bernard Heyns - DV2013-0499 on 2016-10-08.
 * Android Final Semester Project
 */
public class PaintTivity extends AppCompatActivity {

    @Override
    //onCreate default method for the Paintivity app
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //Create a new instance of the paintBrushApp
        paintBrushApp view=new paintBrushApp(this);
        //Set the view
        setContentView(view);
        //Add the content to the view
        addContentView(view.btnEraseAll, view.params);

    }

    @Override
    //When the app gets paused this method is called
    protected void onPause() {

        super.onPause();

        finish();

    }


}

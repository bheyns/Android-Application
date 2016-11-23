package com.example.catman.javaprojectbheyns;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.View;
import android.widget.Button;
/**
 * Created by Bernard Heyns - DV2013-0499 on 2016-10-08.
 * Android Final Semester Project
 */

//paintBrushApp extends a View
public class paintBrushApp extends View {
    //Create new instances of Paint and Path , these two are the most important for the app
    private Paint brush = new Paint();
    private Path path = new Path();
    //Create the erase all button
    public Button btnEraseAll;
    //Create variable for layout parameters
    public LayoutParams params;

    public paintBrushApp(Context context) {
        super(context);
        //Set the properties of the brush stroke
        brush.setAntiAlias(true);
        brush.setColor(Color.BLUE);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeJoin(Paint.Join.ROUND);
        brush.setStrokeWidth(15f);
        //Create the Button to erase the drawing
        btnEraseAll = new Button(context);
         //Set the buttons text
        btnEraseAll.setText("Erase Everything");
        params = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        //Set the layout for the button
        btnEraseAll.setLayoutParams(params);


        //Set a listener for the button when it is clicked
        btnEraseAll.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // reset the path
                path.reset();
                // invalidate the view
                postInvalidate();

            }
        });
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //Get the X and Y coordinates of where the screen is touched to start the stroke
        float pointX = event.getX();
        float pointY = event.getY();

        // Checks for the event that occurs
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(pointX, pointY);

                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(pointX, pointY);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;
        }
        // Force a view to draw.
        postInvalidate();
        return false;

    }
    @Override
    //Draw the canvas with the brush
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, brush);
    }
}
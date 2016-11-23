package com.example.catman.javaprojectbheyns;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;
/**
 * Created by Bernard Heyns - DV2013-0499 on 2016-10-08.
 * Android Final Semester Project
 */

public class resultScreenQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the content of the result screen
        setContentView(R.layout.activity_result_screen_quiz);
        //get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
        //get text view
        TextView t=(TextView)findViewById(R.id.textResult);
        //get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        Log.d("scoore",score+"");
        //display score in the rating bar
        bar.setRating(score);
        //Switch the score to see which message to display to the user
        switch (score)
        {
            case 1:t.setText("You got one right...League of Legends might be for you");
                break;
            case 2: t.setText("Oopsie! Better Luck Next Time!");
                break;
            case 3:
            case 4:t.setText("No too bad !");
                break;
            case 5:
            case 6:t.setText("Hmmmm.. Someone knows a good amount of Dota 2");
                break;
            case 7:t.setText("Hmmmm.. Someone knows a good amount of Dota 2");
                break;
            case 8:
            case 9:t.setText("You must be 6k MMR , Well done !");
                break;
        }
    }
  //  @Override
  //  public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
  //      getMenuInflater().inflate(R.menu.activity_result, menu);
  //      return true;
 //   }
//}
    }


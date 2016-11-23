package com.example.catman.javaprojectbheyns;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
/**
 * Created by Bernard Heyns - DV2013-0499 on 2016-10-08.
 * Android Final Semester Project
 */
public class quizScreens extends AppCompatActivity {
//Declare variables that will be used across the class
    List<questionsClass> quesList;
    int score=0;
    int qid=0;
    questionsClass currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc, rdd;
    Button butNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the content of the view
        setContentView(R.layout.activity_quiz_screens);
        //Instantiate the Database Helper class
        DBHelperQuiz db=new DBHelperQuiz(this);
        //Retrieve all the questions for the quiz
        quesList=db.getAllQuestions();
        //get the current question being displayed
        currentQ=quesList.get(qid);
        //Get all the components so that new values could be assigned
        txtQuestion=(TextView)findViewById(R.id.textView1);
        rda=(RadioButton)findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);
        rdd=(RadioButton)findViewById(R.id.radio4);
        butNext=(Button)findViewById(R.id.nextBut);
        //Set the current quesiton for the quiz
        setQuestionView();

        //Set the listener for the Next button in the quiz
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get the radio group so that I could tell which one the user selected
                RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
                //A simple check to see if the user actually picked an option in the quiz
                if(grp.getCheckedRadioButtonId() == -1){
                    //Let the user know Via Toast that they need to select an option
                    Toast.makeText(getApplicationContext(), "Please select an option", Toast.LENGTH_SHORT).show();
                }else {
                    // Check which option the user chose
                    RadioButton userAnswer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
                    //Get the answer from the radiobutton
                    String ansswer = userAnswer.getText().toString();
                    //Get the answer of the user and display it in the log(Developer helper)
                    Log.d("yourans", currentQ.getANSWER() + " " + ansswer);
                    //Check if the user answered right
                    if (currentQ.getANSWER().equals(ansswer)) {
                        //Increment the score and write it to log
                        score++;
                        Log.d("score", "Your score" + score);

                    }
                    //Check if the question ID is less than 9 , which means there must be a next question to set
                    if (qid < 9) {
                        //Get the question id and set the new question
                        currentQ = quesList.get(qid);
                        setQuestionView();
                    } else {
                        //Create a new intent that moves from the current screen to the result screen.
                        Intent intent = new Intent(quizScreens.this, resultScreenQuiz.class);
                        Bundle b = new Bundle();
                        //Put the score in the Bunndle which is sent to the new activity
                        b.putInt("score", score);
                        intent.putExtras(b);
                        //Start the result activity
                        startActivity(intent);
                         finish();

                    }
                }

            }
        });
    }
    //@Override
    //public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
     //   getMenuInflater().inflate(R.menu.main, menu);
     //   return true;
   // }
    //The setQuestionView method sets the new question for the user
    private void setQuestionView()
    {
        //Set the question and the options for each question
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        rdd.setText(currentQ.getOPTD());
        //get the current radio group and clear the selected one
        RadioGroup grp1 = (RadioGroup) findViewById(R.id.radioGroup1);
        grp1.clearCheck();
       //Increment the question id stating that the current question is asked and should not be asked again.
        qid++;
    }


}

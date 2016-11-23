package com.example.catman.javaprojectbheyns;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bernard Heyns - DV2013-0499 on 2016-10-08.
 * Android Final Semester Project
 */

public class DBHelperQuiz extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    //Set the database Name
    private static final String DATABASE_NAME = "quizDB3";
    // set the table name
    private static final String TABLE_QUEST = "quest";
    // set the table column names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    private static final String KEY_OPTD= "optd"; //option d
    //create a variable of SQLiteDatabase
    private SQLiteDatabase dbase;
    public DBHelperQuiz(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Set the dbase to the actual database
        dbase=db;

        //Set the SQL query that will create the database with the relevant table names
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT )";

        //Execute the query
        db.execSQL(sql);
        //Call the addQuestions method which adds the questions to the database
        addQuestions();
       // db.close();

    }
    //A simple method which creates a question and call the addQuestion method which adds it to the database
    private void addQuestions()
    {
        questionsClass q1=new questionsClass("When does the first night start?","At minute 4:00", "At minute 5:00", "At minute 6:00","At minute 10:00", "At minute 4:00");
        this.addQuestion(q1);
        questionsClass q2=new questionsClass("Pick one set of the neutral creeps that can't spawn in the medium camp", "Centaur camp", "Mud Golems", "Hellbear camp","Wolf camp", "Hellbear camp");
        this.addQuestion(q2);
        questionsClass q3=new questionsClass("How long does observer wards last when placed?","8 minutes", "6 minutes","5 minutes","7 minutes","6 minutes");
        this.addQuestion(q3);
        questionsClass q4=new questionsClass("When can you upgrade the Courier?" ,"At minute 2:00", "At minute 3:00", "At minute 4:00","At the start of the game","At minute 3:00");
        this.addQuestion(q4);
        questionsClass q5=new questionsClass("Which of these heroes has not changed name since their introduction to Dota 2?","Crystal maiden","Necrophos","Windranger","Outworld Devourer","Crystal maiden");
        this.addQuestion(q5);
        questionsClass q6=new questionsClass("Which of these heroes does Pugna claim to have previously owned as a pet?","Viper","Venomancer","Broodmother","Nyx","Viper");
        this.addQuestion(q6);
        questionsClass q7=new questionsClass("Which Strength Hero has the highest Strength gain per level?","Centaur","Pudge","Doom","Treant","Treant");
        this.addQuestion(q7);
        questionsClass q8=new questionsClass("Most of the Heroes start with how much Magical Resistance?","20%","25%","30%","35%","25%");
        this.addQuestion(q8);
        questionsClass q9=new questionsClass("What is the developer of this game(Bernard Heyns)'s favourite hero?","Shadow Fiend","Mirana","Storm Spirit","Tinker","Tinker");
        this.addQuestion(q9);

    }

    @Override
    //Override the default onUpgrade method which takes the database and its old version and updates it to a new one
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }
    // Adding a new question
    public void addQuestion(questionsClass quest) {
        //
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_OPTD, quest.getOPTD());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<questionsClass> getAllQuestions() {
        List<questionsClass> quesList = new ArrayList<questionsClass>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
    //Checking if there is anything in the cursor and looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                //Create new instance of the Getter and setter help class
                questionsClass quest = new questionsClass();
                //Assign the info to variables
                int iy = cursor.getInt(0);
                String que = cursor.getString(1);
                String an = cursor.getString(2);
                String oa = cursor.getString(3);
                String ob = cursor.getString(4);
                String oc = cursor.getString(5);
                String od = cursor.getString(6);
                //Set the values
                quest.setID(iy);
                quest.setQUESTION(que);
                quest.setANSWER(an);
                quest.setOPTA(oa);
                quest.setOPTB(ob);
                quest.setOPTC(oc);
                quest.setOPTD(od);
                //Add each question object to the ArrayList
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
    //A simple rowCount method to check if there is anything in the SQLLite database
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}

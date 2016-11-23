package com.example.catman.javaprojectbheyns;

/**
 * Created by Bernard Heyns - DV2013-0499 on 2016-10-08.
 * Android Final Semester Project
 */

//Create a new helper class called questionsClass
public class questionsClass {
    //Declare the variables that is going to be used as private - NB
    private int ID;
    private String QUESTION;
    private String OPTA;
    private String OPTB;
    private String OPTC;
    private String OPTD;
    private String ANSWER;
    //Create an empty constructor
    public questionsClass() {
    }
    //Create a parameterized constructor that takes all the needed variables
    public questionsClass(String QUESTION, String OPTA, String OPTB, String OPTC, String OPTD,
                          String ANSWER) {
        //Set all the received variables to local variables
        this.OPTA = OPTA;
        this.QUESTION = QUESTION;
        this.OPTB = OPTB;
        this.OPTC = OPTC;
        this.OPTD = OPTD;
        this.ANSWER = ANSWER;
    }
    //The getters and setters for each variable
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getQUESTION() {
        return QUESTION;
    }

    public void setQUESTION(String QUESTION) {
        this.QUESTION = QUESTION;
    }

    public String getOPTA() {
        return OPTA;
    }

    public void setOPTA(String OPTA) {
        this.OPTA = OPTA;
    }

    public String getOPTB() {
        return OPTB;
    }

    public void setOPTB(String OPTB) {
        this.OPTB = OPTB;
    }

    public String getOPTC() {
        return OPTC;
    }

    public void setOPTC(String OPTC) {
        this.OPTC = OPTC;
    }

    public String getOPTD() {
        return OPTD;
    }

    public void setOPTD(String OPTD) {
        this.OPTD = OPTD;
    }

    public String getANSWER() {
        return ANSWER;
    }

    public void setANSWER(String ANSWER) {
        this.ANSWER = ANSWER;
    }
}

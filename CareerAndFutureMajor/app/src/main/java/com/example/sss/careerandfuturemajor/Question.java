package com.example.sss.careerandfuturemajor;

/**
 * Created by Ly Suytry on 8/25/2016.
 */
public class Question {
    private String question;
    private int point;
    public Question(String q,int p){
        this.question=q;
        this.point=p;
    }
    public Question(){

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}

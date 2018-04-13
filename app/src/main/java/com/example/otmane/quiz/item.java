package com.example.otmane.quiz;

/**
 * Created by otmane on 13/04/2018.
 */

public class item {
    private String question , answer;

    public item(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}

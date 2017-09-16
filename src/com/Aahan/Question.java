package com.Aahan;

/**
 * Created by aahan on 24-01-2017.
 */
public class Question {

    String type;
    private boolean correct;
    private String answer;
    String question;

    String getQuestion() {
        return question;
    }

    boolean isCorrect() {
        return correct;
    }

    void setCorrect() {
        this.correct = true;
    }

    Question() {
    }

    void setAnswer(String answer) {
        this.answer = answer;
    }

    String getAnswer() {
        return answer;
    }

    Question(String type, String question) {
        this.type = type;
        this.question = question;
        correct=false;
    }
}

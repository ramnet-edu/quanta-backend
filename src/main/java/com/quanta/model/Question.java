package com.quanta.model;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctAnswer;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getQuestionText() { return questionText; }
    public void setQuestionText(String q) { this.questionText = q; }
    public String getOptionA() { return optionA; }
    public void setOptionA(String a) { this.optionA = a; }
    public String getOptionB() { return optionB; }
    public void setOptionB(String b) { this.optionB = b; }
    public String getOptionC() { return optionC; }
    public void setOptionC(String c) { this.optionC = c; }
    public String getOptionD() { return optionD; }
    public void setOptionD(String d) { this.optionD = d; }
    public String getCorrectAnswer() { return correctAnswer; }
    public void setCorrectAnswer(String ans) { this.correctAnswer = ans; }
    public Test getTest() { return test; }
    public void setTest(Test test) { this.test = test; }
}
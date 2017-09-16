package com.Aahan;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Main implements ActionListener {
    private static String[] subtopics;
    private int score;
    private ArrayList<Question> questions;
    private ArrayList<String> wrongQuestions = new ArrayList<>();
    private int difficulty;
    private int curQuestionNumber = 0;
    private Question x = new Question();
    private int curUser;
    private java.util.List<String> users;
    private JComboBox<String> subTopic;
    private JComboBox<Integer> diffuculty;
    private JTextArea question;
    private JButton generate;
    private JTextArea answer;
    private JButton showAnswer;
    private JTextField username;
    private JPasswordField pass;
    private JButton login;
    private JButton correct;
    private JButton wrong;
    private JButton endQuiz;
    private JButton seeQuestions;
    private JButton saveQs;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Math Question Generator");
        frame.setSize(1200, 1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        subtopics = new String[]{"Quadratic Equations", "Complex Number Multiplication", "Simple Vectors", "Geometric Sum", "Arithmetic Sum", "Logarithms", "Herons Formula", "Indices"};
        Main main = new Main(panel);
        frame.setVisible(true);
        simpleQuadratic.generate(1);
        simpleQuadratic.print();
    }



    private Main(JPanel panel) {
        panel.setLayout(new FlowLayout());
        panel.setBackground(new Color(255, 255, 255));

        Font f = new Font("Calibri", Font.CENTER_BASELINE, 60);

        subTopic = new JComboBox<>(subtopics);
        subTopic.setPreferredSize(new Dimension(1000, 100));
        subTopic.setFont(f);
        subTopic.setMaximumRowCount(6);
        subTopic.setBackground(new Color(255, 255, 255));
        subTopic.setToolTipText("Choose the subtopic for the question");
        subTopic.setEditable(false);
        subTopic.setVisible(false);
        panel.add(subTopic);

        generate = new JButton("Next Question");
        generate.setFont(f);
        generate.setPreferredSize(new Dimension(1000, 150));
        generate.addActionListener(this);
        generate.setActionCommand("generate");
        generate.setBackground(new Color(23, 152, 4));
        generate.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(23, 152, 4)));
        generate.setMultiClickThreshhold(500);
        generate.setVisible(false);
        panel.add(generate);

        question = new JTextArea();
        question.setFont(f);
        question.setEditable(false);
        question.setVisible(false);
        panel.add(question);

        showAnswer = new JButton("Show Answer?");
        showAnswer.setFont(f);
        showAnswer.setPreferredSize(new Dimension(1000, 150));
        showAnswer.addActionListener(this);
        showAnswer.setActionCommand("answer");
        showAnswer.setBackground(new Color(185, 25, 27));
        showAnswer.setVisible(false);
        panel.add(showAnswer);

        answer = new JTextArea("no answer available");
        answer.setFont(f);
        answer.setEditable(false);
        answer.setVisible(false);
        panel.add(answer);

        username = new JTextField();
        username.setPreferredSize(new Dimension(1000, 150));
        username.setEditable(true);
        username.setFont(f);
        username.setText("USERNAME");
        username.setToolTipText("Enter Username");
        panel.add(username);

        pass = new JPasswordField();
        pass.setPreferredSize(new Dimension(1000, 150));
        pass.setEditable(true);
        pass.setFont(f);
        pass.setText("");
        pass.setToolTipText("Enter Password");
        panel.add(pass);

        diffuculty = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        diffuculty.setFont(f);
        diffuculty.setPreferredSize(new Dimension(1000, 100));
        diffuculty.setMaximumRowCount(5);
        diffuculty.setToolTipText("Choose Difficulty");
        panel.add(diffuculty);

        login = new JButton("Login");
        login.setPreferredSize(new Dimension(500, 150));
        login.setFont(f);
        login.addActionListener(this);
        login.setActionCommand("login");
        panel.add(login);

        correct = new JButton("Correct?");
        correct.setPreferredSize(new Dimension(900, 150));
        correct.setFont(f);
        correct.addActionListener(this);
        correct.setActionCommand("correct");
        correct.setVisible(false);
        panel.add(correct);

        wrong = new JButton("Wrong?");
        wrong.setPreferredSize(new Dimension(900, 150));
        wrong.setFont(f);
        wrong.addActionListener(this);
        wrong.setActionCommand("wrong");
        wrong.setVisible(false);
        panel.add(wrong);

        endQuiz = new JButton("END QUIZ");
        endQuiz.setPreferredSize(new Dimension(900, 150));
        endQuiz.setFont(f);
        endQuiz.addActionListener(this);
        endQuiz.setActionCommand("endQuiz");
        endQuiz.setVisible(false);
        panel.add(endQuiz);

        seeQuestions = new JButton("See next question");
        seeQuestions.setPreferredSize(new Dimension(900, 150));
        seeQuestions.setFont(f);
        seeQuestions.addActionListener(this);
        seeQuestions.setActionCommand("seeQ");
        seeQuestions.setVisible(false);
        panel.add(seeQuestions);

        questions = new ArrayList<>();

        saveQs = new JButton("Save Questions");
        saveQs.setPreferredSize(new Dimension(900, 150));
        saveQs.setFont(f);
        saveQs.addActionListener(this);
        saveQs.setActionCommand("save");
        saveQs.setVisible(false);
        panel.add(saveQs);

    }

    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        switch (action) {
            case "login":
                if (checkCredentials()) {
                    topicChoose();
                    //noinspection ResultOfMethodCallIgnored
                    users.get(curUser).substring(9);
                    difficulty = Integer.parseInt(diffuculty.getSelectedItem().toString());
                } else {
                    username.setText("INVALID");
                }
                break;
            case "correct":
            case "wrong":
                System.out.println("here");
                scoreChange(action);
                generate.setEnabled(true);
                break;
            case "endQuiz":
                endQuiz();
                break;
            case "seeQ":
                seeQ();
                if (seeQuestions.getText().equals("All questions done")) {
                    saveQs.setVisible(true);
                    seeQuestions.setVisible(false);
                }
                break;
            case "save":
                saveQuestions();
                break;
            default:
                changeText(action);
                break;
        }
    }

    private void saveQuestions() {
        question.setVisible(false);
        saveQs.setVisible(false);
        ArrayList<String> lines = new ArrayList<>();
        lines.add(users.get(curUser).substring(11));
        for (String wrongQuestion : wrongQuestions) {
            lines.add(wrongQuestion);
        }
        String timeStamp = new SimpleDateFormat("ddMMyy HHmm").format(new java.util.Date());
        System.out.println(timeStamp);
        String pathName;
        pathName = timeStamp + " " + users.get(curUser).substring(0, 4) + ".txt";
        Path file = Paths.get(pathName);
        try {
            Files.write(file, lines, Charset.forName("UTF-8"), StandardOpenOption.CREATE_NEW);
        } catch (IOException e) {
            e.printStackTrace();
        }
        answer.setText("Questions save Successfully");
    }

    private void seeQ() {
        if (!questions.get(curQuestionNumber).isCorrect()) {
            wrongQuestions.add(questions.get(curQuestionNumber).getQuestion());
            wrongQuestions.add(questions.get(curQuestionNumber).getAnswer());
            wrongQuestions.add(" ");
            question.setText(questions.get(curQuestionNumber).getQuestion());
            question.setVisible(true);
            answer.setText(questions.get(curQuestionNumber).getAnswer());
            answer.setVisible(true);
            addQuestionNumber();
        } else {
            addQuestionNumber();
            seeQ();
        }
    }

    private void addQuestionNumber() {
        if (curQuestionNumber < questions.size() - 1)
            curQuestionNumber++;
        else {
            seeQuestions.setText("All questions done");
        }
    }

    private void endQuiz() {
        subTopic.setVisible(false);
        diffuculty.setVisible(false);
        generate.setVisible(false);
        answer.setVisible(false);
        showAnswer.setVisible(false);
        correct.setVisible(false);
        wrong.setVisible(false);
        endQuiz.setVisible(false);
        for (Question question1 : questions) {
            System.out.println(question1.question);
        }
        System.out.println("score: " + score);
        question.setText("Your Score is " + score + " out of " + questions.size() + " questions");
        question.setVisible(true);
        seeQuestions.setVisible(true);
        curQuestionNumber = 0;
    }

    private void scoreChange(String action) {
        if (action.equals("correct")) {
            score++;
            questions.get(curQuestionNumber - 1).setCorrect();
        }
        correct.setVisible(false);
        wrong.setVisible(false);
        showAnswer.setEnabled(false);
        endQuiz.setVisible(true);
    }

    private boolean checkCredentials() {
        String user = username.getText();
        String password = pass.getText();
        users = null;
        try {
            users = Files.readAllLines(Paths.get("users.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert users != null;
        for (int i = 0; i < users.size(); i++) {
            String user1 = users.get(i);
            System.out.println(user1);
            if (user.equals(user1.substring(0, 4))) {
                if (password.equals(user1.substring(5, 10))) {
                    curUser = i;
                    return true;
                }
            }
        }
        return false;
    }

    private void topicChoose() {
        int numberOfQuestions = Integer.parseInt(diffuculty.getSelectedItem().toString());
        System.out.println(numberOfQuestions);
        username.setVisible(false);
        pass.setVisible(false);
        login.setVisible(false);
        diffuculty.setVisible(false);
        subTopic.setVisible(true);
        generate.setVisible(true);
    }

    private void changeText(String buttonPressed) {
        String choice = subTopic.getSelectedItem().toString();
        if (buttonPressed.equals("generate")) {
            answer.setVisible(false);
            generate.setEnabled(false);
            switch (choice) {
                case "Quadratic Equations":
                    simpleQuadratic.generate(difficulty);
                    x = new Question("SQ1", simpleQuadratic.print());
                    break;
                case "Complex Number Multiplication":
                    compMult.generate(difficulty);
                    x = new Question("CM1", compMult.print());
                    break;
                case "Simple Vectors":
                    simpVectors.generate(difficulty);
                    x = new Question("SV1", simpVectors.print());
                    break;
                case "Geometric Sum":
                    geoSum.generate(difficulty);
                    x=new Question("GS1", geoSum.print());
                    break;
                case "Arithmetic Sum":
                    arithSum.generate(difficulty);
                    x=new Question("AS1", arithSum.print());
                    break;
                case "Logarithms":
                    logs.generate(difficulty);
                    x=new Question("LO1", logs.print());
                    break;
                case "Herons Formula":
                    heronsForm.generate(difficulty);
                    x=new Question("HF1", heronsForm.print());
                    break;
                case "Indices":
                    indices.generate(difficulty);
                    x=new Question("IN1", indices.print());
                default:
                    question.setText("Please choose a valid option");
            }
            question.setText(x.question);
            questions.add(x);
            curQuestionNumber++;
            question.setVisible(true);
            showAnswer.setVisible(true);
            showAnswer.setEnabled(true);
            endQuiz.setVisible(false);
        } else if (buttonPressed.equals("answer")) {
            System.out.println(curQuestionNumber + " " + questions.size());
            generate.setEnabled(false);
            switch (questions.get(curQuestionNumber - 1).type) {
                case "SQ1":
                    x.setAnswer(simpleQuadratic.answer());
                    break;
                case "CM1":
                    x.setAnswer(compMult.answer());
                    break;
                case "SV1":
                    x.setAnswer(simpVectors.answer());
                    break;
                case "GS1":
                    x.setAnswer(geoSum.answer());
                    break;
                case "AS1":
                    x.setAnswer(arithSum.answer());
                    break;
                case "LO1":
                    x.setAnswer(logs.answer());
                    break;
                case "HF1":
                    x.setAnswer(heronsForm.answer());
                    break;
                case "IN1":
                    x.setAnswer(indices.answer());
                    break;
            }
            answer.setText(x.getAnswer());
            answer.setVisible(true);
            correct.setVisible(true);
            wrong.setVisible(true);
        }

    }
}
//cosine rule, sine rule
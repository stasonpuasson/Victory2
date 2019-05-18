package com.marchenko.victory2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Quest extends AppCompatActivity {
    private static int numberOfQuestion, correctAns;
    private String[] questions;
    private int[] ansWright;
    private String[][] answers;
    Button ansBtn;
    TextView tvQuesion, tvName;
    RadioButton[] rb;
    RadioGroup rbg;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);
        initialize();
        updateQuestion();
    }

    protected void clickNextQuestion(View view) {
        Toast toast;
        // accept answer
        int answerId = rbg.getCheckedRadioButtonId();

        if(answerId == rb[ansWright[numberOfQuestion]].getId()) {
            toast = Toast.makeText(getApplicationContext(),
                    "Правильна відповідь!", Toast.LENGTH_SHORT);
            correctAns++;
        }
        else {
            toast = Toast.makeText(getApplicationContext(),
                    "Неправильна відповідь!", Toast.LENGTH_SHORT);
        }
        toast.show();


        numberOfQuestion++;
        if(numberOfQuestion >= questions.length) {
            ansBtn.setVisibility(View.INVISIBLE);
        }

        updateQuestion();
    }

    protected void initialize()
    {
        numberOfQuestion = 0;
        correctAns = 0;
        questions = getResources().getStringArray(R.array.questions);
        answers = new String[questions.length][4];
        answers[0] = getResources().getStringArray(R.array.answersQuest1);
        answers[1] = getResources().getStringArray(R.array.answersQuest2);
        answers[2] = getResources().getStringArray(R.array.answersQuest3);
        answers[3] = getResources().getStringArray(R.array.answersQuest4);
        answers[4] = getResources().getStringArray(R.array.answersQuest5);
        ansBtn = (Button) findViewById(R.id.answerBtn);
        tvQuesion = (TextView) findViewById(R.id.textQuestion);
        rbg = (RadioGroup) findViewById(R.id.rbGroup);
        rb = new RadioButton[5];
        rb[0] = (RadioButton) findViewById(R.id.ans1);
        rb[1] = (RadioButton) findViewById(R.id.ans2);
        rb[2] = (RadioButton) findViewById(R.id.ans3);
        rb[3] = (RadioButton) findViewById(R.id.ans4);
        rb[4] = (RadioButton) findViewById(R.id.ans5);
        ansWright = new int[]{2, 3, 0, 1, 1};
        name = getIntent().getStringExtra("name");
        tvName = findViewById(R.id.tvName);
        tvName.setText("Привіт, " + name);
    }

    private void updateQuestion()
    {
        if(numberOfQuestion < questions.length) {
            tvQuesion.setText(questions[numberOfQuestion]);
            for (int i = 0; i < rb.length; i++) {
                if (i >= answers[numberOfQuestion].length) {
                    rb[i].setVisibility(View.INVISIBLE);
                } else {
                    rb[i].setText(answers[numberOfQuestion][i]);
                }
            }
        }
        else
        {
            tvQuesion.setText("Ваш результат: " + (100.0*correctAns)/numberOfQuestion + "%");
            rbg.setVisibility(View.INVISIBLE);
        }
    }
}

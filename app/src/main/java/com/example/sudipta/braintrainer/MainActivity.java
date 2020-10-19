package com.example.sudipta.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button goButton;
    int locationCorrectAnswer;
    TextView resultTextView ;
    int score = 0;
    int numberOfQuestion = 0;
    TextView scoreTextView;
    Button button0,button1,button2,button3;
    TextView sumTextView;
    ArrayList<Integer>answer = new ArrayList<Integer>();

    public void chooseAnswer(View view){
       if (Integer.toString(locationCorrectAnswer).equals(view.getTag().toString())){
           resultTextView.setText("Correct!");
           score++;
       } else {
          resultTextView.setText("Wrong:");
       }
       numberOfQuestion++;
       scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestion));
       newQuestion();
    }

    public void start(View view){
        goButton.setVisibility(view.INVISIBLE);
    }

    public void newQuestion(){
        Random rand = new Random();
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(Integer.toString(a)+ "+" +Integer.toString(b));

        locationCorrectAnswer = rand.nextInt(4);

        for (int i=0; i<4; i++){
            if (i == locationCorrectAnswer) {
                answer.add(a+b);
            } else {
                int wrongAnswer = rand.nextInt(41);

                while (wrongAnswer == a+b){
                    wrongAnswer = rand.nextInt(41);
                }
                answer.add(wrongAnswer);
            }
        }
        button0.setText(Integer.toString(answer.get(0)));
        button1.setText(Integer.toString(answer.get(1)));
        button2.setText(Integer.toString(answer.get(2)));
        button3.setText(Integer.toString(answer.get(3)));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goButton = findViewById(R.id.goButton);
        sumTextView=findViewById(R.id.sumTextView);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        resultTextView = findViewById(R.id.resultTextView);
        scoreTextView = findViewById(R.id.scoreTextView);

        newQuestion();

    }
}
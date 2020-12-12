package com.example.domznaniy2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MathActivity extends AppCompatActivity {

    public TextView countLabel;
    public TextView questionLabel;
    public Button answer1;
    public Button answer2;
    public Button answer3;
    public Button answer4;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<> ();

    String quizData[][] = {
            // {"Question", "Right Answer", "choise1", "choise2", "choise3"}
            {"Приведите подобные слагаемые: 4x + 5 + 11x - 8", "-15x - 13", "-12x + 16", "15x - 3", "7x - 3" },
            {"Раскройте скобки: -5x(y - 2z + 5)", "-5xy + 10xz - 25x", " y - 2z + 5 ", " –5ху – 10xz + 25x", " –5ху + 10xz – 25х" },
            {"Раскройте скобки и приведите подобные слагаемые в выражении (1,3а – 4) – (6 + 2,7a).", "–10 – 4a", "4a – 2", "–1,4а – 10", "4a – 10"},
            {"Преобразуйте выражение 2,5(–2х + 4y – z) в тождественно равное", "–5х – 10у + z", "5х + 10y – z", "–5х + I0y – 2,5z", "–5х + 10у – 2,5"}
    };

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_math );

        countLabel = findViewById ( R.id.countLabel );
        questionLabel = findViewById ( R.id.questionLabel );
        answer1 = findViewById ( R.id.answer1 );
        answer2 = findViewById ( R.id.answer2 );
        answer3 = findViewById ( R.id.answer3 );
        answer4 = findViewById ( R.id.answer4 );

        for (int i=0; i < quizData.length ; i++) {
            ArrayList<String> tmpArray = new ArrayList<> ();
            tmpArray.add ( quizData[i][0] );  // question
            tmpArray.add ( quizData[i][1] );  // right answer
            tmpArray.add ( quizData[i][2] );  // choice 1
            tmpArray.add ( quizData[i][3] );  // choice 2
            tmpArray.add ( quizData[i][4] );  // choice 3

            quizArray.add ( tmpArray );

        }
        showNextQuiz();
    }

    public void showNextQuiz(){

        if (quizArray.isEmpty ()) {
            Intent intent=new Intent ( MathActivity.this, ActivityResultForMath.class );
            String a=String.valueOf ( rightAnswerCount );
            intent.putExtra ( "key_two", a );
            startActivity ( intent );
            return;
        }

        // Обновление QuizCountLabel
        countLabel.setText ( "Q" + quizCount );

        // Генерация рандомного вопроса от 0 до 4
        Random random = new Random ();
        int randomNum = random.nextInt (quizArray.size ());

        // Выбор одного из вопросов
        ArrayList<String> quiz = quizArray.get ( randomNum );

        // Установка вопроса и правильного ответа
        questionLabel.setText ( quiz.get ( 0 ) );
        rightAnswer = quiz.get ( 1 );

        // Удалить вопрос и перемешать варианты ответов
        quiz.remove ( 0 );
        Collections.shuffle ( quiz );

        // Установка вариантов ответов
        answer1.setText ( quiz.get ( 0 ) );
        answer2.setText ( quiz.get ( 1 ) );
        answer3.setText ( quiz.get ( 2 ) );
        answer4.setText ( quiz.get ( 3 ) );

        // Удалить рандомный вариант
        quizArray.remove ( randomNum );
    }

    // Правильный ответ
    public void checkAnswer( View view ) {

        Button answerBtn=findViewById ( view.getId () );
        String btnText=answerBtn.getText ().toString ();

        if (btnText.equals ( rightAnswer )) {
            rightAnswerCount=rightAnswerCount + 2;
        }
        showNextQuiz ();
    }


}
package com.example.domznaniy2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RusActivity extends AppCompatActivity {

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
            {"Укажите в каком предложении присутствует причастие:", "он выиграл в турнире,взяв первое место", "мой брат вышел в магазин", "он спроектировал самолёт", "Андрей сказал ему «Не возвращайся больше домой!»" },
            {"В каком слове допущена ошибка в транскрипции?", "[с'н'эк]"," [п'эс'инка] ", " [б'эр'ик]", "[б'ир'ига]" },
            {"Какое слово не является родственным?", "положение", "излагать", "налаживать", "полагать "},
            {"Какое существительное не относится ко II склонению?", "брон", "туш", " олень", "лунь "}
    };

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_rus );

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

}
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

public class SocietyActivity extends AppCompatActivity {

    public TextView countLabel;
    public TextView questionLabel;
    public Button answer1;
    public Button answer2;
    public Button answer3;
    public Button answer4;

    private String rightAnswer;
    private int rightAnswerCount=0;
    private int quizCount=2;
    private int randomNum;


    ArrayList<ArrayList<String>> quizArray=new ArrayList<> ();

    String quizData[][]={
            // {"Question", "Right Answer", "choise1", "choise2", "choise3"}
            {"Кто защищает права подсудимого и защищает его интересы", "прокурор", "адвокат", "частный детектив", "нотариус"},
            {"Особые действия,  совершаемые специальными лицами в строгой последовательности:", "ритуал", "обряд", "привычка", "закон"},
            {"Мера воздействия, применяемая к нарушителям установленных норм, правил:", "право", "норма", "порядок", "санкция"},
            {"Ниже приведен перечень терминов.Все они за исключением одного, соответствуют понятию \"участники судебного процесса\". Укажите термин, не относящийся к данному понятию", "адвокат", "нотариус", "прокурор", "судья"}
    };

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_society );

        countLabel=findViewById ( R.id.countLabel );
        questionLabel=findViewById ( R.id.questionLabel );
        answer1=findViewById ( R.id.answer1 );
        answer2=findViewById ( R.id.answer2 );
        answer3=findViewById ( R.id.answer3 );
        answer4=findViewById ( R.id.answer4 );

        for (int i=0; i < quizData.length; i++) {
            ArrayList<String> tmpArray=new ArrayList<> ();
            tmpArray.add ( quizData[i][0] );  // question
            tmpArray.add ( quizData[i][1] );  // right answer
            tmpArray.add ( quizData[i][2] );  // choice 1
            tmpArray.add ( quizData[i][3] );  // choice 2
            tmpArray.add ( quizData[i][4] );  // choice 3

            quizArray.add ( tmpArray );

        }
        showNextQuiz ();
    }

    public void showNextQuiz() {

        if (quizArray.isEmpty ()) {
            Intent intent=new Intent ( SocietyActivity.this, ActivityForResultSocity.class );
            String a=String.valueOf ( rightAnswerCount );
            intent.putExtra ( "key_four", a );
            startActivity ( intent );
            return;
        }

        // Обновление QuizCountLabel
        countLabel.setText ( "Q" + quizCount );

        // Генерация рандомного вопроса от 0 до 4
        Random random=new Random ();
        randomNum=random.nextInt ( quizArray.size () );

        // Выбор одного из вопросов
        ArrayList<String> quiz=quizArray.get ( randomNum );

        // Установка вопроса и правильного ответа
        questionLabel.setText ( quiz.get ( 0 ) );
        rightAnswer=quiz.get ( 1 );

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
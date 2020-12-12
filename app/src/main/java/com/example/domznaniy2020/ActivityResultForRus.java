package com.example.domznaniy2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityResultForRus extends AppCompatActivity {

    TextView textGet;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_result_for_rus );

        sharedPreferences = getApplicationContext ().getSharedPreferences ( "NICE", MODE_PRIVATE );

        textGet = findViewById ( R.id.textGet );

        Intent intent = getIntent ();
        String getData = intent.getStringExtra ( "key_one" );
        textGet.setText ( "Ваш результат: " + getData );
        saveResult ( getData );
    }

    public void saveResult(String getData){
        SharedPreferences.Editor editor = sharedPreferences.edit ();
        editor.putString ( "key_save", getData );
        editor.apply ();
    }

}
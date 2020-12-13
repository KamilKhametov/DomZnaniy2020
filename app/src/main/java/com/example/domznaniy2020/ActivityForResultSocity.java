package com.example.domznaniy2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityForResultSocity extends AppCompatActivity {

    TextView textGetSociety;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_for_result_socity );

        sharedPreferences = getApplicationContext ().getSharedPreferences ( "NICE_FOUR", MODE_PRIVATE );

        textGetSociety= findViewById ( R.id.textGetSociety );

        Intent intent = getIntent ();
        String getData = intent.getStringExtra ( "key_four" );
        textGetSociety.setText ( "Ваш результат: " + getData );
        saveResult ( getData );
    }

    public void saveResult(String getData){
        SharedPreferences.Editor editor = sharedPreferences.edit ();
        editor.putString ( "key_save", getData );
        editor.apply ();
    }
}
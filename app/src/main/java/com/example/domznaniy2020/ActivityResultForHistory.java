package com.example.domznaniy2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityResultForHistory extends AppCompatActivity {

    TextView textGetHistory;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_result_for_history );

        sharedPreferences = getApplicationContext ().getSharedPreferences ( "NICE_THREE", MODE_PRIVATE );

        textGetHistory= findViewById ( R.id.textGetHistory );

        Intent intent = getIntent ();
        String getData = intent.getStringExtra ( "key_three" );
        textGetHistory.setText ( "Ваш результат: " + getData );
        saveResult ( getData );
    }

    public void saveResult(String getData){
        SharedPreferences.Editor editor = sharedPreferences.edit ();
        editor.putString ( "key_save", getData );
        editor.apply ();
    }
}
package com.example.domznaniy2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityResultForMath extends AppCompatActivity {

    TextView textGetMath;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_result_for_math );

        sharedPreferences = getApplicationContext ().getSharedPreferences ( "NICE_TWO", MODE_PRIVATE );

        textGetMath= findViewById ( R.id.textGetMath );

        Intent intent = getIntent ();
        String getData = intent.getStringExtra ( "key_two" );
        textGetMath.setText ( "Ваш результат: " + getData );
        saveResult ( getData );
    }

    public void saveResult(String getData){
        SharedPreferences.Editor editor = sharedPreferences.edit ();
        editor.putString ( "key_save", getData );
        editor.apply ();
    }
}

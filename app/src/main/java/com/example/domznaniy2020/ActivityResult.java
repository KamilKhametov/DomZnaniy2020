package com.example.domznaniy2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityResult extends AppCompatActivity {

    TextView textGet;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_result );

        textGet = findViewById ( R.id.textGet );

        Intent intent = getIntent ();
        String getData = intent.getStringExtra ( "key_one" );
        textGet.setText ( getData );
    }
}
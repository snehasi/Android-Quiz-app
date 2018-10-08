package com.example.sneha.quizme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class FirstScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

    }

    public void onClick(View v){
        Intent tt = new Intent(this, SecondActivity.class);
        startActivity(tt);

    }
}

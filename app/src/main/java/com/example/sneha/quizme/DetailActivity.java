package com.example.sneha.quizme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
//third screen has been connected
public class DetailActivity extends AppCompatActivity {
    TextView tv;
    //DatabaseHelper dbb= new DatabaseHelper(this);
    //dbb.open();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //tv=findViewById(R.id.dip);
    }
}

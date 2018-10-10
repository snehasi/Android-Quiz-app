package com.example.sneha.quizme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

//third screen has been connected
public class DetailActivity extends AppCompatActivity {
    TextView tv;
    //DatabaseHelper dbb= new DatabaseHelper(this);
    //dbb.open();
    public int position = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        position = getIntent().getIntExtra("position", -1);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


//        Bundle bundle = new Bundle();
//        bundle.putInt("position", position);
//// set Fragmentclass Arguments
//        DetailFragment fragobj = new DetailFragment();
//        fragobj.setArguments(bundle);


        //int position = getIntent().getIntExtra("keyname", -1);

        //Bundle bundle = new Bundle();
       // savedInstanceState.putInt("position", position);

        //DetailFragment f = new DetailFragment();
       // f.setArguments(savedInstanceState);

        //tv=findViewById(R.id.dip);
    }

    public int getst(){
        //Log.e("DetailActivity", )
        return position;
    }

    public void setst(int x){
        position = x;
    }
}

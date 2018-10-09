package com.example.sneha.quizme;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.content.Context;
import android.database.Cursor;

import java.util.Arrays;
import java.util.List;


public class SecondActivity extends AppCompatActivity {
    private RecyclerView recycler_view;
    private RecyclerView.LayoutManager layoutmanager;
    //final Context context = this;
    private List<String> ll;
    private MyAdapter ad;
    private Context c;
    //change list here
    private myDatabaseHelper databaseHelper;

    SQLiteOpenHelper oh;
    SQLiteDatabase db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recycler_view=findViewById(R.id.recycler_view);
        layoutmanager = new LinearLayoutManager(this);
        recycler_view.setLayoutManager(layoutmanager);

        databaseHelper  = new myDatabaseHelper(this);
        //databaseHelper.open();
        ll=databaseHelper.getquestion(); //should return a List<String>


        //ll= Arrays.asList(getResources().getStringArray(R.array.questions)); //chang
        ad=new MyAdapter(ll,this);
        //recycler_view.setHasFixedSize(true);
        recycler_view.setAdapter(ad);





    }
}


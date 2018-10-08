package com.example.sneha.quizme;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="questions.db";
    public static final String TABLE_QUES="question";
    public static final String TABLE_ANS="savedanswer";

    //col for q
    public static final String COL_QUES_1="ID";
    public static final String COL_QUES_2="ques";

    //col for and
    public static final String COL_ANS_1="ID";
    public static final String COL_ANS_2="ans";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +TABLE_QUES+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, ques TEXT)");
        db.execSQL("CREATE TABLE " +TABLE_ANS+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, ans TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUES);
        onCreate(db);

    }
}

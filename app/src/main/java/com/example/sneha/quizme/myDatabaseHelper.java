package com.example.sneha.quizme;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class myDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="questions.db";
    public static final String TABLE_QUES="question";
    public static final String TABLE_ANS="savedanswer";

    //col for q
    public static final String COL_QUES_1="ID";
    public static final String COL_QUES_2="ques";

    //col for and
    public static final String COL_ANS_1="ID";
    public static final String COL_ANS_2="ans";

    private final Context context;


    public myDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +TABLE_QUES+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, ques TEXT)");
        db.execSQL("CREATE TABLE " +TABLE_ANS+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, ans TEXT)");

        ContentValues val = new ContentValues();
        Resources r = context.getResources();
        String[] tbr = r.getStringArray(R.array.questions);
        int l = tbr.length;
        for(int j=0;j<l;j++){
            val.put("ques", tbr[j]);
            db.insert(TABLE_QUES,null,val);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUES);
        onCreate(db);

    }

    public String[] getquestion() {

        final String TABLE_NAME = "question";

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        String[] data      = null;

        if (cursor.moveToFirst()) {
            do {
                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();
        return data;
    }
}

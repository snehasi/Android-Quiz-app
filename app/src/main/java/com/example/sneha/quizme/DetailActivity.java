package com.example.sneha.quizme;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;

import static android.content.ContentValues.TAG;

//third screen has been connected
public class DetailActivity extends AppCompatActivity implements DetailFragment.OnFragmentInteractionListener {
    TextView tv;
    //DatabaseHelper dbb= new DatabaseHelper(this);
    //dbb.open();
    public int position = 0;
    public myDatabaseHelper databaseHelper;
    public boolean xt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        position = getIntent().getIntExtra("position", -1);
        databaseHelper  = new myDatabaseHelper(this);

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


    public void testFunction()
    {
        Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();
//        Log.d("gah", "guhguhguh");
    }

    public boolean checkfalse() {
        //boolean x;
        Toast.makeText(this, "false", Toast.LENGTH_SHORT).show();
        xt= false;
        return xt;
    }


    public boolean checktrue() {
        Toast.makeText(this, "True", Toast.LENGTH_SHORT).show();
        xt= true;
        return xt;
    }


    public void AddData() {
        Toast.makeText(this, "save", Toast.LENGTH_SHORT).show();
        if(xt==false){
            databaseHelper.insertd("False");

        }
        if(xt==true){
            databaseHelper.insertd("True");
        }
    }

    public void submittocsv() {
        //boolean x;
        Toast.makeText(this, "submit", Toast.LENGTH_SHORT).show();
        dbtocsv();
    }

    public void dbtocsv()
    {
        myDatabaseHelper dbh = new myDatabaseHelper(this);
        File exportDir = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "");
        Log.d("checklocation", exportDir.getPath());
        if (!exportDir.exists())
        {
            exportDir.mkdirs();
        }

        File file = new File(exportDir, "csvname.csv");
        try
        {
            file.createNewFile();
            Log.d("checklocation", file.getAbsolutePath());
            CSVWriter csvWrite = new CSVWriter(new FileWriter(file));
            SQLiteDatabase db = dbh.getReadableDatabase();
            Cursor curCSV = db.rawQuery("SELECT * FROM savedanswer",null);
            csvWrite.writeNext(curCSV.getColumnNames());
            while(curCSV.moveToNext())
            {
                //Which column you want to exprort
                String arrStr[] ={curCSV.getString(0),curCSV.getString(1), curCSV.getString(2)};
                csvWrite.writeNext(arrStr);
            }
            csvWrite.close();
            curCSV.close();
        }
        catch(Exception sqlEx)
        {
            Log.e("MainActivity", sqlEx.getMessage(), sqlEx);
        }
    }








}

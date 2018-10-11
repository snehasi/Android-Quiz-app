package com.example.sneha.quizme;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;

import static android.content.ContentValues.TAG;
import static com.example.sneha.quizme.myDatabaseHelper.DATABASE_NAME;
import static com.example.sneha.quizme.myDatabaseHelper.TABLE_ANS;
import static com.example.sneha.quizme.myDatabaseHelper.TABLE_QUES;

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
            databaseHelper.insertd(getst(), "False");

        }
        if(xt==true){
            databaseHelper.insertd(getst(), "True");
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
        File exportDir = new File(Environment.getExternalStorageDirectory(), "");
        Log.d("checklocation", exportDir.getPath());
        if (!exportDir.exists())
        {
            exportDir.mkdirs();
        }

        File file = new File(exportDir, "dbb.csv");
        try
        {   //file.mkdirs();
            int writeExternalStoragePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
// If do not grant write external storage permission.
            if(writeExternalStoragePermission!= PackageManager.PERMISSION_GRANTED)
            {
                // Request user to grant write external storage permission.
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
            file.createNewFile(); //error here
            //file.setDestinationInExternalFilesDir(this, getFilesDir().toString(), "song_15.mp3");
            Log.d("checklocation", file.getAbsolutePath());


            CSVWriter csvWrite = new CSVWriter(new FileWriter(file));


            SQLiteDatabase db = dbh.getReadableDatabase();

            Cursor curCSV = db.rawQuery("SELECT * FROM "+ TABLE_ANS ,null);
            if(curCSV.moveToFirst()){
                csvWrite.writeNext(curCSV.getColumnNames());

                do{
                    //Which column you want to exprort
                    String arrStr[] ={curCSV.getString(0),curCSV.getString(1)};
                    csvWrite.writeNext(arrStr);
                }while(curCSV.moveToNext());
                csvWrite.close();
                curCSV.close();
            }

//            Cursor curCSV2 = db.rawQuery("SELECT * FROM "+ TABLE_ANS ,null);
//            if(curCSV2.moveToFirst()){
//                csvWrite.writeNext(curCSV2.getColumnNames());
//
//                do{
//                    //Which column you want to exprort
//                    String arrStr2[] ={curCSV2.getString(0),curCSV2.getString(1)};
//
//                    csvWrite.writeNext(arrStr2);
//                }while(curCSV2.moveToNext());
//                csvWrite.close();
//                curCSV2.close();
//            }




//            if (curCSV ==null) {
//                Log.d("whateven", "null query from db");
//            }
//            else{
//                Log.d("whateven", "not null query from db");
//            }


        }
        catch(Exception sqlEx)
        {
            Log.e("uh", sqlEx.getMessage(), sqlEx);
        }
    }








}

package com.example.sneha.quizme;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.w3c.dom.Text;
import android.widget.TextView;
import android.content.Context;
import android.content.Intent;
import java.util.*;

import java.util.List;

import static android.content.ContentValues.TAG;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myviewholder>{

    private List<String> ll;
    private Context c;
    private myDatabaseHelper databaseHelper;

    //add
    private RecyclerView rv;
    private View v;
    private Context context;
    private myviewholder mcv;
    public int x;
    //public String testing;


    public MyAdapter(List<String> ll, Context c){
        this.ll = ll;
        this.c=c;
        this.x=x;

    }

    public void setNumber(int y) {
        this.x = y;
    }

    @Override
    public myviewholder onCreateViewHolder( ViewGroup parent, int i) {

        TextView textv = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.line_layout,parent,false);
        myviewholder myv =new myviewholder(textv,c,ll);

        return myv;
    }


    @Override
    public void onBindViewHolder(myviewholder viewHolder, int i) {
        viewHolder.questionList.setText(ll.get(i));

        //this.x= viewHolder.getAdapterPosition();

        //x.setNumber()
        //this.x=mcv.position;
    }


    @Override
    public int getItemCount() {
        return ll.size();
    }

    //for finding out item id in recycler view list ono




    public static class myviewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView questionList;
        Context c;
        List<String> ll;
        public int position;
        //MyAdapter mk = new MyAdapter(ll,c);

        public myviewholder(TextView itemView, Context c, List<String> ll) {
            super(itemView);
            questionList=itemView;
            itemView.setOnClickListener(this);
            this.c=c;
            this.ll=ll;
            //this.mk=mk;
        }

        @Override
        public void onClick(View v) {
            //myDatabaseHelper.openDataBas
            //this.position = v.getAdapterPosition();

            position=this.getAdapterPosition();
            Log.d(TAG, "onClick " + position); //working
            //now make it to x
            //mk.x=position;

            Intent intent = new Intent(c, DetailActivity.class);
            //String[] arr = ll.toArray(new String[0]);
            ArrayList<String> m =new ArrayList<String>(ll);
            intent.putStringArrayListExtra( "test", m);
            intent.putExtra("position",position);
            c.startActivity(intent);

            //return position;


        }





    }
}

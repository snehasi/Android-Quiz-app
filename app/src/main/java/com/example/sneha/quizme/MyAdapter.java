package com.example.sneha.quizme;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.w3c.dom.Text;
import android.widget.TextView;
import android.content.Context;
import android.content.Intent;
import java.util.*;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myviewholder>{

    private List<String> ll;
    private Context c;


    public MyAdapter(List<String> ll, Context c){
        this.ll = ll;
        this.c=c;
    }



    @Override
    public myviewholder onCreateViewHolder( ViewGroup parent, int i) {

        TextView textv = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.line_layout,parent,false);
        myviewholder myv =new myviewholder(textv,c,ll);

        return myv;
    }


    @Override
    public void onBindViewHolder(@NonNull myviewholder viewHolder, int i) {
        viewHolder.questionList.setText(ll.get(i));
    }


    @Override
    public int getItemCount() {
        return ll.size();
    }


    public static class myviewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView questionList;
        Context c;
        List<String> ll;

        public myviewholder(TextView itemView, Context c, List<String> ll) {
            super(itemView);
            questionList=itemView;
            itemView.setOnClickListener(this);
            this.c=c;
            this.ll=ll;
        }

        @Override
        public void onClick(View v) {
            //myDatabaseHelper.openDataBas
            //myDatabaseHelper data  = new myDatabaseHelper(MyAdapter.this);

            Intent intent = new Intent(c, DetailActivity.class);
            //String[] arr = ll.toArray(new String[0]);
            ArrayList<String> m =new ArrayList<String>(ll);
            intent.putStringArrayListExtra( "test", m);
            c.startActivity(intent);


        }
    }
}

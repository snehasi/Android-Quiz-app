package com.example.sneha.quizme;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import static android.content.ContentValues.TAG;


public class DetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    //changed
    private myDatabaseHelper databaseHelper;

    //buttons
    Button tb,fb,sb,subb;

    private MyAdapter myadap;
    SQLiteOpenHelper oh;
    SQLiteDatabase db;
    Cursor cursor;
    private List<String> ll;
    public int position;
    private MyAdapter ad;
    private Context c;
    private TextView textview;
    private LayoutInflater inflater;
    private ViewGroup container;
    private View vvv;
    public boolean xt;
    //accessing inner class from another class



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DetailFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


        //changed then left
        //setContentView(R.layout.activity_second);
        //View v = onCreateView(inflater, container, savedInstanceState);
        //textview=(TextView)findViewById(R.id.fragment_header);
        //layoutmanager = new LinearLayoutManager(this);
        //recycler_view.setLayoutManager(layoutmanager);
        //databaseHelper  = new myDatabaseHelper(this.getActivity());
        //databaseHelper.open();
        //ll=databaseHelper.getquestion(); //should return a List<String>
        //ll= Arrays.asList(getResources().getStringArray(R.array.questions)); //chang
        //ad=new MyAdapter(ll,this.getActivity());
        //recycler_view.setHasFixedSize(true);
        //recycler_view.setAdapter(ad);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_detail, container, false);
        TextView tv=v.findViewById(R.id.fragment_header);
        databaseHelper  = new myDatabaseHelper(this.getActivity());
        myadap = new MyAdapter(ll,this.getActivity());
        ll=databaseHelper.getquestion();


        DetailActivity my=(DetailActivity) getActivity();
        position = my.getst();
        Log.d(TAG, "checkMe " + position); //Notworking


        String tex = ll.get(position);
        tv.setText(tex);

        tb=(Button) v.findViewById(R.id.truebutton);
        fb=(Button) v.findViewById(R.id.falsebutton);
        sb=(Button) v.findViewById(R.id.savebutton);
        subb=(Button) v.findViewById(R.id.submitbutton);
        checktrue();
        checkfalse();
        AddData();

        return v;

    }


    public boolean checktrue() {
        //boolean x;
        tb.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        xt= true;

                    }
                }
        );
        return xt;
    }

    public boolean checkfalse() {
        //boolean x;
        tb.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        xt= false;

                    }
                }
        );
        return xt;
    }


    public void AddData() {
        sb.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if(xt==true){
                            databaseHelper.insertd("True");
                        }
                        if(xt==false){
                            databaseHelper.insertd("False");
                        }

                    }
                }
        );
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

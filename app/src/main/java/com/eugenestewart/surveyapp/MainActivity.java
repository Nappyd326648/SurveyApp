package com.eugenestewart.surveyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



//saves total votes
    int myes;
    int mno;

    private final static String yes="yes";
    private final static String no="no";

    @Override
    protected void onSaveInstanceState(Bundle outBundle){
        outBundle.putInt(yes,myes);
        outBundle.putInt(no,mno);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            myes = savedInstanceState.getInt(yes);
            mno = savedInstanceState.getInt(no);

        }


// Assigns buttons to activity_main,xml
        Button yes =(Button) findViewById(R.id.answerYes);
        Button no =(Button) findViewById(R.id.answerNo);
        final Button total =(Button)findViewById(R.id.total);
        Button reset = (Button)findViewById(R.id.reset);
//add listeners
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myes=myes+1;
            }
        });
        no.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mno=mno+1;
            }
        });
        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Yes total: "+ myes,Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this,"No total: "+ mno,Toast.LENGTH_LONG).show();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mno=0;
                myes=0;
            }
        });

    }
}

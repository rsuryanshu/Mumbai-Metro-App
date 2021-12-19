package com.sahanidevelopers.mumbaimetro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FareListActivity extends AppCompatActivity {

    int count, change;
    ArrayAdapter<String> adapter;
    ListView lst;
    TextView s1, c1, f1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fare_list);

        lst = (ListView)findViewById(R.id.listroute);
        s1 = (TextView) findViewById(R.id.sta);
        //c1 = (TextView) findViewById(R.id.chan);
        f1 = (TextView) findViewById(R.id.f);
        ArrayList<String> list = (ArrayList<String>) getIntent().getSerializableExtra("ARRAYLIST");
        adapter=new ArrayAdapter<String>(FareListActivity.this,android.R.layout.simple_list_item_1,list);

        lst.setAdapter(adapter);

        count = (Integer)getIntent().getIntExtra("COUNT",0);
        //change = (Integer)getIntent().getIntExtra("CHANGE",0);

        int x= count+2;
        int fr=0;
        s1.setText("Stations ⇋ "+(count+2));
//        c1.setText(""+change);
        if(x==2)
            fr=10;
        if(x==3)
            fr=20;
        if(x==4||x==5)
            fr=20;
        if(x==6||x==7||x==8||x==9)
            fr=30;
        if(x==10||x==11||x==12)
            fr=40;
        f1.setText(""+fr);

    }
}

package com.sahanidevelopers.mumbaimetro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class SelectLocationLine2Activity extends AppCompatActivity {

    String direction;
    ListView lstView;

    ListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_location_line2);

        Intent intent =getIntent();

        direction = intent.getStringExtra("DIRECTION");
        lstView =findViewById(R.id.lstView);

        if(direction.equals("dahisar"))
        {
            String[] stations = getResources().getStringArray(R.array.mandale_dahisar);
            listViewAdapter = new ListViewAdapter(this, stations);
            lstView.setAdapter(listViewAdapter);
        }
        if(direction.equals("mandale"))
        {
            String[] stations = getResources().getStringArray(R.array.dahisar_mandale);
            listViewAdapter = new ListViewAdapter(this, stations);
            lstView.setAdapter(listViewAdapter);
        }


        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SelectLocationLine2Activity.this, "Schedule Not Available", Toast.LENGTH_LONG).show();
            }
        });
    }
}

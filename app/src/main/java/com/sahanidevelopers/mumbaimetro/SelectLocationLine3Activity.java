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

public class SelectLocationLine3Activity extends AppCompatActivity {

    String direction;
    ListView lstView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_location_line3);

        Intent intent =getIntent();

        direction = intent.getStringExtra("DIRECTION");
        lstView =findViewById(R.id.lstView);

        if(direction.equals("aarey"))
        {
            String[] stations = getResources().getStringArray(R.array.cuffeparade_aarey);
            List<String> staList = Arrays.asList(stations);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, staList);


            lstView.setAdapter(adapter);
        }
        if(direction.equals("cuffeparade"))
        {
            String[] stations = getResources().getStringArray(R.array.aarey_cuffeparade);
            List<String> staList = Arrays.asList(stations);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, staList);


            lstView.setAdapter(adapter);
        }


        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SelectLocationLine3Activity.this, "Schedule Not Available", Toast.LENGTH_LONG).show();
            }
        });
    }
}

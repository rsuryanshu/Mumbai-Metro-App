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

public class SelectLocationLine1Activity extends AppCompatActivity {

    String direction;
    ListView lstView;

    ListViewAdapter listViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_location_line1);

        Intent intent =getIntent();

        direction = intent.getStringExtra("DIRECTION");
        lstView =findViewById(R.id.lstView);

        if(direction.equals("versova"))
        {
            String[] stations = getResources().getStringArray(R.array.versova_ghatkopar);
            listViewAdapter = new ListViewAdapter(this, stations);
            lstView.setAdapter(listViewAdapter);
        }
        if(direction.equals("ghatkopar"))
        {
            String[] stations = getResources().getStringArray(R.array.ghatkopar_versova);
            listViewAdapter = new ListViewAdapter(this, stations);
            lstView.setAdapter(listViewAdapter);
        }


        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        if(direction.equals("versova"))
                        {
                            Intent i = new Intent(SelectLocationLine1Activity.this, ScheduleLine1Activity.class);
                            String dir = direction;
                            i.putExtra("POSITION", position);
                            i.putExtra("DIRECTION",dir);
                            startActivity(i);
                        }
                        if(direction.equals("ghatkopar"))
                        {
                            Intent i = new Intent(SelectLocationLine1Activity.this, ScheduleLine1Activity.class);
                            String dir = direction;
                            i.putExtra("POSITION", position);
                            i.putExtra("DIRECTION",dir);
                            startActivity(i);
                        }
                        break;
                    case 11:
                        Toast.makeText(SelectLocationLine1Activity.this, "No Trains Available", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });





    }
}

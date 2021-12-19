package com.sahanidevelopers.mumbaimetro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class ScheduleLine1Activity extends AppCompatActivity {

    ListView listView;

    ListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_line1);

        listView = findViewById(R.id.traintiming);


        Intent intent = getIntent();

        int position;
        String direction;
        position = intent.getIntExtra("POSITION",0);
        direction = intent.getStringExtra("DIRECTION");

        //getSupportActionBar().setTitle(""+direction);

        switch (position){
            case 0:
                if (direction.equals("versova")){
                    String[] stations = getResources().getStringArray(R.array.ghatkopar_to_versova);
                    listViewAdapter = new ListViewAdapter(this, stations);
                    listView.setAdapter(listViewAdapter);
                }
                if (direction.equals("ghatkopar")){
                    String[] stations = getResources().getStringArray(R.array.versova_to_ghatkopar);
                    listViewAdapter = new ListViewAdapter(this, stations);
                    listView.setAdapter(listViewAdapter);
                }
                break;
            case 1:
                if (direction.equals("versova")){
                    String[] stations = getResources().getStringArray(R.array.jagrutinagar_to_versova);
                    listViewAdapter = new ListViewAdapter(this, stations);
                    listView.setAdapter(listViewAdapter);
                }
                if (direction.equals("ghatkopar")){
                    String[] stations = getResources().getStringArray(R.array.dnnagar_to_ghatkopar);
                    listViewAdapter = new ListViewAdapter(this, stations);
                    listView.setAdapter(listViewAdapter);
                }
                break;
            case 2:
                if (direction.equals("versova")){
                    String[] stations = getResources().getStringArray(R.array.asalpha_to_versova);
                    listViewAdapter = new ListViewAdapter(this, stations);
                    listView.setAdapter(listViewAdapter);
                }
                if (direction.equals("ghatkopar")){
                    String[] stations = getResources().getStringArray(R.array.azadnagar_to_ghatkopar);
                    listViewAdapter = new ListViewAdapter(this, stations);
                    listView.setAdapter(listViewAdapter);
                }
                break;
            case 3:
                if (direction.equals("versova")){
                    String[] stations = getResources().getStringArray(R.array.sakinaka_to_versova);
                    listViewAdapter = new ListViewAdapter(this, stations);
                    listView.setAdapter(listViewAdapter);
                }
                if (direction.equals("ghatkopar")){
                    String[] stations = getResources().getStringArray(R.array.andheri_to_ghatkopar);
                    listViewAdapter = new ListViewAdapter(this, stations);
                    listView.setAdapter(listViewAdapter);
                }
                break;
            case 4:
                if (direction.equals("versova")){
                    String[] stations = getResources().getStringArray(R.array.marolnaka_to_versova);
                    listViewAdapter = new ListViewAdapter(this, stations);
                    listView.setAdapter(listViewAdapter);
                }
                if (direction.equals("ghatkopar")){
                    String[] stations = getResources().getStringArray(R.array.westernexp_to_ghatkopar);
                    listViewAdapter = new ListViewAdapter(this, stations);
                    listView.setAdapter(listViewAdapter);
                }
                break;
            case 5:
                if (direction.equals("versova")){
                    String[] stations = getResources().getStringArray(R.array.airportroad_to_versova);
                    listViewAdapter = new ListViewAdapter(this, stations);
                    listView.setAdapter(listViewAdapter);
                }
                if (direction.equals("ghatkopar")){
                    String[] stations = getResources().getStringArray(R.array.jbnagar_to_ghatkopar);
                    listViewAdapter = new ListViewAdapter(this, stations);
                    listView.setAdapter(listViewAdapter);
                }
                break;
            case 6:
                if (direction.equals("versova")){
                    String[] stations = getResources().getStringArray(R.array.jbnagar_to_versova);
                    listViewAdapter = new ListViewAdapter(this, stations);
                    listView.setAdapter(listViewAdapter);
                }
                if (direction.equals("ghatkopar")){
                    String[] stations = getResources().getStringArray(R.array.airportroad_to_ghatkopar);
                    listViewAdapter = new ListViewAdapter(this, stations);
                    listView.setAdapter(listViewAdapter);
                }
                break;
            case 7:
                if (direction.equals("versova")){
                    String[] stations = getResources().getStringArray(R.array.westernexp_to_versova);
                    listViewAdapter = new ListViewAdapter(this, stations);
                    listView.setAdapter(listViewAdapter);
                }
                if (direction.equals("ghatkopar")){
                    String[] stations = getResources().getStringArray(R.array.marolnaka_to_ghatkopar);
                    listViewAdapter = new ListViewAdapter(this, stations);
                    listView.setAdapter(listViewAdapter);
                }
                break;
            case 8:
                if (direction.equals("versova")){
                    String[] stations = getResources().getStringArray(R.array.andheri_to_versova);
                    listViewAdapter = new ListViewAdapter(this, stations);
                    listView.setAdapter(listViewAdapter);
                }
                if (direction.equals("ghatkopar")){
                    String[] stations = getResources().getStringArray(R.array.sakinaka_to_ghatkopar);
                    listViewAdapter = new ListViewAdapter(this, stations);
                    listView.setAdapter(listViewAdapter);
                }
                break;
            case 9:
                if (direction.equals("versova")){
                    String[] stations = getResources().getStringArray(R.array.azadnagar_to_versova);
                    listViewAdapter = new ListViewAdapter(this, stations);
                    listView.setAdapter(listViewAdapter);
                }
                if (direction.equals("ghatkopar")){
                    String[] stations = getResources().getStringArray(R.array.asalpha_to_ghatkopar);
                    listViewAdapter = new ListViewAdapter(this, stations);
                    listView.setAdapter(listViewAdapter);
                }
                break;
            case 10:
                if (direction.equals("versova")){
                    String[] stations = getResources().getStringArray(R.array.dnnagar_to_versova);
                    listViewAdapter = new ListViewAdapter(this, stations);
                    listView.setAdapter(listViewAdapter);
                }
                if (direction.equals("ghatkopar")){
                    String[] stations = getResources().getStringArray(R.array.jagrutinagar_to_ghatkopar);
                    listViewAdapter = new ListViewAdapter(this, stations);
                    listView.setAdapter(listViewAdapter);
                }
                break;


        }
    }
}

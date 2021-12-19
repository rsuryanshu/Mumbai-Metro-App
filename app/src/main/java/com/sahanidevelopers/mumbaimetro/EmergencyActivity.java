package com.sahanidevelopers.mumbaimetro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class EmergencyActivity extends AppCompatActivity {

    ListView listView;
    EmergencyListViewAdapter adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<ModelList> arrayList = new ArrayList<ModelList>();

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        title = new String[]{"National Emergency", "Police", "Fire", "Ambulance", "Women Helpline","Air Ambulance","Anti Poison","Disaster Management","EARTHQUAKE / FLOOD","Missing Child And Women","Railway Enquiry","Senior Citizen Helpline","Medical Helpline","Railway Accident","Road Accident","Relief Commissioner","Children In Difficult Situation","Central Vigilance Commission","Tourist Helpline","LPG Leak Helpline"};
        description = new String[]{"112", "100", "101", "102", "1091","9540161344","1066","01126701728","01124363260","1094","139","1091","108","1072","1073","1070","1098","1964","1800111363","1906"};
        icon = new int[]{R.drawable.ic_call, R.drawable.ic_call, R.drawable.ic_call, R.drawable.ic_call, R.drawable.ic_call, R.drawable.ic_call, R.drawable.ic_call, R.drawable.ic_call, R.drawable.ic_call, R.drawable.ic_call, R.drawable.ic_call, R.drawable.ic_call, R.drawable.ic_call, R.drawable.ic_call, R.drawable.ic_call, R.drawable.ic_call, R.drawable.ic_call, R.drawable.ic_call, R.drawable.ic_call, R.drawable.ic_call};

        listView = (ListView) findViewById(R.id.listView);

        for (int i =0; i<title.length; i++){
            ModelList modelList = new ModelList(title[i], description[i], icon[i]);
            //bind all strings in an array
            arrayList.add(modelList);
        }

        //pass results to listViewAdapter class
        adapter = new EmergencyListViewAdapter(this, arrayList);

        //bind the adapter to the listview
        listView.setAdapter(adapter);


        if (Build.VERSION.SDK_INT < 23) {
            Log.d("TAG","Call");
        }else {

            if (ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {

            }else {
                final String[] PERMISSIONS_STORAGE = {Manifest.permission.CALL_PHONE};
                //Asking request Permissions
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, 9);
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else {
                    adapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        boolean permissionGranted = false;
        switch(requestCode){
            case 9:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
                }
        }
    }


}
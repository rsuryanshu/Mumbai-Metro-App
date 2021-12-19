package com.sahanidevelopers.mumbaimetro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SelectDirectionLine1Activity extends AppCompatActivity {

    ImageButton versova, ghatkopar;
    String direction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_direction_line1);

        versova = findViewById(R.id.versova);
        ghatkopar = findViewById(R.id.ghatkopar);

        versova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectDirectionLine1Activity.this, SelectLocationLine1Activity.class);
                direction = "versova";
                i.putExtra("DIRECTION", direction);
                startActivity(i);
            }
        });


        ghatkopar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectDirectionLine1Activity.this, SelectLocationLine1Activity.class);
                direction = "ghatkopar";
                i.putExtra("DIRECTION", direction);
                startActivity(i);
            }
        });
    }
}

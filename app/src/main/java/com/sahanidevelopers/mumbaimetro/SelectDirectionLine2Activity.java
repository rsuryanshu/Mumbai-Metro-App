package com.sahanidevelopers.mumbaimetro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SelectDirectionLine2Activity extends AppCompatActivity {

    ImageButton dahisar, mandale;
    String direction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_direction_line2);
        dahisar = findViewById(R.id.dahisar);
        mandale = findViewById(R.id.mandale);

        dahisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectDirectionLine2Activity.this, SelectLocationLine2Activity.class);
                direction = "dahisar";
                i.putExtra("DIRECTION", direction);
                startActivity(i);
            }
        });


        mandale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectDirectionLine2Activity.this, SelectLocationLine2Activity.class);
                direction = "mandale";
                i.putExtra("DIRECTION", direction);
                startActivity(i);
            }
        });
    }
}

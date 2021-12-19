package com.sahanidevelopers.mumbaimetro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SelectDirectionLine3Activity extends AppCompatActivity {

    ImageButton aarey, cuffeparade;
    String direction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_direction_line3);

        aarey = findViewById(R.id.aarey);
        cuffeparade = findViewById(R.id.cuffeparade);

        aarey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectDirectionLine3Activity.this, SelectLocationLine3Activity.class);
                direction = "aarey";
                i.putExtra("DIRECTION", direction);
                startActivity(i);
            }
        });


        cuffeparade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectDirectionLine3Activity.this, SelectLocationLine3Activity.class);
                direction = "cuffeparade";
                i.putExtra("DIRECTION", direction);
                startActivity(i);
            }
        });
    }
}

package com.sahanidevelopers.mumbaimetro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectLineActivity extends AppCompatActivity {

    CardView line1, line2, line3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_line);
        line1 = findViewById(R.id.line1);
        line2 = findViewById(R.id.line2);
//        line3 = findViewById(R.id.line3);

        line1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectLineActivity.this, SelectDirectionLine1Activity.class);
                startActivity(i);
            }
        });

        line2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectLineActivity.this, SelectDirectionLine2Activity.class);
                startActivity(i);
            }
        });
//
//        line3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(SelectLineActivity.this, SelectDirectionLine3Activity.class);
//                startActivity(i);
//            }
//        });
    }
}

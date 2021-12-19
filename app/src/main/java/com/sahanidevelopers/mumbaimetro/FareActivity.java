package com.sahanidevelopers.mumbaimetro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class FareActivity extends AppCompatActivity {


    AutoCompleteTextView actvSource;
    AutoCompleteTextView actvDestination;
    Button Click;
    String start,stop;
    String[][] a;
    int count=0;
    ArrayList<String> list = new ArrayList<String>();
    int change = 0;
    String[] b={"D N NAGAR"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fare);

        actvSource = (AutoCompleteTextView)findViewById(R.id.actv1);
        actvDestination = (AutoCompleteTextView)findViewById(R.id.actv2);
        Click = (Button)findViewById(R.id.btn);
        String[] stations = getResources().getStringArray(R.array.station_array);
        actvSource.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,stations));
        actvDestination.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,stations));
        a= new String[][]
                {
                        {"VERSOVA","D N NAGAR","AZAD NAGAR","ANDHERI","WESTERN EXP HIGHWAY","J B NAGAR","AIRPORT ROAD","MAROL NAKA","SAKI NAKA","ASALPHA","JAGRUTI NAGAR","GHATKOPAR"}
//                        {"DAHISAR","ANAND NAGAR","RUSHI SANKUL","I C COLONY","EKSAR","DON BOSCO","SHIMPOLI","MAHAVIR NAGAR","KAMRAJ NAGAR","CHARKOP","MALAD METRO","KASTURI PARK","BANGUR NAGAR","GOREGAON","ADARSH NAGAR","SHASHTRI NAGAR","D N NAGAR"}
                };
        Fare();
        Click.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v) {

                if((actvSource.getText().toString().length()==0) && (actvDestination.getText().toString().length()==0))
                {
                    Toast.makeText(FareActivity.this, "Please Enter Source and Destination", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    clearValue();
                    Fare();
                    ListOfRoute();
                    actvSource.setText("");
                    actvDestination.setText("");

                }


            }
        });


    }

    public int search(int k, int i, String b[], String a[][])
    {
        int j=0,col3=0;
        while(j < a[i].length)
        {
            if(a[i][j].equals(b[k]))
            {
                col3=j;
                break;
            }
            j++;
        }
        return col3 ;
    }
    public void Fare()
    {
        start = actvSource.getText().toString().trim();
        stop = actvDestination.getText().toString().trim();
        if(start.length()!=0)
            list.add("◉ "+start);
        else
            list.clear();

        int i=0,j,k=0,row1=0,row2=0,col1=0,col2=0,flag=0,flag1=0;
        for(i=0;i<1;i++)
        {
            j=0;
            while(j < a[i].length)
            {
                if(a[i][j].equals(start))
                {
                    flag=1;
                    row1=i;
                    col1=j;
                }
                if(a[i][j].equals(stop))
                {
                    flag1=1;
                    row2=i;
                    col2=j;
                }
                j++;
            }
        }

        //main Algorithm
        if(row1 == row2)
        {
            if(col1 < col2)
            {       col1++;
                while(col1!=col2)
                {
                    list.add("◉ "+a[row1][col1]);
                    col1++;
                    count++;
                }

            }
            else if(col1>col2)
            {       col1--;
                while(col1!=col2)
                {
                    list.add("◉ "+a[row1][col1]);
                    col1--;
                    count++;
                }
            }
            else if(start.length()!=0&&start.equals(stop))
                Toast.makeText(FareActivity.this, "Source & Destination are Same", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(row1==0)
                k=0;
            else if((row1==3&&row2==4) || (row1==4&&row2==3))
                k=6;
            else if((row1==3&&row2==1) || (row1==1&&row2==3))
                k=1;
            else if((row1==3&&row2==2) || (row1==2&&row2==3))
                k=3;
            else if((row1==3&&row2==5) || (row1==5&&row2==3))
                k=5;
            else if((row1==1&&row2==6) || (row1==6&&row2==1))
                k=2;


            int col3=search(k,row1,b,a);
            if(col1 < col3)
            {       col1++;
                while(col1!=col3)
                {
                    list.add("◉ "+a[row1][col1]);
                    col1++;
                    count++;
                }

            }
            else if(col1>col3)
            {       col1--;
                while(col1!=col3)
                {
                    list.add("◉ "+a[row1][col1]);
                    col1--;
                    count++;
                }

            }
            count++;
            list.add("Change Here : "+a[row1][col3]);
            change++;
            col3=search(k,row2,b,a);
            if(col3 < col2)
            {       col3++;
                while(col3!=col2)
                {
                    list.add("◉ "+a[row2][col3]);
                    col3++;
                    count++;
                }

            }
            else if(col3>col2)
            {       col3--;
                while(col3!=col2)
                {
                    list.add("◉ "+a[row2][col3]);
                    col3--;
                    count++;
                }

            }
            count++;
            list.add("◉ "+a[row2][col3]);
        }
        if(list.contains("◉ "+actvDestination.getText()))
        {
            list.toArray(new String[list.size()]);
        }
        else
        {
            list.add("◉ "+actvDestination.getText());
            list.toArray(new String[list.size()]);
        }

    }
    public void ListOfRoute()
    {
        String s1 = actvSource.getText().toString();
        String d1 = actvDestination.getText().toString();
        Intent intent =new Intent(this,FareListActivity.class);
        intent.putExtra("ARRAYLIST", list);
        intent.putExtra("COUNT", count);
        intent.putExtra("CHANGE", change);
        startActivity(intent);

    }
    public void clearValue()
    {
        list.clear();
        count = 0;
        change = 0;
    }
}

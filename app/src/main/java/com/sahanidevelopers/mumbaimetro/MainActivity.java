package com.sahanidevelopers.mumbaimetro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseUser user;
    TextView textView, textViewGreeting;


    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;

    CardView schedule, fare, maps, card_recharge;


    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth=FirebaseAuth.getInstance();
        textView= (TextView) findViewById(R.id.textView);
        textViewGreeting = findViewById(R.id.textViewGreeting);
        mAuthListener =new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()==null){
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
            }
        };




        mDrawerlayout =  findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawerlayout,R.string.open,R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView mNavigationView= findViewById(R.id.drawer_nav);
        if(mNavigationView!=null){
            mNavigationView.setNavigationItemSelectedListener(this);
        }


        NavigationView navigationView = (NavigationView) findViewById(R.id.drawer_nav);
        View hview = navigationView.getHeaderView(0);
        TextView nav_user= (TextView) hview.findViewById(R.id.username);
        ImageView user_profile = hview.findViewById(R.id.logo);
        user = FirebaseAuth.getInstance().getCurrentUser();

        Calendar calendar = Calendar.getInstance();
        int timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        String greeting = "";
        if (timeOfDay >= 0 && timeOfDay < 12) {
            greeting = "Good Morning";
        } else if (timeOfDay >= 12 && timeOfDay < 16) {
            greeting = "Good Afternoon";
        } else if (timeOfDay >= 16 && timeOfDay < 21) {
            greeting = "Good Evening";
        } else if (timeOfDay >= 21 && timeOfDay < 24) {
            greeting = "Good Night";
        }

        if(user!=null){
            String name=user.getDisplayName();
            nav_user.append("Hi, "+name+"!");
            Picasso.get().load(user.getPhotoUrl()).into(user_profile);
            textViewGreeting.setText(greeting+ ", "+"\n"+name+"!");
        }


        card_recharge = findViewById(R.id.card_recharge);
        card_recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RechargeActivity.class);
                startActivity(i);

            }
        });

        maps = findViewById(R.id.maps);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(i);
            }
        });

        fare = findViewById(R.id.fare);
        fare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FareActivity.class);
                startActivity(i);
            }
        });

        schedule = findViewById(R.id.schedule);
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SelectLineActivity.class);
                startActivity(i);
            }
        });

    }


    @Override
    public void onBackPressed() {
        if(mDrawerlayout.isDrawerOpen(Gravity.LEFT)) {
            mDrawerlayout.closeDrawer(Gravity.LEFT);
        }
        else{
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.ic_logo)
                    .setTitle("Mumbai Metro")
                    .setMessage("Are you sure you want to close?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finishAffinity();
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id == R.id.action_share){
            Intent share = new Intent(android.content.Intent.ACTION_SEND);
            share.setType("text/plain");
            share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

            share.putExtra(Intent.EXTRA_SUBJECT, "Download Mumbai Metro APP");
            share.putExtra(Intent.EXTRA_TEXT, "Download Mumbai Metro App \n\nClick on this Link: bit.ly/MumbaiMetroApp");

            startActivity(Intent.createChooser(share, "Share link!"));
        } else if (id == R.id.action_live_traffic) {
            startActivity(new Intent(MainActivity.this, LiveTrafficActivity.class));
        } else if (id == R.id.action_emergency) {
            Toast.makeText(MainActivity.this, "Emergency Contacts", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, EmergencyActivity.class));
        }
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.home:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.About:
                Toast.makeText(this, "About Us", Toast.LENGTH_SHORT).show();
                Intent about = new Intent(MainActivity.this,AboutUsActivity.class);
                startActivity(about);
                break;
            case R.id.Contact:
                Toast.makeText(this, "Contact Us", Toast.LENGTH_SHORT).show();
                Intent contact = new Intent(MainActivity.this,ContactActivity.class);
                startActivity(contact);
                break;
            case R.id.Rewards:
                Toast.makeText(this, "Metro Rewards", Toast.LENGTH_SHORT).show();
                Intent rewards = new Intent(MainActivity.this,MetroRewardsActivity.class);
                startActivity(rewards);
                break;
            case R.id.signOut:
                FirebaseAuth.getInstance().signOut();
                break;
        }
        mDrawerlayout.closeDrawer(GravityCompat.START);

        return true;
    }
}

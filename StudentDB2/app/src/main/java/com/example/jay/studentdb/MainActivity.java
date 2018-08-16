package com.example.jay.studentdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button EnterB = (Button) findViewById(R.id.bEnter);
        Button Showb = (Button) findViewById(R.id.bShow);
        Button DeleteB = (Button) findViewById(R.id.bDelete);
        new GcmRegistrationAsyncTask(this).execute();

        EnterB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent iIntent = new Intent("com.example.jay.EnterRecords");
                startActivity(iIntent);


            }
        });
        Showb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iIntent = new Intent("com.example.jay.ReadRecords");
                startActivity(iIntent);

            }
        });
        DeleteB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iIntent = new Intent("com.example.jay.ReadRecords");
                startActivity(iIntent);

            }
        });

    }


}

package com.example.jay.studentdb;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class DeleteRecords extends AppCompatActivity {
    TextView ShowRecords;
    private final static String STORETEXT="storetext.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_records);
        ShowRecords = (TextView)findViewById(R.id.tvShowRecords);
        SqlClass info = new SqlClass(this);

        try {
            info.open();
            String data = info.getData();

            ShowRecords.setText(data);
            info.close();
        }catch (Exception e ){
            ShowRecords.setText("test text");

        }
    }
}

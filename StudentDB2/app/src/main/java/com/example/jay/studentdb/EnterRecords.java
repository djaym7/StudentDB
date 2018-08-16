package com.example.jay.studentdb;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by jay on 3/27/2015.
 */
public class EnterRecords extends Activity implements View.OnClickListener {

    EditText FirstName,LastName,Division,RollNumber,EmailAddress;
    Button Submit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter);
        initialize();

    }

    private void initialize() {

        FirstName = (EditText)findViewById(R.id.etFirstName);
        LastName = (EditText)findViewById(R.id.etLastName);
        RollNumber = (EditText)findViewById(R.id.etRollnumber);
        Division = (EditText)findViewById(R.id.etDivision);
        EmailAddress = (EditText)findViewById(R.id.etEmailaddress);
        Submit = (Button)findViewById(R.id.bSubmit);
        Submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bSubmit:
                Boolean didItWork = true;

                try {
                    String Fname = FirstName.getText().toString();
                    String Lname = LastName.getText().toString();
                    String Rollno = RollNumber.getText().toString();
                    String Div = Division.getText().toString();
                    String Email = EmailAddress.getText().toString();

                    SqlClass entry = new SqlClass(this);
                    entry.open();
                    entry.createEntry(Fname, Lname, Rollno, Div, Email);

                    entry.close();
                }catch (Exception e){
                    didItWork = false;

                }finally {
                    if (didItWork){

                        android.widget.Toast.makeText(EnterRecords.this, "Data is saved successfully", Toast.LENGTH_SHORT).show();

                    }else if(didItWork = false){
                        android.widget.Toast.makeText(EnterRecords.this, "Data failed to save.", Toast.LENGTH_SHORT).show();
                    }
                }



        }
    }



}

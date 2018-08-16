package com.example.jay.studentdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

/**
 * Created by jay on 3/29/2015.
 */
public class SqlClass {
    public static final String KEY_ROWID = "ID";
    public static final String KEY_FIRSTNAME = "FIRST_NAME";
    public static final String KEY_LASTNAME = "LAST_NAME";
    public static final String KEY_ROLLNUMBER = "ROLL_NUMBER";
    public static final String KEY_DIVISION = "DIV_DIV";
    public static final String KEY_EMAILADDRESS = "EMAIL_ADDRESS";

    public static final String DATABASE_NAME = "DATABSE";
    public static final String DATABASE_TABLE = "STUDENTTABLE";
    public static final int DATABASE_VERSION = 9;

    private DbHelper ourHelper;
    private final Context ourContext;
    private SQLiteDatabase ourDatabase;




    private static class DbHelper extends SQLiteOpenHelper {

        private DbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            // String code = new String[]{};

            sqLiteDatabase.execSQL("CREATE TABLE " + DATABASE_TABLE +" (" +
                    KEY_ROWID + " INTEGER PRIMARY KEY, " +
                    KEY_FIRSTNAME + " TEXT NOT NULL, " +
                    KEY_LASTNAME + " TEXT NOT NULL, " +
                    KEY_ROLLNUMBER + " TEXT NOT NULL, " +
                    KEY_DIVISION + " TEXT NOT NULL, " +
                    KEY_EMAILADDRESS + " TEXT NOT NULL " + " );" );
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(sqLiteDatabase);
        }

    }


    public Long createEntry(String fname, String lname, String rollno, String div, String email) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_FIRSTNAME,fname);
        cv.put(KEY_LASTNAME,lname);
        cv.put(KEY_ROLLNUMBER,rollno);
        cv.put(KEY_DIVISION,div);
        cv.put(KEY_EMAILADDRESS,email);
        return ourDatabase.insert(DATABASE_TABLE,null,cv);
    }

    public SqlClass(Context c) {
        ourContext = c;
    }


    public SqlClass open() throws SQLException {
        ourHelper = new DbHelper(ourContext);
        ourDatabase = ourHelper.getWritableDatabase();
        return this;

    }
    public void  close(){
        ourHelper.close();
    }


    public String getData() {
        String[] columns = new String[]{ KEY_ROWID, KEY_FIRSTNAME,KEY_LASTNAME,KEY_ROLLNUMBER,KEY_DIVISION,KEY_EMAILADDRESS};
        Cursor c = ourDatabase.query(DATABASE_TABLE,columns,null,null,null,null,null);
        String result = "";
        int RowId = c.getColumnIndex(KEY_ROWID);
        int Firstn = c.getColumnIndex(KEY_FIRSTNAME);
        int Lastn= c.getColumnIndex(KEY_LASTNAME);
        int Rolln = c.getColumnIndex(KEY_ROLLNUMBER);
        int Divi = c.getColumnIndex(KEY_DIVISION);
        int Emaila = c.getColumnIndex(KEY_EMAILADDRESS);

        for (c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            result = result+"\n" + c.getString(RowId)+")    "+"Name: "+c.getString(Firstn)+"  "+c.getString(Lastn)+"\n      "+"Roll number: "+c.getString(Rolln)+"  Divison:"+c.getString(Divi)+"\n      "+"Email Address:"+c.getString(Emaila);
        }


        return result;
    }

}

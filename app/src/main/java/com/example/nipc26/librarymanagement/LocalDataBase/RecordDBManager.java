package com.example.nipc26.librarymanagement.LocalDataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.AlphabeticIndex;
import android.os.Environment;
import android.util.Log;

import com.example.nipc26.librarymanagement.model.CreateUserModel;
import com.example.nipc26.librarymanagement.model.UserLoginModel;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by NI PC 26 on 10/20/2016.
 */

public class RecordDBManager extends SQLiteOpenHelper {
    private static final int VERSION_DB = 1;

    private static final String DB_NAME = "localDB.db";
    private static final String DB_TABLE_NAME_USER = "user";

    private static final String ID = "id";
    private static final String USER_NAME = "user_name";
    private static final String USER_TYPE = "user_type";
    private static final String PASSWORD = "password";
    private static final String COLLEGE_ID = "college_id";
    private static final String BATCH_YEAR = "batch_year";
    private static final String FULL_NAME = "full_name";
    private static final String EMAIL_ID = "email_id";
    private static final String DOB = "dob";
    private static final String NO_BOOK_ISSUED = "no_book_issued";
    private static RecordDBManager instance;


    public static synchronized RecordDBManager getHelper(Context context) {
        if (instance == null)
            instance = new RecordDBManager(context);
        return instance;
    }

    private RecordDBManager(Context context) {
        super(context, DB_NAME, null, VERSION_DB);
        /*super(context, Environment.getExternalStorageDirectory()
                + File.separator + "data"
                + File.separator + DB_NAME, null, VERSION_DB);
        SQLiteDatabase db = this.getWritableDatabase();*/

    }


    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            // Enable foreign key constraints
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuery = "CREATE TABLE IF NOT EXISTS " + DB_TABLE_NAME_USER + " ( " +
                ID + " INTEGER PRIMARY KEY UNIQUE , " +
                USER_NAME + " TEXT , " +
                USER_TYPE + " TEXT , " +
                PASSWORD + " TEXT , " +
                COLLEGE_ID + " TEXT , " +
                FULL_NAME + " TEXT , " +
                BATCH_YEAR + " TEXT, " +
                NO_BOOK_ISSUED + " TEXT, " +
                EMAIL_ID + " TEXT, " +
                DOB + " TEXT " +
                ") ;";
        db.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE_NAME_USER);
        onCreate(db);
    }

    public boolean authorize(UserLoginModel userLoginModel){
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {USER_NAME};
        String selection = PASSWORD + " = ? "+ USER_NAME + " = ? ";
        String[] selectionArgs = { userLoginModel.getPassword(),userLoginModel.getUserName()};

        Cursor cursor = db.query(
                DB_TABLE_NAME_USER,                     // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        if(cursor != null && cursor.getCount() != 0)
            return  true;

        return false;
    }

    public boolean addUser(CreateUserModel createUserModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER_NAME,createUserModel.getUserName());
        values.put(PASSWORD,createUserModel.getPassword());
        values.put(USER_TYPE,createUserModel.getUserType());
        values.put(COLLEGE_ID,createUserModel.getCollegeId());
        values.put(FULL_NAME,createUserModel.getFullName());
        values.put(EMAIL_ID,createUserModel.getEmailId());
        values.put(DOB,createUserModel.getDob());
        values.put(NO_BOOK_ISSUED,"0");
        long newRowId = db.insert(DB_TABLE_NAME_USER, null, values);
        return  newRowId != -1;
    }

    public void showAllRecords(){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projectionAllRecord = {
                FULL_NAME
        };
        Cursor allRecords = db.query(DB_TABLE_NAME_USER,
                projectionAllRecord,
                null,
                null,
                null,
                null,
                null
        );

        allRecords.moveToFirst();

        do{
                Log.i(DB_NAME,allRecords.getString(allRecords.getColumnIndex(FULL_NAME)));
        }while (allRecords.moveToNext());
    }
}

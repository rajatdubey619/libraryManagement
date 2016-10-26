package com.example.nipc26.librarymanagement.LocalDataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.AlphabeticIndex;
import android.os.Environment;
import android.util.Log;

import com.example.nipc26.librarymanagement.model.BookModel;
import com.example.nipc26.librarymanagement.model.CreateUserModel;
import com.example.nipc26.librarymanagement.model.UserLoginModel;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by NI PC 26 on 10/20/2016.
 */

public class RecordDBManager extends SQLiteOpenHelper {
    private static final int VERSION_DB = 6;

    private static final String DB_NAME = "local.db";
    private static final String DB_TABLE_NAME_USER = "user_info_one";
    private static final String DB_TABLE_NAME_BOOK = "book_one";

    private static final String ID = "id";
    private static final String USER_NAME = "user_name";
    private static final String USER_TYPE = "user_type";
    private static final String PASSWORD = "password";
    private static final String COLLEGE_ID = "college_id";
    private static final String BATCH_YEAR = "batch_year";
    private static final String FULL_NAME = "full_name";
    private static final String EMAIL_ID = "email_id";
    private static final String DOB = "dob";
    private static final String APPROVED = "approved";
    private static final String MOBILE_NO = "mobile_no";
    private static final String NO_BOOK_ISSUED = "no_book_issued";


    private static final String ID_BOOK = "id";
    private static final String BOOK_NAME = "book_name";
    private static final String BOOK_TYPE = "book_type";
    private static final String PRICE = "price";
    private static final String EDITION = "edition";
    private static final String COPIES = "copied";
    private static final String BOOK_BARCODE = "book_barcode";

    private static RecordDBManager instance;


    public static synchronized RecordDBManager getHelper(Context context) {
        if (instance == null)
            instance = new RecordDBManager(context);
        return instance;
    }

    private RecordDBManager(Context context) {
       /* super(context, DB_NAME, null, VERSION_DB);*/
        super(context, Environment.getExternalStorageDirectory()
                + File.separator + "data"
                + File.separator + DB_NAME, null, VERSION_DB);
        SQLiteDatabase db = this.getWritableDatabase();
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
        String createQueryUser = "CREATE TABLE IF NOT EXISTS " + DB_TABLE_NAME_USER + " ( " +
                ID + " INTEGER PRIMARY KEY UNIQUE , " +
                USER_NAME + " TEXT , " +
                USER_TYPE + " TEXT , " +
                PASSWORD + " TEXT , " +
                COLLEGE_ID + " TEXT DEFAULT 'B130010001', " +
                FULL_NAME + " TEXT DEFAULT 'abc@gmail.com' , " +
                BATCH_YEAR + "  TEXT DEFAULT '2016' , " +
                NO_BOOK_ISSUED + " TEXT DEFAULT  '0' , " +
                EMAIL_ID + " TEXT DEFAULT 'abc@gmail.com'  , " +
                DOB + " TEXT DEFAULT '01/01/1971', " +
                APPROVED + " TEXT DEFAULT 'Y' ," +
                MOBILE_NO + " TEXT TEXT DEFAULT '987456123'" +
                ") ;";
        String createQueryBook = "CREATE TABLE IF NOT EXISTS " + DB_TABLE_NAME_BOOK + " ( " +
                ID_BOOK + " INTEGER PRIMARY KEY UNIQUE , " +
                BOOK_NAME + " TEXT DEFAULT 'Dummy Andorid', " +
                BOOK_TYPE + " TEXT DEFAULT 'CSE', " +
                PRICE + " TEXT DEFAULT 'Rs200', " +
                BOOK_BARCODE + " TEXT DEFAULT 'B130010001', " +
                EDITION + " TEXT DEFAULT '2016' , " +
                COPIES + " TEXT TEXT DEFAULT '30'" +
                ") ;";
        db.execSQL(createQueryUser);
        db.execSQL(createQueryBook);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
           // db.execSQL("ALTER TABLE "+ DB_TABLE_NAME_USER+" ADD COLUMN " + MOBILE_NO + " TEXT DEFAULT '987456123' ; ");
            db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE_NAME_USER);
            db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE_NAME_BOOK);
        }
        onCreate(db);
    }

    public boolean authorize(UserLoginModel userLoginModel) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {PASSWORD};
        String selection = USER_NAME + " = ? ";
        String[] selectionArgs = {userLoginModel.getUserName()};

        Cursor cursor = db.query(
                DB_TABLE_NAME_USER,                     // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        if(cursor.getCount() != 0){
            cursor.moveToFirst();
            do{
                Log.d("Login",userLoginModel.getPassword() + "  " + cursor.getString(cursor.getColumnIndex(PASSWORD)));
                if(userLoginModel.getPassword().compareTo(cursor.getString(cursor.getColumnIndex(PASSWORD))) == 0)
                    return  true;
            }while(cursor.moveToNext());
        }


        return false;
    }



    public boolean addUser(CreateUserModel createUserModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER_NAME, createUserModel.getUserName());
        values.put(PASSWORD, createUserModel.getPassword());
        values.put(USER_TYPE, createUserModel.getUserType());
        values.put(COLLEGE_ID, createUserModel.getCollegeId());
        values.put(FULL_NAME, createUserModel.getFullName());
        values.put(EMAIL_ID, createUserModel.getEmailId());
        values.put(MOBILE_NO,createUserModel.getMobileNo());
        values.put(DOB, createUserModel.getDob());
        values.put(NO_BOOK_ISSUED, "0");
        values.put(APPROVED,"Y");
        long newRowId = db.insert(DB_TABLE_NAME_USER, null, values);
        Log.d("newRowId", String.valueOf(newRowId));
        return newRowId != -1;
    }

    public List<CreateUserModel> showAllRecords(List<CreateUserModel> createUserModels) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projectionAllRecord = {
                FULL_NAME,
                USER_NAME,
                PASSWORD,
                USER_TYPE,
                EMAIL_ID,
                DOB,
                NO_BOOK_ISSUED,
                APPROVED,
                MOBILE_NO,
                COLLEGE_ID,
                BATCH_YEAR

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

        do {
            CreateUserModel createUserModel = new CreateUserModel();
            createUserModel.setFullName(allRecords.getString(allRecords.getColumnIndex(FULL_NAME)));
            createUserModel.setUserName(allRecords.getString(allRecords.getColumnIndex(USER_NAME)));
            createUserModel.setPassword(allRecords.getString(allRecords.getColumnIndex(PASSWORD)));
            createUserModel.setUserType(allRecords.getString(allRecords.getColumnIndex(USER_TYPE)));
            createUserModel.setEmailId(allRecords.getString(allRecords.getColumnIndex(EMAIL_ID)));
            createUserModel.setMobileNo(allRecords.getString(allRecords.getColumnIndex(MOBILE_NO)));
            createUserModel.setCollegeId(allRecords.getString(allRecords.getColumnIndex(COLLEGE_ID)));
            createUserModel.setDob(allRecords.getString(allRecords.getColumnIndex(DOB)));
            createUserModel.setYear(allRecords.getString(allRecords.getColumnIndex(BATCH_YEAR)));
            createUserModel.setNoOfBookIssued(allRecords.getString(allRecords.getColumnIndex(NO_BOOK_ISSUED)));
            createUserModel.setApproved(allRecords.getString(allRecords.getColumnIndex(APPROVED)));
            Log.d("createUserModel", createUserModel.toString());
            createUserModels.add(createUserModel);
        } while (allRecords.moveToNext());

        return createUserModels;
    }



    public boolean addBook(BookModel bookModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BOOK_NAME, bookModel.getBookName());
        values.put(BOOK_TYPE, bookModel.getBookType());
        values.put(BOOK_BARCODE, bookModel.getBookBarcode());
        values.put(PRICE, bookModel.getPrice());
        values.put(COPIES, bookModel.getCopied());
        values.put(EDITION,bookModel.getEdition());
        long newRowId = db.insert(DB_TABLE_NAME_USER, null, values);
        Log.d("newRowBookId", String.valueOf(newRowId));
        return newRowId != -1;
    }

    public List<BookModel> showAllBook(List<BookModel> bookModels) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projectionAllRecord = {
                BOOK_NAME,
                BOOK_TYPE,
                BOOK_BARCODE,
                PRICE,
                COPIES,
                EDITION
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

        do {
            BookModel bookModel = new BookModel();
            bookModel.setBookName(allRecords.getString(allRecords.getColumnIndex(BOOK_NAME)));
            bookModel.setBookType(allRecords.getString(allRecords.getColumnIndex(BOOK_TYPE)));
            bookModel.setBookBarcode(allRecords.getString(allRecords.getColumnIndex(BOOK_BARCODE)));
            bookModel.setPrice(allRecords.getString(allRecords.getColumnIndex(PRICE)));
            bookModel.setCopied(allRecords.getString(allRecords.getColumnIndex(COPIES)));
            bookModel.setEdition(allRecords.getString(allRecords.getColumnIndex(EDITION)));
            Log.d("bookModel", bookModel.toString());
            bookModels.add(bookModel);
        } while (allRecords.moveToNext());

        return bookModels;
    }
}

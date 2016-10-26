package com.example.nipc26.librarymanagement.activities;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nipc26.librarymanagement.LocalDataBase.RecordDBManager;
import com.example.nipc26.librarymanagement.R;
import com.example.nipc26.librarymanagement.model.BookModel;
import com.example.nipc26.librarymanagement.model.CreateUserModel;

import java.util.Calendar;

public class AddBookActivity extends AppCompatActivity implements View.OnClickListener{

    private Toolbar toolbar;
    private EditText etBookName;
    private EditText etBookBarcode;
    private EditText etBookType;
    private EditText etPrice;
    private EditText etCopies;
    private Button btnAddBook;
    private TextView tvEdition;
    private DatePickerDialog.OnDateSetListener dateListner;
    private DatePickerDialog dpd;
    private Calendar calendar;
    private int year, month, day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.ic_bmw_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        etBookName = (EditText)findViewById(R.id.etBookName);
        etBookBarcode = (EditText)findViewById(R.id.etBookBarcode);
        etBookType = (EditText)findViewById(R.id.etBookType);
        etPrice = (EditText)findViewById(R.id.etPrice);
        etCopies = (EditText)findViewById(R.id.etCopies);
        tvEdition = (TextView) findViewById(R.id.etEdition);
        btnAddBook = (Button) findViewById(R.id.btnAddBook);
        btnAddBook.setOnClickListener(this);
        tvEdition.setOnClickListener(this);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddBook:
                BookModel bookModel = new BookModel();
                bookModel.setBookName(etBookName.getText().toString());
                bookModel.setBookBarcode(etBookBarcode.getText().toString());
                bookModel.setBookType(etBookType.getText().toString());
                bookModel.setPrice(etPrice.getText().toString());
                bookModel.setCopied(etCopies.getText().toString());
                bookModel.setEdition(tvEdition.getText().toString());
                Log.d("bookModel", bookModel.toString());
                Log.d("account Created", RecordDBManager.getHelper(this).addBook(bookModel) ? "Y" : "N");
                finish();
                break;
            case R.id.etEdition:
                dateListner = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvEdition.setText(String.valueOf(year));
                    }


                };
                dpd = new DatePickerDialog(this, dateListner, year, month, day);
                dpd.setButton(DialogInterface.BUTTON_POSITIVE, "Set", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        DatePicker datePicker = dpd.getDatePicker();

                        // The following clear focus did the trick of saving the date while the date is put manually by the edit text.
                        datePicker.clearFocus();
                        dateListner.onDateSet(datePicker, datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
                    }
                });
                dpd.show();
                break;
        }
    }
}

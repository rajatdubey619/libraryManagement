package com.example.nipc26.librarymanagement.activities;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView;

import com.example.nipc26.librarymanagement.R;
import com.example.nipc26.librarymanagement.model.BookModel;
import com.example.nipc26.librarymanagement.model.CreateUserModel;

public class BookDetailsMainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView tvBookName;
    private TextView tvBookBarcode;
    private TextView tvBookType;
    private TextView tvPrice;
    private TextView tvCopies;
    private TextView tvEdition;
    private BookModel bookModel;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.ic_bmw_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvBookName = (TextView)findViewById(R.id.tvBookName);
        tvBookBarcode = (TextView)findViewById(R.id.tvBookBarcode);
        tvBookType = (TextView)findViewById(R.id.tvBookType);
        tvPrice = (TextView)findViewById(R.id.tvPrice);
        tvCopies = (TextView)findViewById(R.id.tvCopies);
        tvEdition = (TextView) findViewById(R.id.tvEdition);

        if (getIntent().getExtras() != null) {
            if (getIntent().getExtras().get("bookModel") != null) {
                bookModel = (BookModel) getIntent().getExtras().get("bookModel");
            }
        }

        tvBookName.setText(bookModel.getBookName());
        tvBookType.setText(bookModel.getBookType());
        tvBookBarcode.setText(bookModel.bookBarcode);
        tvPrice.setText(bookModel.getPrice());
        tvCopies.setText(bookModel.getCopied());
        tvEdition.setText(bookModel.getEdition());
    }
}

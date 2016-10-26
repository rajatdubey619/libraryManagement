package com.example.nipc26.librarymanagement.activities;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.nipc26.librarymanagement.R;

public class BookActivity extends AppCompatActivity implements View.OnClickListener{
    private Toolbar toolbar;
    private RelativeLayout rlShowAllBooks;
    private RelativeLayout rlBranchBooks;
    private RelativeLayout rlEBooks;
    private RelativeLayout rlAddBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.ic_bmw_back));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
            rlShowAllBooks = (RelativeLayout)findViewById(R.id.rlShowAllBooks);
            rlBranchBooks = (RelativeLayout)findViewById(R.id.rlBranchBooks);
            rlEBooks = (RelativeLayout)findViewById(R.id.rlEBooks);
            rlAddBook = (RelativeLayout)findViewById(R.id.rlAddBook);

            rlShowAllBooks.setOnClickListener(this);
            rlBranchBooks.setOnClickListener(this);
            rlAddBook.setOnClickListener(this);
            rlEBooks.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.rlShowAllBooks:
                    Intent intentShowAllBooks =  new Intent(this,ShowAllBookActivity.class);
                    startActivity(intentShowAllBooks);
                    break;
                case R.id.rlBranchBooks:
                    Toast.makeText(this, R.string.under_dev,Toast.LENGTH_SHORT).show();
                    break;
                case R.id.rlEBooks:
                    Intent intentEBook =  new Intent(this,ShowEbookActivity.class);
                    startActivity(intentEBook);
                    break;
                case R.id.rlAddBook:
                    Intent intentAddBook = new Intent(this,AddBookActivity.class);
                    startActivity(intentAddBook);
                    break;
            }
        }
}

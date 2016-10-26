package com.example.nipc26.librarymanagement.activities;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.nipc26.librarymanagement.Adapters.ShowAllBookAdapter;
import com.example.nipc26.librarymanagement.Adapters.ShowAllUserAdapter;
import com.example.nipc26.librarymanagement.LocalDataBase.RecordDBManager;
import com.example.nipc26.librarymanagement.R;
import com.example.nipc26.librarymanagement.model.BookModel;
import com.example.nipc26.librarymanagement.model.CreateUserModel;

import java.util.ArrayList;
import java.util.List;

public class ShowAllBookActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ShowAllBookAdapter showAllBookAdapter;
    private List<BookModel> bookModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_book);

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
        bookModelList = new ArrayList<BookModel>();
        RecordDBManager.getHelper(this).showAllBook(bookModelList);
        recyclerView = (RecyclerView) findViewById(R.id.rvShowAllBook);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        showAllBookAdapter = new ShowAllBookAdapter(ShowAllBookActivity.this,bookModelList);
        recyclerView.setAdapter(showAllBookAdapter);
    }
}

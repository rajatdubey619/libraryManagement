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

public class HomeMenu extends AppCompatActivity implements View.OnClickListener{
    private Toolbar toolbar;
    private RelativeLayout rlShowBooks;
    private RelativeLayout rlIssuesBook;
    private RelativeLayout rlUsers;
    private RelativeLayout rlInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);

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


        rlShowBooks = (RelativeLayout)findViewById(R.id.rlShowBooks);
        rlIssuesBook = (RelativeLayout)findViewById(R.id.rlIssueBook);
        rlUsers = (RelativeLayout)findViewById(R.id.rlUsers);
        rlInfo = (RelativeLayout)findViewById(R.id.rlInfo);

        rlShowBooks.setOnClickListener(this);
        rlIssuesBook.setOnClickListener(this);
        rlInfo.setOnClickListener(this);
        rlUsers.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.rlShowBooks:
                Intent intentShowBooks = new Intent(this,BookActivity.class);
                startActivity(intentShowBooks);
                break;
            case R.id.rlIssueBook:
                Toast.makeText(this, R.string.under_dev,Toast.LENGTH_SHORT).show();
                break;
            case R.id.rlUsers:
                Intent intentUsers = new Intent(this,UsersActivity.class);
                startActivity(intentUsers);
                break;
            case R.id.rlInfo:
                Intent intentInfo =  new Intent(this,InfoActivity.class);
                startActivity(intentInfo);
                break;
        }
    }
}

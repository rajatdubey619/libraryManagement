package com.example.nipc26.librarymanagement.activities;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.nipc26.librarymanagement.Adapters.ShowAllUserAdapter;
import com.example.nipc26.librarymanagement.LocalDataBase.RecordDBManager;
import com.example.nipc26.librarymanagement.R;
import com.example.nipc26.librarymanagement.model.CreateUserModel;

import java.util.ArrayList;
import java.util.List;

public class ShowAllUserActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ShowAllUserAdapter showAllUserAdapter;
    private List<CreateUserModel> createUserModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_user);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.ic_bmw_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        createUserModelList = new ArrayList<CreateUserModel>();
        RecordDBManager.getHelper(this).showAllRecords(createUserModelList);
        recyclerView = (RecyclerView) findViewById(R.id.rvShowAllUser);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        showAllUserAdapter = new ShowAllUserAdapter(ShowAllUserActivity.this,createUserModelList);
        recyclerView.setAdapter(showAllUserAdapter);
    }
}

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

public class UsersActivity extends AppCompatActivity implements View.OnClickListener{
    private Toolbar toolbar;
    private RelativeLayout rlAddUsers;
    private RelativeLayout rlRemoveUser;
    private RelativeLayout rlAllUser;
    private RelativeLayout rlApproveUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

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

        rlAddUsers = (RelativeLayout)findViewById(R.id.rlAddUsers);
        rlRemoveUser = (RelativeLayout)findViewById(R.id.rlRemoveUser);
        rlAllUser = (RelativeLayout)findViewById(R.id.rlAllUser);
        rlApproveUser = (RelativeLayout)findViewById(R.id.rlApproveUser);

        rlAddUsers.setOnClickListener(this);
        rlRemoveUser.setOnClickListener(this);
        rlApproveUser.setOnClickListener(this);
        rlAllUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.rlAddUsers:
                Intent intentAddUsers = new Intent(this,CreateAccountActivity.class);
                startActivity(intentAddUsers);
                break;
            case R.id.rlIssueBook:
                Toast.makeText(this, R.string.under_dev,Toast.LENGTH_SHORT).show();
                break;
            case R.id.rlAllUser:
                Toast.makeText(this, R.string.under_dev,Toast.LENGTH_SHORT).show();
                break;
            case R.id.rlApproveUser:
                Toast.makeText(this, R.string.under_dev,Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

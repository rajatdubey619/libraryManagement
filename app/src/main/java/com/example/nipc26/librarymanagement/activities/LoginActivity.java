package com.example.nipc26.librarymanagement.activities;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.nipc26.librarymanagement.R;
import com.example.nipc26.librarymanagement.activities.HomeMenu;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Toolbar toolbar;
    private Button btnLogin;
    private Button btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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

        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnCreateAccount = (Button)findViewById(R.id.btnCreateAccount);
        btnLogin.setOnClickListener(this);
        btnCreateAccount.setOnClickListener(this);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnLogin:
                Intent intent = new Intent(getBaseContext(),HomeMenu.class);
                startActivity(intent);
                break;
            case R.id.btnCreateAccount:
                Intent intentCreateAccount = new Intent(getBaseContext(),CreateAccountActivity.class);
                startActivity(intentCreateAccount);
                break;
        }
    }
}

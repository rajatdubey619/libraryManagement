package com.example.nipc26.librarymanagement.activities;

import android.app.DatePickerDialog;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.nipc26.librarymanagement.R;
import com.example.nipc26.librarymanagement.model.CreateUserModel;

import java.util.Calendar;

public class UserDetailMainActivity extends AppCompatActivity {
    private CreateUserModel createUserModel;
    private TextView tvFullName;
    private TextView tvUserId;
    private TextView tvUniversityId;
    private TextView tvEmailId;
    private TextView tvMobileNo;
    private TextView tvBatchYear;
    private TextView tvDOBYear;
    private TextView tvPassword;
    private TextView tvNoOfBookIssued;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.ic_bmw_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvFullName = (TextView) findViewById(R.id.etFullName);
        tvUserId = (TextView) findViewById(R.id.etLoginUsername);
        tvUniversityId = (TextView) findViewById(R.id.etUnivId);
        tvEmailId = (TextView) findViewById(R.id.etEmailId);
        tvBatchYear = (TextView) findViewById(R.id.tvBatchYear);
        tvMobileNo = (TextView) findViewById(R.id.etMobileNo);
        tvDOBYear = (TextView) findViewById(R.id.tvDOBYear);
        tvPassword = (TextView) findViewById(R.id.etLoginPassword);
        tvNoOfBookIssued = (TextView) findViewById(R.id.tvNoOfBookIssued);

        if (getIntent().getExtras() != null) {
            if (getIntent().getExtras().get("createUserModel") != null) {
                createUserModel = (CreateUserModel) getIntent().getExtras().get("createUserModel");
            }
        }
        tvFullName.setText(createUserModel.getFullName());
        tvMobileNo.setText(createUserModel.getMobileNo());
        tvUserId.setText(createUserModel.getUserName());
        tvEmailId.setText(createUserModel.getEmailId());
        tvDOBYear.setText(createUserModel.getDob());
        tvBatchYear.setText(createUserModel.getYear());
        tvUniversityId.setText(createUserModel.getCollegeId());
        tvPassword.setText(createUserModel.getPassword());
        tvNoOfBookIssued.setText(createUserModel.getNoOfBookIssued());

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}


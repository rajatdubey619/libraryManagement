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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.nipc26.librarymanagement.R;
import com.example.nipc26.librarymanagement.model.CreateUserModel;

import java.util.Calendar;

public class UserDetailMainActivity extends AppCompatActivity {
    private CreateUserModel createUserModel;
    private EditText etFullName;
    private EditText etUserId;
    private EditText etUniversityId;
    private EditText etEmailId;
    private TextView tvBatchYear;
    private TextView tvDOBYear;
    private EditText etPassword;
    private Button btnCreateAccount;
    private Toolbar toolbar;
    private Spinner spinner;
    private String userType;

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

        etFullName = (EditText) findViewById(R.id.etFullName);
        etUserId = (EditText) findViewById(R.id.etLoginUsername);
        etUniversityId = (EditText) findViewById(R.id.etUnivId);
        etEmailId = (EditText) findViewById(R.id.etEmailId);
        tvBatchYear = (TextView) findViewById(R.id.tvBatchYear);
        tvDOBYear = (TextView) findViewById(R.id.tvDOBYear);
        etPassword = (EditText) findViewById(R.id.etLoginPassword);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.user_type_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        if (getIntent().getExtras() != null) {
            if (getIntent().getExtras().get("createUserModel") != null) {
                createUserModel = (CreateUserModel) getIntent().getExtras().get("createUserModel");
            }
        }
        etFullName.setText(createUserModel.getFullName());
        etUserId.setText(createUserModel.getUserName());
        etEmailId.setText(createUserModel.getEmailId());
        tvDOBYear.setText(createUserModel.getDob());
        tvBatchYear.setText(createUserModel.getYear());
        etUniversityId.setText(createUserModel.getCollegeId());
        etPassword.setText(createUserModel.getPassword());
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}


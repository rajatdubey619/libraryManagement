package com.example.nipc26.librarymanagement.activities;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.nipc26.librarymanagement.LocalDataBase.RecordDBManager;
import com.example.nipc26.librarymanagement.R;
import com.example.nipc26.librarymanagement.model.CreateUserModel;

import java.text.ParseException;
import java.util.Calendar;

import static com.example.nipc26.librarymanagement.R.drawable.calendar;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {
    private EditText etFullName;
    private EditText etUserId;
    private EditText etUniversityId;
    private EditText etEmailId;
    private EditText etMobileNo;
    private TextView tvBatchYear;
    private TextView tvDOBYear;
    private EditText etPassword;
    private Button btnCreateAccount;
    private Toolbar toolbar;
    private DatePickerDialog.OnDateSetListener dateListner;
    private DatePickerDialog dpd;
    private Calendar calendar;
    private int year, month, day;
    private Spinner spinner;
    private String userType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

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

        etFullName = (EditText) findViewById(R.id.etFullName);
        etUserId = (EditText) findViewById(R.id.etLoginUsername);
        etUniversityId = (EditText) findViewById(R.id.etUnivId);
        etEmailId = (EditText) findViewById(R.id.etEmailId);
        etMobileNo = (EditText)findViewById(R.id.etMobileNo);
        tvBatchYear = (TextView) findViewById(R.id.tvBatchYear);
        tvDOBYear = (TextView) findViewById(R.id.tvDOBYear);
        etPassword = (EditText) findViewById(R.id.etLoginPassword);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.user_type_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        btnCreateAccount = (Button) findViewById(R.id.btnCreateAccount);
        btnCreateAccount.setOnClickListener(this);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        tvBatchYear.setOnClickListener(this);
        tvDOBYear.setOnClickListener(this);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        userType = parent.getItemAtPosition(position).toString();
        userType = "User";

        // Showing selected spinner item
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCreateAccount:
                CreateUserModel createUserModel = new CreateUserModel();
                createUserModel.setFullName(etFullName.getText().toString());
                createUserModel.setUserName(etUserId.getText().toString());
                createUserModel.setCollegeId(etUniversityId.getText().toString());
                createUserModel.setEmailId(etEmailId.getText().toString());
                createUserModel.setDob(tvDOBYear.getText().toString());
                createUserModel.setYear(tvBatchYear.getText().toString());
                createUserModel.setPassword(etPassword.getText().toString());
                createUserModel.setMobileNo(etMobileNo.getText().toString());
                createUserModel.setUserType("Admin");
                createUserModel.setNoOfBookIssued("0");
                Log.d("createUserModel", createUserModel.toString());
                Log.d("account Created", RecordDBManager.getHelper(this).addUser(createUserModel) ? "Y" : "N");

                finish();
                break;
            case R.id.tvBatchYear:
                dateListner = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvBatchYear.setText(String.valueOf(year));
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
            case R.id.tvDOBYear:
                dateListner = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvDOBYear.setText(monthOfYear + 1 + "/" + dayOfMonth + "/" + year);
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

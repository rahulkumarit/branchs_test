package com.dailogexample.datepicker;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.dailogexample.R;
import com.dailogexample.utils.StaticUtils;

import java.text.ParseException;

public class DatePickerActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnFrom, btnToDate, btnCheckDate;
    private TextView txtDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        btnFrom = findViewById(R.id.btnFrom);
        btnToDate = findViewById(R.id.btnToDate);
        btnCheckDate = findViewById(R.id.btnCheckDate);
        btnFrom.setOnClickListener(this);
        btnToDate.setOnClickListener(this);
        btnCheckDate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFrom:
                clickOnFrom();
                break;
            case R.id.btnToDate:
                clickOnTo();
                break;
            case R.id.btnCheckDate:
                clickOnBtnCheck();
                break;
            default:
                break;
        }
    }

    private void clickOnBtnCheck() {
        try {
            String daycal = StaticUtils.getCountOfDays(btnFrom.getText().toString().trim(), btnToDate.getText().toString().toString());
            Toast.makeText(this, "Days: " + daycal, Toast.LENGTH_SHORT).show();
            } catch (ParseException e) {
            e.printStackTrace();
            Toast.makeText(this, "Prasing error", Toast.LENGTH_SHORT).show();
        }

    }

    private void clickOnFrom() {
        PopUtils.showDatePicker(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                int currentMonth = month + 1;
                btnFrom.setText(dayOfMonth + "/" + currentMonth + "/" + year);
            }
        });
    }

    private void clickOnTo() {
        PopUtils.showDatePicker(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                int currentMonth = month + 1;
                btnToDate.setText(dayOfMonth + "/" + currentMonth + "/" + year);
            }
        });
    }


}

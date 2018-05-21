package com.dailogexample.datetime;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dailogexample.R;

public class DatePickerDailogActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_start_date, btn_end_date;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        try {
            initComponents();
        } catch (Exception e) {
        }
    }

    private void initComponents() {
        btn_start_date.setOnClickListener(this);
        btn_end_date.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            default:
                break;
        }
    }

    private void clickOnStratDate() {


    }

    private void clickOnEndDate() {

    }

}

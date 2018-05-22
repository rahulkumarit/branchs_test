package com.dailogexample.services;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dailogexample.R;

public class ServiceAcivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStratService, btnStopService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        btnStratService = findViewById(R.id.btnStratService);
        btnStopService = findViewById(R.id.btnStopService);
        btnStratService.setOnClickListener(this);
        btnStopService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStratService:
                clickStratService();
                break;
            case R.id.btnStopService:
                clickStopService();
                break;
            default:
                break;
        }
    }

    private void clickStratService() {
        startService(new Intent(this, MyService.class));
    }

    private void clickStopService() {
        stopService(new Intent(this, MyService.class));
    }


}

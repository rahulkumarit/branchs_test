package com.dailogexample.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.dailogexample.R;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnFirst;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFirst = findViewById(R.id.btnFirst);
        btnFirst.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFirst:
                clickOnFirst();
                break;
            default:
                break;
        }
    }

    private void clickOnFirst() {
        NotificationMessage.notify(this,"xcx",1);


    }

}

package com.dailogexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private RecyclerView rvCartList;
    private ArrayList<Item> items = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        rvCartList = findViewById(R.id.rvCartList);
        prePareList();
    }

    private void prePareList() {
        //prepare arraylist android
        for (int i = 0; i < 5; i++) {
            Item item = new Item();
            item.setName("product " + i);
            item.setId("proId " + i);
            items.add(item);
         }
      }


}
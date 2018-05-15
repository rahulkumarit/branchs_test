package com.dailogexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CartActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rvCartList;
    private ArrayList<Item> items = new ArrayList<>();
    private ProgressBar progress;
    private Button btnContinue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        rvCartList = findViewById(R.id.rvCartList);
        progress = findViewById(R.id.progress);
        btnContinue = findViewById(R.id.btnContinue);
        btnContinue.setOnClickListener(this);
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
        CartAdapter cartAdapter = new CartAdapter(this, items);
        rvCartList.setLayoutManager(new LinearLayoutManager(this));
        rvCartList.setAdapter(cartAdapter);
    }

    private void clickOnContinue() {
        progress.setVisibility(View.VISIBLE);
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        final Map<String, Object> user = new HashMap<>();
        final ArrayList<HashMap<String, String>> items = new ArrayList<>();
        HashMap<String, String> item = new HashMap<>();

        for (int i = 0; i < items.size(); i++) {
            item.put("productId:", "xyz");
            item.put("price:", "100");
            items.add(item);
        }
        user.put("userId", "userId");
        user.put("tatalPrice:", "1000");
        user.put("items", items);

        db.collection("order").add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(CartActivity.this, "success", Toast.LENGTH_SHORT).show();
                        progress.setVisibility(View.GONE);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(CartActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                        progress.setVisibility(View.GONE);
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnContinue:
                clickOnContinue();
                break;
            default:
                break;
        }
    }

}
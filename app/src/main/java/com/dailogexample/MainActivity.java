package com.dailogexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private String[] country = {"Select Unit", "1Kg", "2Kg", "3Kg", "4Kg",};
    private Button btnChange, btnContinue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_order);
        btnChange = findViewById(R.id.btnChange);
        btnContinue = findViewById(R.id.btnContinue);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
        btnChange.setOnClickListener(this);
        btnContinue.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnContinue:
                clickOnbtnContinue();
                break;
            default:
                break;
        }
    }

    private void clickOnbtnContinue() {
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        final Map<String, Object> user = new HashMap<>();
        final ArrayList<HashMap<String, String>> items = new ArrayList<>();
        HashMap<String, String> item = new HashMap<>();
        item.put("productId:", "xyz");
        item.put("price:", "100");
        items.add(item);
        user.put("orderId", "order123456");
        user.put("userId", "userId");
        user.put("items", items);
        db.collection("order").add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
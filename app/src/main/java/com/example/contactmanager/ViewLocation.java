package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewLocation extends AppCompatActivity {

    Button btnViewLocationCancel;

    TextView tvLocationAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_location);

        btnViewLocationCancel = findViewById(R.id.btnViewLocationCancel);

        tvLocationAddress = findViewById(R.id.tvLocationAddress);

        btnViewLocationCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
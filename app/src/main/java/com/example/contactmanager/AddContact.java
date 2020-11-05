package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddContact extends AppCompatActivity {

    Button btnAddContactCancel, btnAddContactComplete, btnAddContactName, btnAddContactPhoneNumber,
            btnAddContactDateOfBirth, btnAddContactPhotograph, btnAddContactLocation,
            btnAddContactDescription;

    TextView tvAddContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        btnAddContactCancel = findViewById(R.id.btnAddContactCancel);
        btnAddContactComplete = findViewById(R.id.btnAddContactComplete);
        btnAddContactName = findViewById(R.id.btnAddContactName);
        btnAddContactPhoneNumber = findViewById(R.id.btnAddContactPhoneNumber);
        btnAddContactDateOfBirth = findViewById(R.id.btnAddContactDateOfBirth);
        btnAddContactPhotograph = findViewById(R.id.btnAddContactPhotograph);
        btnAddContactLocation = findViewById(R.id.btnAddContactLocation);
        btnAddContactDescription = findViewById(R.id.btnAddContactDescription);

        tvAddContact = findViewById(R.id.tvAddContact);

        btnAddContactCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnAddContactPhotograph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAddPhoto = new Intent(getApplicationContext(), AddPhoto.class);
                startActivity(goToAddPhoto);
            }
        });
    }
}
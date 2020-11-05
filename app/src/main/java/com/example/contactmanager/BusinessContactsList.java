package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BusinessContactsList extends AppCompatActivity {

    Button btnEditBusinessContact, btnAddBusinessContact;
    TextView tvBusinessContactList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_contacts_list);

        btnEditBusinessContact = findViewById(R.id.btnEditBusinessContact);
        btnAddBusinessContact = findViewById(R.id.btnAddBusinessContact);

        tvBusinessContactList = findViewById(R.id.tvBusinessContactsList);

        btnAddBusinessContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAddContact =  new Intent(getApplicationContext(), AddContact.class);
                startActivity(goToAddContact);
            }
        });
    }
}
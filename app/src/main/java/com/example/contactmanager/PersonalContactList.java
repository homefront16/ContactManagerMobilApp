package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

public class PersonalContactList extends AppCompatActivity {

    Button btnPersonalContactListEdit, btnPersonalContactListAddContact, btnPersonalContact1,
            btnPersonalContact2, btnPersonalContact3, btnPersonalContact4, btnPersonalContact5;

    SearchView searchPersonalContactList;

    TextView tvPersonalContactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_contact_list);

        btnPersonalContactListEdit = findViewById(R.id.btnPersonalContactListEdit);
        btnPersonalContactListAddContact = findViewById(R.id.btnPersonalContactListAddContact);
        btnPersonalContact1 = findViewById(R.id.btnPersonalContact1);
        btnPersonalContact2 = findViewById(R.id.btnPersonalContact2);
        btnPersonalContact3 = findViewById(R.id.btnPersonalContact3);
        btnPersonalContact4 = findViewById(R.id.btnPersonalContact4);
        btnPersonalContact5 = findViewById(R.id.btnPersonalContact5);

        searchPersonalContactList = findViewById(R.id.searchPersonalContacts);

        tvPersonalContactList = findViewById(R.id.tvPersonalContactList);

        btnPersonalContactListAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAddPhoto = new Intent(getApplicationContext(), AddPhoto.class);
                startActivity(goToAddPhoto);
            }
        });

        btnPersonalContact1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
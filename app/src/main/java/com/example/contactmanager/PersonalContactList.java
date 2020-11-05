package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

public class PersonalContactList extends AppCompatActivity {

    Button btnPersonalContactListEdit, btnPersonalContactListAddContact;

    SearchView searchPersonalContactList;

    TextView tvPersonalContactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_contact_list);

        btnPersonalContactListEdit = findViewById(R.id.btnPersonalContactListEdit);
        btnPersonalContactListAddContact = findViewById(R.id.btnPersonalContactListAddContact);


        searchPersonalContactList = findViewById(R.id.searchPersonalContacts);

        tvPersonalContactList = findViewById(R.id.tvPersonalContactList);

        btnPersonalContactListAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAddContact = new Intent(getApplicationContext(), AddContact.class);
                startActivity(goToAddContact);
            }
        });


    }
}
package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {

    Button btnPersonalContacts, btnBusinessContacts;

    SearchView searchMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPersonalContacts = findViewById(R.id.btnPersonalContacts);
        btnBusinessContacts = findViewById(R.id.btnBusinessContacts);


        searchMainActivity = findViewById(R.id.searchPersonalContacts);

        btnPersonalContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToPersonalContactList = new Intent(getApplicationContext(), PersonalContactList.class);
                startActivity(goToPersonalContactList);
            }
        });

        btnBusinessContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToBusinessContactList = new Intent(getApplicationContext(), BusinessContactsList.class);
                startActivity(goToBusinessContactList);
            }
        });


    }
}
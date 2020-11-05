package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AddPhoto extends AppCompatActivity {

    Button btnCancel, btnAddPhotoComplete;

    ImageButton imageAddPhotoDisplay, imageAddPhotoSelectPhotoToAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photo);

        btnCancel = findViewById(R.id.btnCancel);
        btnAddPhotoComplete = findViewById(R.id.btnAddPhotoComplete);
        imageAddPhotoDisplay = findViewById(R.id.imageAddPhotoDisplay);
        imageAddPhotoSelectPhotoToAdd = findViewById(R.id.imageAddPhotoSelectPhotoToAdd);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
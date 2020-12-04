package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.Serializers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    List<BaseContact> myListOfContacts;


    Button btnPersonalContacts, btnBusinessContacts;
    ListView lvContactList;
    SearchView searchMainActivity;
    PersonAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPersonalContacts = findViewById(R.id.btnPersonalContacts);
        btnBusinessContacts = findViewById(R.id.btnBusinessContacts);
        lvContactList = findViewById(R.id.lvContactList);

        searchMainActivity = findViewById(R.id.searchPersonalContacts);


        //AddressBook myAddressBook = new AddressBook(myListOfContacts);
        myListOfContacts = getJsonData();
        adapter = new PersonAdapter(MainActivity.this, myListOfContacts);
        lvContactList.setAdapter(adapter);



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

    private List<BaseContact> getJsonData(){
           /*
         Method will parse the local JSON file
         serialize the data in to base contact objects.
         Method will add base contact object to a list of base contacts
        */
        List<BaseContact> listOfContacts;
        Context context = this;
        InputStream s = context.getResources().openRawResource(R.raw.personcontactcorrect);
        String jsonString = new Scanner(s).useDelimiter("\\A").next();

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            ContactsWrapper contactsWrapper = new ObjectMapper().readerFor(ContactsWrapper.class).readValue(jsonString);
            listOfContacts = contactsWrapper.getContactList();

            return listOfContacts;
        }
        catch (JsonParseException e) {

            e.printStackTrace();

        } catch (JsonMappingException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;
    }
}
package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class BusinessContactsList extends AppCompatActivity {

    List<BusinessContact> businessContactList;
    BusinessContactListAdapter myAdapter;

    Button btnEditBusinessContact, btnAddBusinessContact;
    TextView tvBusinessContactList;

    ListView lvBusinessListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_contacts_list);

        btnEditBusinessContact = findViewById(R.id.btnEditBusinessContact);
        btnAddBusinessContact = findViewById(R.id.btnAddBusinessContact);
        tvBusinessContactList = findViewById(R.id.tvBusinessContactsList);
        lvBusinessListView = findViewById(R.id.lvBusinessContactList);

        businessContactList = getJsonData();
        myAdapter = new BusinessContactListAdapter(BusinessContactsList.this, businessContactList);
        lvBusinessListView.setAdapter(myAdapter);

        btnAddBusinessContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAddContact =  new Intent(getApplicationContext(), AddContact.class);
                startActivity(goToAddContact);
            }
        });
    }

    private List<BusinessContact> getJsonData(){
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

            AddressBook myAddressBook = new AddressBook(listOfContacts);
            businessContactList = myAddressBook.getBusinessContacts();


            return businessContactList;
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
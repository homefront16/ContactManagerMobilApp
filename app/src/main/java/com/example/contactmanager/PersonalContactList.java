package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class PersonalContactList extends AppCompatActivity {

    List<PersonContact> personalContactList;
    List<PersonContact> updatedPersonalContactList;
    PersonContactListAdapter myAdapter;
    Button btnPersonalContactListAddContact;

    SearchView searchPersonalContactList;

    TextView tvPersonalContactList;

    ListView lvPersonalContactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_contact_list);


        btnPersonalContactListAddContact = findViewById(R.id.btnPersonalContactListAddContact);
        searchPersonalContactList = findViewById(R.id.searchPersonalContacts);
        tvPersonalContactList = findViewById(R.id.tvPersonalContactList);
        lvPersonalContactList = findViewById(R.id.lvPersonalContactList);


        personalContactList = getJsonData();
        myAdapter = new PersonContactListAdapter(PersonalContactList.this, personalContactList);
        lvPersonalContactList.setAdapter(myAdapter);

        Bundle incomingIntent = getIntent().getExtras();
        // capture incoming data
        if(incomingIntent != null) {
            FileInputStream fileIn = null;
            try {
                List<BaseContact> listOfContacts;
                fileIn = openFileInput("personcontactcorrect2.json");
                InputStreamReader inputRead = new InputStreamReader(fileIn);
                String jsonString = new Scanner(inputRead).useDelimiter("\\A").next();
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                ContactsWrapper contactsWrapper = new ObjectMapper().readerFor(ContactsWrapper.class).readValue(jsonString);
                listOfContacts = contactsWrapper.getContactList();

                String positionToBeEdited = incomingIntent.getString("edit");

                if(positionToBeEdited != null){
                    int positionEdited = Integer.parseInt(positionToBeEdited);
                    if(positionEdited >= 0){
                        listOfContacts.remove(positionEdited);
                    }
                }


                AddressBook myAddressBook = new AddressBook(listOfContacts);
                updatedPersonalContactList = myAddressBook.getPersonContacts();

                myAdapter = new PersonContactListAdapter(PersonalContactList.this, updatedPersonalContactList);


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }

        lvPersonalContactList.setAdapter(myAdapter);

        lvPersonalContactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent goToPersonContactForm = new Intent(getApplicationContext(), PersonContactForm.class);

                PersonContact clickedPerson = personalContactList.get(position);

                goToPersonContactForm.putExtra("edit", String.valueOf(position));
                goToPersonContactForm.putExtra("name", clickedPerson.name);
                goToPersonContactForm.putExtra("dateOfBirth", clickedPerson.getDateOfBirth());
                goToPersonContactForm.putExtra("phoneNumber", clickedPerson.phoneNumber);
                goToPersonContactForm.putExtra("description", clickedPerson.getDescription());
                goToPersonContactForm.putExtra("street", clickedPerson.location.getStreet());
                goToPersonContactForm.putExtra("city", clickedPerson.location.getCity());
                goToPersonContactForm.putExtra("state", clickedPerson.location.getState());

                startActivity(goToPersonContactForm);
            }
        });

        btnPersonalContactListAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAddContact = new Intent(getApplicationContext(), PersonContactForm.class);
                startActivity(goToAddContact);
            }
        });


    }

    private List<PersonContact> getJsonData(){
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
            personalContactList = myAddressBook.getPersonContacts();

           /* for(int i = 0; i < listOfContacts.size(); i++){
                if(listOfContacts.get(i) instanceof PersonContact){
                    PersonContact myPerson = (PersonContact)listOfContacts.get(i);
                    personalContactList.add(myPerson);
                }
            }*/

            return personalContactList;
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
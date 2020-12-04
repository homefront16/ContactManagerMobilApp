package com.example.contactmanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonContactForm extends AppCompatActivity {

    List<BaseContact> listOfContacts;

    int positionToEdit = -1;

    Button btnAddContact, btnCancelPersonContact, btnRemovePersonContact;
    EditText etName, etDateOfBirth, etPhoneNumber, etDescription, etStreet, etCity, etState;
    ImageView ivPersonContactPhoto;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_person_contact_form);

        btnAddContact = findViewById(R.id.btnAddPersonContact);
        btnCancelPersonContact = findViewById(R.id.btnCancelAddPersonContact);
        btnRemovePersonContact = findViewById(R.id.btnRemovePersonContact);
        etName = findViewById(R.id.etPersonContactName);
        etDateOfBirth = findViewById(R.id.etPersonContactDateOfBirth);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etDescription = findViewById(R.id.etPersonContactDescription);
        etStreet = findViewById(R.id.etPersonContactStreet);
        etCity = findViewById(R.id.etPersonContactCity);
        etState = findViewById(R.id.etPersonContactState);
        ivPersonContactPhoto = findViewById(R.id.ivPersonContactPhoto);

        listOfContacts = getJsonData();


        btnRemovePersonContact.setVisibility(View.INVISIBLE);

        Bundle incomingIntent = getIntent().getExtras();
        // capture incoming data
        if(incomingIntent != null){

            btnRemovePersonContact.setVisibility(View.VISIBLE);
            String sentName = incomingIntent.getString("name");
            String sentDOB = incomingIntent.getString("dateOfBirth");
            String sentPhoneNumber = incomingIntent.getString("phoneNumber");
            String sentDescription = incomingIntent.getString("description");
            String sentStreet = incomingIntent.getString("street");
            String sentCity = incomingIntent.getString("city");
            String sentState = incomingIntent.getString("state");
            String positionToEdit2 = incomingIntent.getString("edit");


            positionToEdit = Integer.parseInt(positionToEdit2);
            etName.setText(sentName);
            etDateOfBirth.setText(sentDOB);
            etPhoneNumber.setText(sentPhoneNumber);
            etDescription.setText(sentDescription);
            etStreet.setText(sentStreet);
            etCity.setText(sentCity);
            etState.setText(sentState);

        }

        btnCancelPersonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnRemovePersonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent removeIntent = new Intent(v.getContext(), PersonalContactList.class);

                removeIntent.putExtra("remove", String.valueOf(1));
               // removeIntent.putExtra("edit", String.valueOf(positionToEdit));


                listOfContacts.remove(positionToEdit);
                AddressBook myAddressBook = new AddressBook(listOfContacts);

                ObjectMapper om = new ObjectMapper();

                ContactsWrapper contactsWrapper = new ContactsWrapper();
                contactsWrapper.setContactList(myAddressBook.getContactList());
                FileOutputStream fos = null;
                Gson gson = new Gson();
                String json = gson.toJson(contactsWrapper);

                try {
                    FileOutputStream fileout = openFileOutput("personcontactcorrect2.json", MODE_PRIVATE);
                    OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                    om.writerWithDefaultPrettyPrinter().writeValue(outputWriter, contactsWrapper);

                    outputWriter.close();

                    //display file saved message
                    Toast.makeText(getBaseContext(), "Contact Removed successfully!",
                            Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    e.printStackTrace();
                }


                startActivity(removeIntent);
            }
        });

        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newName = etName.getText().toString();
                String newDateOfBirth = etDateOfBirth.getText().toString();
                String newPhoneNumber = etPhoneNumber.getText().toString();
                String newDescription = etDescription.getText().toString();
                String newStreet = etStreet.getText().toString();
                String newCity = etCity.getText().toString();
                String newState = etState.getText().toString();

                Photo myPhoto = new Photo(2, "genericFileName.com", "10-22-19", "Great picture");
                List<Photo> myListOfPhotos = new ArrayList<Photo>();
                myListOfPhotos.add(myPhoto);

                Location myNewLocation = new Location(2, newStreet, newCity, newState);

                PersonContact addedContact = new PersonContact(newName, newPhoneNumber, newDateOfBirth, myListOfPhotos, myNewLocation, newDescription);

               //add contact to list and then write the list to a JSON file
                listOfContacts.add(addedContact);
                AddressBook myAddressBook = new AddressBook(listOfContacts);

                ObjectMapper om = new ObjectMapper();

                ContactsWrapper contactsWrapper = new ContactsWrapper();
                contactsWrapper.setContactList(myAddressBook.getContactList());
                FileOutputStream fos = null;
                Gson gson = new Gson();
                String json = gson.toJson(contactsWrapper);

                try {
                    FileOutputStream fileout = openFileOutput("personcontactcorrect2.json", MODE_PRIVATE);
                    OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                    om.writerWithDefaultPrettyPrinter().writeValue(outputWriter, contactsWrapper);

                    outputWriter.close();

                    //display file saved message
                    Toast.makeText(getBaseContext(), "Contact Added successfully!",
                            Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent myIntent = new Intent(v.getContext(), PersonalContactList.class);

                myIntent.putExtra("name", newName);
                myIntent.putExtra("dateOfBirth", newDateOfBirth);
                myIntent.putExtra("phoneNumber", newPhoneNumber);
                myIntent.putExtra("description", newDescription);
                myIntent.putExtra("street", newStreet);
                myIntent.putExtra("city", newCity);
                myIntent.putExtra("state", newState);
                myIntent.putExtra("edit", String.valueOf(positionToEdit));
                startActivity(myIntent);

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

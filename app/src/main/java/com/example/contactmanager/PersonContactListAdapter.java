package com.example.contactmanager;

import android.app.Activity;
import android.app.Person;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PersonContactListAdapter extends BaseAdapter {
    Activity mActivity;
    List<PersonContact> myContactList;

    public PersonContactListAdapter(Activity mActivity, List<PersonContact> myContactList){
        this.mActivity = mActivity;
        this.myContactList = myContactList;
    }

    @Override
    public int getCount() {
        return myContactList.size();
    }

    @Override
    public PersonContact getItem(int position) {
        return myContactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View onePersonalContactLine;

        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        onePersonalContactLine = inflater.inflate(R.layout.person_contact_one_line, parent, false);



        PersonContact myContact = this.getItem(position);
       // etName, etDateOfBirth, etPhoneNumber, etDescription, etStreet, etCity, etState
        ImageView ivPhoto = onePersonalContactLine.findViewById(R.id.ivPersonContactOneLinePhoto);
        TextView tvName = onePersonalContactLine.findViewById(R.id.tvPersonContactOneLineName);
        TextView tvDateOfBirth = onePersonalContactLine.findViewById(R.id.tvPersonContactOneLineDateOfBirth);
        TextView tvPhoneNumber = onePersonalContactLine.findViewById(R.id.tvPersonContactOneLinePhoneNumber);
        TextView tvDescription = onePersonalContactLine.findViewById(R.id.tvPersonContactOneLineDescription);
        TextView tvStreet = onePersonalContactLine.findViewById(R.id.tvPersonContactOneLineStreet);
        TextView tvCity = onePersonalContactLine.findViewById(R.id.tvPersonContactOneLineCity);
        TextView tvState = onePersonalContactLine.findViewById(R.id.tvPersonContactOneLineState);

        tvName.setText(myContact.name);
        tvDateOfBirth.setText(myContact.getDateOfBirth());
        tvPhoneNumber.setText(myContact.phoneNumber);
        tvDescription.setText(myContact.getDescription());
        tvStreet.setText(myContact.location.getStreet());
        tvCity.setText(myContact.location.getCity());
        tvState.setText(myContact.location.getState());

        int iconResourceNumbers [] = {
                R.drawable.avatar,
                R.drawable.avatar6,
                R.drawable.boy,
                R.drawable.boy2,
                R.drawable.boy3,
                R.drawable.boy4,
                R.drawable.boy5,
                R.drawable.boy6,
                R.drawable.boy7,
                R.drawable.boy8,
                R.drawable.boy9,
                R.drawable.male,
                R.drawable.male4,
                R.drawable.male5,
                R.drawable.man,
                R.drawable.man2,
                R.drawable.man3,
                R.drawable.man6,
                R.drawable.manavatar,
                R.drawable.manavatar2,
                R.drawable.manavatar3,
                R.drawable.oldman,
                R.drawable.person3,
                R.drawable.user,
                R.drawable.user2,
                R.drawable.young,
                R.drawable.youngman,
                R.drawable.youngman2,
                R.drawable.youngman3,
                R.drawable.youngman4
        };
        ivPhoto.setImageResource(iconResourceNumbers[position]);

        return onePersonalContactLine;
    }
}

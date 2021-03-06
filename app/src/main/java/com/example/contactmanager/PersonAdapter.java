package com.example.contactmanager;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PersonAdapter extends BaseAdapter {
    Activity mActivity;
    List<BaseContact> myContactList;

    public PersonAdapter(Activity mActivity, List<BaseContact> myContactList){
        this.mActivity = mActivity;
        this.myContactList = myContactList;
    }

    @Override
    public int getCount() {
        return myContactList.size();
    }

    @Override
    public BaseContact getItem(int position) {
        return myContactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View onePersonLine;

        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        onePersonLine = inflater.inflate(R.layout.person_line_item, parent, false);

        ImageView ivIcon = onePersonLine.findViewById(R.id.ivPhotoLineItem);
        TextView tvName = onePersonLine.findViewById(R.id.tvNameLineItem);
        TextView tvPhoneNumber = onePersonLine.findViewById(R.id.tvPhoneNumberLineItem);
        //TextView tvDateOfBirth = onePersonLine.findViewById(R.id.tvDateOfBirthLineItem);
       // TextView tvDescription = onePersonLine.findViewById(R.id.tvDescriptionLineItem);
        TextView tvLocation = onePersonLine.findViewById(R.id.tvLocationLineItem);

        BaseContact myContact = this.getItem(position);


        tvName.setText(myContact.name);
        tvPhoneNumber.setText(myContact.phoneNumber);
        tvLocation.setText(myContact.location.getCity() + ", " + myContact.location.getState());

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
        ivIcon.setImageResource(iconResourceNumbers[position]);

        return onePersonLine;
    }
}

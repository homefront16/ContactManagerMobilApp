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

public class BusinessContactListAdapter extends BaseAdapter {
    Activity mActivity;
    List<BusinessContact> myContactList;

    public BusinessContactListAdapter(Activity mActivity, List<BusinessContact> myContactList){
        this.mActivity = mActivity;
        this.myContactList = myContactList;
    }

    @Override
    public int getCount() {
        return myContactList.size();
    }

    @Override
    public BusinessContact getItem(int position) {
        return myContactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View oneBusinessContact;

        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        oneBusinessContact = inflater.inflate(R.layout.business_contact_one_line, parent, false);



        BusinessContact myContact = this.getItem(position);


        ImageView ivBusinessPhoto = oneBusinessContact.findViewById(R.id.ivBusinessOneLinePhoto);
        TextView tvName = oneBusinessContact.findViewById(R.id.tvBusinessNameOneLine);
        TextView tvURL = oneBusinessContact.findViewById(R.id.tvBusinessURLOneLine);
        TextView tvBusinessHours = oneBusinessContact.findViewById(R.id.tvBusinessHoursOneLine);
        TextView tvBusinessDays = oneBusinessContact.findViewById(R.id.tvBusinessDaysOneLine);
        TextView tvBusinessPhone = oneBusinessContact.findViewById(R.id.tvBusinessPhoneOneLine);

        tvName.setText(myContact.name);
        tvURL.setText(myContact.getWebsiteURL());
        tvBusinessHours.setText(myContact.getBusinessHours());
        tvBusinessDays.setText(myContact.getBusinessDays());
        tvBusinessPhone.setText(myContact.getPhoneNumber());

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
        ivBusinessPhoto.setImageResource(iconResourceNumbers[position]);

        return oneBusinessContact;
    }
}

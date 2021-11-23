package com.example.animalcare.documents.contacts;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.animalcare.R;

public class ContactListWrapper {
    public ImageView contactImageView;
    public TextView nameView;
    public ImageView contactView;

    public ContactListWrapper(View root){
        contactImageView = root.findViewById(R.id.contact_item_contact_image);
        nameView = root.findViewById(R.id.contact_item_name);
        contactView = root.findViewById(R.id.contact_item_contact);
    }
}

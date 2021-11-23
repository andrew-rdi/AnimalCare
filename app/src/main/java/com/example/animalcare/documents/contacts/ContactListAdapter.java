package com.example.animalcare.documents.contacts;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;

import com.example.animalcare.R;

import java.util.ArrayList;

public class ContactListAdapter extends ArrayAdapter<ContactVO> {
    Context context;
    ArrayList<ContactVO> datas;
    int resId;

    public ContactListAdapter(Context context, int resId, ArrayList<ContactVO> datas) {
        super(context, resId);
        this.context = context;
        this.datas = datas;
        this.resId = resId;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId, null);

            ContactListWrapper wrapper = new ContactListWrapper(convertView);
            convertView.setTag(wrapper);
        }

        ContactListWrapper wrapper = (ContactListWrapper)convertView.getTag();
        ImageView contactImageView = wrapper.contactImageView;
        TextView nameView = wrapper.nameView;
        final ImageView contactView = wrapper.contactView;

        final ContactVO vo = datas.get(position);
        nameView.setText(vo.name);

        contactView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vo.phone != null && !vo.phone.equals("")) {
                    MyApplication myApplication = (MyApplication)context.getApplicationContext();
                    if (myApplication.callPermission) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:"+vo.phone));
                        context.startActivity(intent);
                    } else {
                        Toast t = Toast.makeText(context, R.string.permission_error, Toast.LENGTH_SHORT);
                        t.show();
                    }
                } else {
                    Toast t = Toast.makeText(context, R.string.contact_list_phonr_error, Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });

        if (vo.photo != null && !vo.photo.equals("")){
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 10;
            Bitmap bitmap = BitmapFactory.decodeFile(vo.photo, options);
            if (bitmap != null) {
                contactImageView.setImageBitmap(bitmap);
            }
        } else {
            contactImageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_contact_large, null));
        }

        contactImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View root = inflater.inflate(R.layout.dialog_contact_image, null);
                ImageView imageView = root.findViewById(R.id.dialog_image);
                if (vo.photo != null && !vo.photo.equals("")){
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 10;
                    Bitmap bitmap = BitmapFactory.decodeFile(vo.photo, options);
                    if (bitmap != null) {
                        imageView.setImageBitmap(bitmap);
                    }
                } else {
                    imageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_contact_large, null));
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setView(root);
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        return convertView;
    }
}

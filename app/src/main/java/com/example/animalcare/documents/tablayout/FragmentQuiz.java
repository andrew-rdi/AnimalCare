package com.example.animalcare.documents.tablayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.animalcare.BeginActivity;
import com.example.animalcare.MainActivity;
import com.example.animalcare.R;
import com.example.animalcare.documents.books.ReadBook;
import com.example.animalcare.documents.contacts.Contacts;

public class FragmentQuiz extends Fragment {

    View view;

    public FragmentQuiz() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.quiz_fragment, container, false);

        ImageView contacts = view.findViewById(R.id.contacts);
        contacts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Contacts.class);
                startActivity(intent);
            }
        });

        //todopdf_text
        TextView books_contacts = view.findViewById(R.id.books_contacts);
        books_contacts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Contacts.class);
                startActivity(intent);
            }
        });

        //button_back_tabl
        Button button_back_contacts =  view.findViewById(R.id.button_back_contacts);
        button_back_contacts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), BeginActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}

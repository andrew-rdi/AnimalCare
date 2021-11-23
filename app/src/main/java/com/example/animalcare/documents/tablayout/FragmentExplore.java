package com.example.animalcare.documents.tablayout;


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
import com.example.animalcare.R;
import com.example.animalcare.documents.PdfInput;
import com.example.animalcare.documents.books.ReadBook;


public class FragmentExplore extends Fragment {
    View view;

    public FragmentExplore() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.explore_fragment, container, false);

        ImageView books = view.findViewById(R.id.books);
        books.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ReadBook.class);
                startActivity(intent);
            }
        });

        //todopdf_text
        TextView books_text = view.findViewById(R.id.books_text);
        books_text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ReadBook.class);
                startActivity(intent);
            }
        });

        //button_back_tabl
        Button button_back_books =  view.findViewById(R.id.button_back_books);
        button_back_books.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), BeginActivity.class);
                startActivity(intent);
            }
        });

        return view;

    }

}




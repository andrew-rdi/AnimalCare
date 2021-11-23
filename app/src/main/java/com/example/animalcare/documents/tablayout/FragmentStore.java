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

public class FragmentStore extends Fragment {
    View view;
    public FragmentStore() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.store_fragment, container, false);

        ImageView todopdf = (ImageView) view.findViewById(R.id.todopdf);
        todopdf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PdfInput.class);
                startActivity(intent);
            }
        });

        //todopdf_text
        TextView todopdf_text = (TextView) view.findViewById(R.id.todopdf_text);
        todopdf_text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PdfInput.class);
                startActivity(intent);
            }
        });

        //button_back_tabl
        Button button_back_tabl = (Button) view.findViewById(R.id.button_back_tabl);
        button_back_tabl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), BeginActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}

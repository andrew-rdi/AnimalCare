package com.example.animalcare.shelter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animalcare.R;
import com.example.animalcare.gameforpet.GameForPet;
import com.example.animalcare.gameforpet.traninglist.TrainingCat;
import com.example.animalcare.gameforpet.traninglist.TrainingDoc;
import com.example.animalcare.gameforpet.traninglist.TrainingFish;
import com.example.animalcare.gameforpet.traninglist.TrainingParrot;
import com.example.animalcare.gameforpet.traninglist.TrainingRodent;
import com.example.animalcare.gameforpet.traninglist.TrainingTurtle;

public class SheltersForPet extends AppCompatActivity {

    ListView listView_shelters;
    String mTitle [] = {"Сіріус", "Happy Paw", "SOS", "Gaia", "Вольєр №1"};
    String mDescription[] = {"притулок для тварин", "благодійний фонд", "організація із захисту тварин", "притулок для тварин", "домашній невеликий притулок", };
    int images[] = {R.drawable.sirius, R.drawable.happypaw, R.drawable.sos, R.drawable.gaia, R.drawable.homeshelter};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelters_for_pet);

        //button_back_training
        Button button_back_shelters = findViewById(R.id.button_back_shelters);
        button_back_shelters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //начало конструкции
                try {
                    Intent intent = new Intent(SheltersForPet.this, Shelter.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                //конец конструкции
            }
        });

        listView_shelters = findViewById(R.id.listView_shelters);

        SheltersForPet.MyAdapter adapter = new SheltersForPet.MyAdapter(this, mTitle, mDescription, images);
        listView_shelters.setAdapter(adapter);

        listView_shelters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(SheltersForPet.this, "притулок для тварин", Toast.LENGTH_SHORT).show();
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/%D0%9F%D1%80%D0%B8%D1%82%D1%83%D0%BB%D0%BE%D0%BA+%D0%B4%D0%BB%D1%8F+%D0%B1%D0%B5%D0%B7%D0%BF%D1%80%D0%B8%D1%82%D1%83%D0%BB%D1%8C%D0%BD%D0%B8%D1%85+%D1%81%D0%BE%D0%B1%D0%B0%D0%BA+%D0%A1%D1%96%D1%80%D1%96%D1%83%D1%81/@50.8784252,30.2680709,15z/data=!4m5!3m4!1s0x0:0xddd2d64eb804a37f!8m2!3d50.8784252!4d30.2680709"));
                        startActivity(browserIntent);
                        finish();
                    } catch (Exception e) {

                    }
                }
                if (position == 1) {
                    Toast.makeText(SheltersForPet.this, "благодійний фонд", Toast.LENGTH_SHORT).show();
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/%D0%A2%D0%BE%D0%B2%D0%B0%D1%80%D0%B8%D1%81%D1%82%D0%B2%D0%BE+%D0%B7%D0%B0%D1%85%D0%B8%D1%81%D1%82%D1%83+%D1%82%D0%B2%D0%B0%D1%80%D0%B8%D0%BD+%E2%80%9CSOS%E2%80%9D/@50.3317498,30.5323915,15z/data=!4m5!3m4!1s0x0:0x71d6a4acb4bc75e2!8m2!3d50.3317498!4d30.5323915"));
                        startActivity(browserIntent);
                        finish();
                    } catch (Exception e) {

                    }
                }

                if (position == 2) {
                    Toast.makeText(SheltersForPet.this, "організація із захисту тварин", Toast.LENGTH_SHORT).show();
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/%D0%A2%D0%BE%D0%B2%D0%B0%D1%80%D0%B8%D1%81%D1%82%D0%B2%D0%BE+%D0%B7%D0%B0%D1%85%D0%B8%D1%81%D1%82%D1%83+%D1%82%D0%B2%D0%B0%D1%80%D0%B8%D0%BD+%E2%80%9CSOS%E2%80%9D/@50.3317498,30.5323915,15z/data=!4m5!3m4!1s0x0:0x71d6a4acb4bc75e2!8m2!3d50.3317498!4d30.5323915"));
                        startActivity(browserIntent);
                        finish();
                    } catch (Exception e) {

                    }
                }

                if (position == 3) {
                    Toast.makeText(SheltersForPet.this, "притулок для тварин", Toast.LENGTH_SHORT).show();
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://dogicat.com.ua/"));
                        startActivity(browserIntent);
                        finish();
                    } catch (Exception e) {

                    }
                }

                if (position == 4) {
                    Toast.makeText(SheltersForPet.this, "домашній невеликий притулок", Toast.LENGTH_SHORT).show();
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://helpdog.org.ua/"));
                        startActivity(browserIntent);
                        finish();
                    } catch (Exception e) {

                    }
                }

            }
        });
    }
    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImags[];

        MyAdapter (Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.itemrow_shelters, R.id.text_shelters_1, title);
            this.context =c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImags = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row  = layoutInflater.inflate(R.layout.itemrow_shelters, parent, false);
            ImageView images = row.findViewById(R.id.image_shelters);
            TextView myTitle = row.findViewById(R.id.text_shelters_1);
            TextView myDescription = row.findViewById(R.id.text_shelters_2);
            images.setImageResource(rImags[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }
    }
    //системная кнопка - начало
    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(SheltersForPet.this, Shelter.class);
            startActivity(intent);
            finish();
        }catch (Exception e) {

        }
    }
    //системная кнопка - конец
}


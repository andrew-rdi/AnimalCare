package com.example.animalcare.hotel;

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

import com.example.animalcare.BeginActivity;
import com.example.animalcare.R;
import com.example.animalcare.health.allergyreminder.AllergyReminder;
import com.example.animalcare.health.analisreminder.AnalisReminder;
import com.example.animalcare.health.diseasereminder.DiseaseReminder;
import com.example.animalcare.health.operationreminder.OperationReminder;
import com.example.animalcare.health.veterinarianreminder.VeterinarianReminder;
import com.example.animalcare.shelter.Shelter;

public class Hotels extends AppCompatActivity {

    ListView listView_hotels;
    String mTitle [] = {"Готель", "Готель «Друг»", "Готель «Cathotel»", "Sandra Groom", "Готель «Barkly»"};
    String mDescription[] = {"готель для собак та котів", "готель для тварин під наглядом ветеринарів в Києві", "готель для котів і кішок «Cathotel»", "готель для тварин «SandraGroom»", "готель для собак і котів"};
    int images[] = {R.drawable.cathol, R.drawable.friend, R.drawable.catshotels, R.drawable.sandrapng,  R.drawable.barklyjpg};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        //button_back_hotels
        Button button_back_hotels = findViewById(R.id.button_back_hotels);
        button_back_hotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //начало конструкции
                try {
                    Intent intent = new Intent(Hotels.this, Shelter.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                //конец конструкции
            }
        });


        listView_hotels =findViewById(R.id.listView_hotels);

        Hotels.MyAdapter adapter = new Hotels.MyAdapter(this, mTitle, mDescription, images);
        listView_hotels.setAdapter(adapter);

        listView_hotels.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(Hotels.this, "готель для собак та котів", Toast.LENGTH_SHORT).show();
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com.ua/maps/place/Hotel%CA%B9+Dlya+Sobak+Ta+Kotiv/@50.4341815,30.431967,17z/data=!4m13!1m7!3m6!1s0x40d4cc1cce2c208b:0xb710358b8adf9e86!2z0J7RgtGA0LDQtNC90YvQuSDQv9GA0L7RgdC_LiwgMzEsINCa0LjQtdCyLCAwMjAwMA!3b1!8m2!3d50.4341815!4d30.4341557!3m4!1s0x40d4cc1ccf4f7e07:0xbfa089c24802d4b8!8m2!3d50.4341869!4d30.4341593?hl=ru"));
                        startActivity(browserIntent);
                        finish();
                    } catch (Exception e) {

                    }
                }
                if (position == 1) {
                    Toast.makeText(Hotels.this, "готель для тварин під наглядом ветеринарів в Києві", Toast.LENGTH_SHORT).show();
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com.ua/maps/place/%D0%94%D1%80%D1%83%D0%B3/@50.3957965,30.6411544,17z/data=!4m13!1m7!3m6!1s0x40d4c44e273234b1:0x549ab319c36ceb6e!2z0YPQuy4g0JvQsNGA0LjRgdGLINCg0YPQtNC10L3QutC-LCAxMSwg0JrQuNC10LIsIDAyMDAw!3b1!8m2!3d50.3957965!4d30.6433431!3m4!1s0x40d4c44e20030f03:0xe9e87b03f75371a0!8m2!3d50.395914!4d30.642971?hl=ru"));
                        startActivity(browserIntent);
                        finish();
                    } catch (Exception e) {

                    }
                }

                if (position == 2) {
                    Toast.makeText(Hotels.this, "готель для котів і кішок «Cathotel»", Toast.LENGTH_SHORT).show();
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/%D0%93%D0%BE%D1%81%D1%82%D0%B8%D0%BD%D0%B8%D1%86%D0%B0+%D0%B4%D0%BB%D1%8F+%D0%BA%D0%BE%D1%82%D0%BE%D0%B2+%D0%B8+%D0%BA%D0%BE%D1%88%D0%B5%D0%BA+%C2%ABCathotel%C2%BB/@50.494512,30.439765,15z/data=!4m5!3m4!1s0x0:0x4a9789a2d7b9ae58!8m2!3d50.494512!4d30.439765"));
                        startActivity(browserIntent);
                        finish();
                    } catch (Exception e) {

                    }
                }

                if (position == 3) {
                    Toast.makeText(Hotels.this, "готель для тварин «SandraGroom»", Toast.LENGTH_SHORT).show();
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?rlz=1C1SQJL_ruUA841UA841&tbm=lcl&sxsrf=ACYBGNQrHFNEAidPHXu86vOx0vpOiuq0Jw%3A1580667377294&ei=8RE3Xp3JEdDcrgT5gInQBA&q=%D0%93%D0%BE%D1%81%D1%82%D0%B8%D0%BD%D0%B8%D1%86%D0%B0+%D0%B4%D0%BB%D1%8F+%D0%B6%D0%B8%D0%B2%D0%BE%D1%82%D0%BD%D1%8B%D1%85+SandraGroom&oq=%D0%93%D0%BE%D1%81%D1%82%D0%B8%D0%BD%D0%B8%D1%86%D0%B0+%D0%B4%D0%BB%D1%8F+%D0%B6%D0%B8%D0%B2%D0%BE%D1%82%D0%BD%D1%8B%D1%85+SandraGroom&gs_l=psy-ab.3..0i22i10i30i42k1j38.1614696.1614696.0.1618649.1.1.0.0.0.0.267.267.2-1.1.0....0...1c.1.64.psy-ab..0.1.266....0.70AE5Bbyzp0#rlfi=hd:;si:2045892349836108964;mv:[[50.4744762,30.489329400000003],[50.428921499999994,30.409311600000002]]"));
                        startActivity(browserIntent);
                        finish();
                    } catch (Exception e) {

                    }
                }

                if (position == 4) {
                    Toast.makeText(Hotels.this, "готель для собак і котів", Toast.LENGTH_SHORT).show();
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/%D0%91%D0%B0%D1%80%D0%BA%D0%BB%D0%B8+(Barkly)+-+%D0%BE%D1%82%D0%B5%D0%BB%D1%8C+%D0%B4%D0%BB%D1%8F+%D0%B4%D0%BE%D0%BC%D0%B0%D1%88%D0%BD%D0%B8%D1%85+%D0%B6%D0%B8%D0%B2%D0%BE%D1%82%D0%BD%D1%8B%D1%85,+%D0%B3%D1%80%D1%83%D0%BC%D0%B8%D0%BD%D0%B3/@50.4362735,30.4311793,15z/data=!4m5!3m4!1s0x0:0x8c117a2574b0a415!8m2!3d50.4362735!4d30.4311793"));
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
            super(c, R.layout.itemrow_hotels, R.id.text_hotels_1, title);
            this.context =c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImags =imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row  = layoutInflater.inflate(R.layout.itemrow_hotels, parent, false);
            ImageView images = row.findViewById(R.id.image_hotels);
            TextView myTitle = row.findViewById(R.id.text_hotels_1);
            TextView myDescription = row.findViewById(R.id.text_hotels_2);
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
            Intent intent = new Intent(Hotels.this, Shelter.class);
            startActivity(intent);
            finish();
        }catch (Exception e) {

        }
    }
    //системная кнопка - конец

}

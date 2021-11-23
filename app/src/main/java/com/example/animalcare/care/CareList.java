package com.example.animalcare.care;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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
import com.example.animalcare.care.clawsreminder.ClawsReminder;
import com.example.animalcare.care.earreminder.EarReminder;
import com.example.animalcare.care.eatreminder.EatReminder;
import com.example.animalcare.care.gamereminder.GameReminder;
import com.example.animalcare.care.teethreminder.TeethReminder;
import com.example.animalcare.care.vitaminsreminder.VitaminsReminder;
import com.example.animalcare.care.woolreminder.WoolReminder;
import com.example.animalcare.health.Health;
import com.example.animalcare.notes.Notes;
import com.example.animalcare.reminder.Reminder;

public class CareList extends AppCompatActivity {

    ListView listView_carelist;
    String mTitle [] = {"Шерсть", "Ванна", "Вуха", "Пазурі", "Зуби", "Вітаміни", "Харчування", " Ігри"};
    String mDescription[] = {"розчешіть свого вихованця", "водні процедури", "почистити вуха тварині", "стрижка пазурів", "перевірте зуби тварини", "прийом вітамінів", "приймання їжі", "ігри"};
    int images[] = {R.drawable.wool, R.drawable.water, R.drawable.earpng, R.drawable.clawspng, R.drawable.teethpng, R.drawable.vitamin, R.drawable.eat, R.drawable.ball};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_list);
        listView_carelist =findViewById(R.id.listView_carelist);


        //button_back_carelist
        Button button_back_carelist = (Button)findViewById(R.id.button_back_carelist);
        button_back_carelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //начало конструкции
                try {
                    Intent intent = new Intent(CareList.this, BeginActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                //конец конструкции
            }
        });


        CareList.MyAdapter adapter = new CareList.MyAdapter(this, mTitle, mDescription, images);
        listView_carelist.setAdapter(adapter);

        listView_carelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(CareList.this, "розчешіть свого вихованця", Toast.LENGTH_SHORT).show();
                    try {
                        Intent intent = new Intent(CareList.this, WoolReminder.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e){

                    }
                }

                if (position == 1) {
                    Toast.makeText(CareList.this, "водні процедури", Toast.LENGTH_SHORT).show();
                    try {
                        Intent intent = new Intent(CareList.this, CareReminder.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e){

                    }
                }
                if (position == 2) {
                    Toast.makeText(CareList.this, "почистити вуха тварині", Toast.LENGTH_SHORT).show();
                    try {
                        Intent intent = new Intent(CareList.this, EarReminder.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e){

                    }
                }
                if (position == 3) {
                    Toast.makeText(CareList.this, "стрижка пазурів", Toast.LENGTH_SHORT).show();
                    try {
                        Intent intent = new Intent(CareList.this, ClawsReminder.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e){

                    }
                }
                if (position == 4) {
                    Toast.makeText(CareList.this, "перевірте зуби тварини", Toast.LENGTH_SHORT).show();
                    try {
                        Intent intent = new Intent(CareList.this, TeethReminder.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e){

                    }
                }
                if (position == 5) {
                    Toast.makeText(CareList.this, "прийом вітамінів", Toast.LENGTH_SHORT).show();
                    try {
                        Intent intent = new Intent(CareList.this, VitaminsReminder.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e){

                    }
                }
                if (position == 6) {
                    Toast.makeText(CareList.this, "приймання їжі", Toast.LENGTH_SHORT).show();
                    try {
                        Intent intent = new Intent(CareList.this, EatReminder.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e){

                    }
                }
                if (position == 7) {
                    Toast.makeText(CareList.this, "ігри", Toast.LENGTH_SHORT).show();
                    try {
                        Intent intent = new Intent(CareList.this, GameReminder.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e){

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
            super(c, R.layout.itemrow_carelist, R.id.text_carelist_1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImags = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row  = layoutInflater.inflate(R.layout.itemrow_carelist, parent, false);
            ImageView images = row.findViewById(R.id.image_carelist);
            TextView myTitle = row.findViewById(R.id.text_carelist_1);
            TextView myDescription = row.findViewById(R.id.text_carelist_2);
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
            Intent intent = new Intent(CareList.this, BeginActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e) {

        }
    }
    //системная кнопка - конец
}

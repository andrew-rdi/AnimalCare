package com.example.animalcare.health;

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
import com.example.animalcare.care.CareList;
import com.example.animalcare.health.allergyreminder.AllergyReminder;
import com.example.animalcare.health.analisreminder.AnalisReminder;
import com.example.animalcare.health.diseasereminder.DiseaseReminder;
import com.example.animalcare.health.operationreminder.OperationReminder;
import com.example.animalcare.health.veterinarianreminder.VeterinarianReminder;
import com.example.animalcare.notes.Notes;

public class HealthList extends AppCompatActivity {

    ListView listView_health;
    String mTitle [] = {"Ветеринар", "Алергія", "Хвороби", "Операції", "Аналізи"};
    String mDescription[] = {"відвідування ветклініки", "прийняття засобів від алергії", "історія хвороб", "проведення операцій", "здача аналізів"};
    int images[] = {R.drawable.wetr, R.drawable.alergi, R.drawable.history, R.drawable.operation, R.drawable.analispng};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_list);

        //button_back_healthlist
        Button button_back_healthlist = (Button)findViewById(R.id.button_back_healthlist);
        button_back_healthlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //начало конструкции
                try {
                    Intent intent = new Intent(HealthList.this, BeginActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                //конец конструкции
            }
        });


        listView_health =findViewById(R.id.listView_health);

        HealthList.MyAdapter adapter = new HealthList.MyAdapter(this, mTitle, mDescription, images);
        listView_health.setAdapter(adapter);

        listView_health.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(HealthList.this, "відвідування ветклініки", Toast.LENGTH_SHORT).show();
                    try {
                        Intent intent = new Intent(HealthList.this, VeterinarianReminder.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {

                    }
                }
                if (position == 1) {
                    Toast.makeText(HealthList.this, "прийняття засобів від алергії", Toast.LENGTH_SHORT).show();
                    try {
                        Intent intent = new Intent(HealthList.this, AllergyReminder.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {

                    }
                }
                if (position == 2) {
                    Toast.makeText(HealthList.this, "історія хвороб", Toast.LENGTH_SHORT).show();
                    try {
                        Intent intent = new Intent(HealthList.this, DiseaseReminder.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {

                    }

                }
                if (position == 3) {
                    Toast.makeText(HealthList.this, "проведення операцій", Toast.LENGTH_SHORT).show();
                    try {
                        Intent intent = new Intent(HealthList.this, OperationReminder.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {

                    }
                }
                if (position == 4) {
                    Toast.makeText(HealthList.this, "здача аналізів", Toast.LENGTH_SHORT).show();
                    try {
                        Intent intent = new Intent(HealthList.this, AnalisReminder.class);
                        startActivity(intent);
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
            super(c, R.layout.itemrow, R.id.text_wet_1, title);
            this.context =c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImags =imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row  = layoutInflater.inflate(R.layout.itemrow, parent, false);
            ImageView images = row.findViewById(R.id.image_wet);
            TextView myTitle = row.findViewById(R.id.text_wet_1);
            TextView myDescription = row.findViewById(R.id.text_wet_2);
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
            Intent intent = new Intent(HealthList.this, BeginActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e) {

        }
    }
    //системная кнопка - конец
}

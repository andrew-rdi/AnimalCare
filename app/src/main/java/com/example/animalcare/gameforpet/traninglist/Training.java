package com.example.animalcare.gameforpet.traninglist;

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
import com.example.animalcare.gameforpet.GameForPet;
import com.example.animalcare.health.allergyreminder.AllergyReminder;
import com.example.animalcare.health.analisreminder.AnalisReminder;
import com.example.animalcare.health.diseasereminder.DiseaseReminder;
import com.example.animalcare.health.operationreminder.OperationReminder;
import com.example.animalcare.health.veterinarianreminder.VeterinarianReminder;

public class Training extends AppCompatActivity {

    ListView listView_training;
    String mTitle [] = {"Собаки", "Коти", "Птахи", "Гризуни", "Риби", "Черепахи"};
    String mDescription[] = {"дресирування та ігри для собак", "топ-10 іграшок для котів", "Птахи", "приділення уваги гризунам", "здоров'я акваріумних риб", "Черепахи"};
    int images[] = {R.drawable.doc, R.drawable.cat, R.drawable.parrot, R.drawable.rodent, R.drawable.fish,  R.drawable.turtle};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        //button_back_training
        Button button_back_training = findViewById(R.id.button_back_training);
        button_back_training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //начало конструкции
                try {
                    Intent intent = new Intent(Training.this, GameForPet.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                //конец конструкции
            }
        });


        listView_training =findViewById(R.id.listView_training);

        Training.MyAdapter adapter = new Training.MyAdapter(this, mTitle, mDescription, images);
        listView_training.setAdapter(adapter);

        listView_training.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(Training.this, "дресирування та ігри для собак", Toast.LENGTH_SHORT).show();
                    try {
                        Intent intent = new Intent(Training.this, TrainingDoc.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {

                    }
                }
                if (position == 1) {
                    Toast.makeText(Training.this, "топ-10 іграшок для котів", Toast.LENGTH_SHORT).show();
                    try {
                        Intent intent = new Intent(Training.this, TrainingCat.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {

                    }
                }
                if (position == 2) {
                    Toast.makeText(Training.this, "Птахи", Toast.LENGTH_SHORT).show();
                    try {
                        Intent intent = new Intent(Training.this, TrainingParrot.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {

                    }

                }
                if (position == 3) {
                    Toast.makeText(Training.this, "приділення уваги гризунам", Toast.LENGTH_SHORT).show();
                    try {
                        Intent intent = new Intent(Training.this, TrainingRodent.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {

                    }
                }

                if (position == 4) {
                    Toast.makeText(Training.this, "здоров'я акваріумних риб", Toast.LENGTH_SHORT).show();
                    try {
                        Intent intent = new Intent(Training.this, TrainingFish.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {

                    }
                }

                if (position == 5) {
                    Toast.makeText(Training.this, "Черепахи", Toast.LENGTH_SHORT).show();
                    try {
                        Intent intent = new Intent(Training.this, TrainingTurtle.class);
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
            super(c, R.layout.itemrowgame, R.id.text_training_1, title);
            this.context =c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImags =imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row  = layoutInflater.inflate(R.layout.itemrowgame, parent, false);
            ImageView images = row.findViewById(R.id.image_training);
            TextView myTitle = row.findViewById(R.id.text_training_1);
            TextView myDescription = row.findViewById(R.id.text_training_2);
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
            Intent intent = new Intent(Training.this, GameForPet.class);
            startActivity(intent);
            finish();
        }catch (Exception e) {

        }
    }
    //системная кнопка - конец
}

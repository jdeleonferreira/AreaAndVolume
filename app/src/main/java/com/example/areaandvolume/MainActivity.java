package com.example.areaandvolume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView optionsList;
    private String[] mainOptions;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainOptions = getResources().getStringArray(R.array.options);
        optionsList = findViewById(R.id.lstOptions);

        optionsList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mainOptions));

        optionsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        intent = new Intent(MainActivity.this
                                , Areas.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this
                                , Volumes.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this
                                , PerformedActions.class);
                        startActivity(intent);
                        break;
                }
            }
        });

    }
}
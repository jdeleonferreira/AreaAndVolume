package com.example.areaandvolume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.areaandvolume.area.*;

import com.example.areaandvolume.area.SquareActivity;

public class AreasActivity extends AppCompatActivity {

    private ListView areaList;
    private String[] areaOptions;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas);

        areaOptions = getResources().getStringArray(R.array.areas_options);
        areaList = findViewById(R.id.lstAreas);

        areaList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, areaOptions));

        areaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        intent = new Intent(AreasActivity.this, SquareActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(AreasActivity.this, RectangleActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(AreasActivity.this, TriangleActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(AreasActivity.this, CircleActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
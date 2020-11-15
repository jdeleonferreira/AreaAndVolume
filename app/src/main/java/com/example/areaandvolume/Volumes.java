package com.example.areaandvolume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.areaandvolume.area.Circle;
import com.example.areaandvolume.area.Rectangle;
import com.example.areaandvolume.area.Square;
import com.example.areaandvolume.area.Triangle;
import com.example.areaandvolume.volume.Cone;
import com.example.areaandvolume.volume.Cube;
import com.example.areaandvolume.volume.Cylinder;
import com.example.areaandvolume.volume.Sphere;

public class Volumes extends AppCompatActivity {

    private ListView volumeList;
    private String[] volumeOptions;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumes);

        volumeOptions = getResources().getStringArray(R.array.volumes_options);
        volumeList = findViewById(R.id.lstVolume);

        volumeList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, volumeOptions));

        volumeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        intent = new Intent(Volumes.this, Sphere.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(Volumes.this, Cylinder.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Volumes.this, Cone.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Volumes.this, Cube.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
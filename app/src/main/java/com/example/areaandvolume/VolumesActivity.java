package com.example.areaandvolume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.areaandvolume.volume.ConeActivity;
import com.example.areaandvolume.volume.CubeActivity;
import com.example.areaandvolume.volume.CylinderActivity;
import com.example.areaandvolume.volume.SphereActivity;

public class VolumesActivity extends AppCompatActivity {

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
                        intent = new Intent(VolumesActivity.this, SphereActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(VolumesActivity.this, CylinderActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(VolumesActivity.this, ConeActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(VolumesActivity.this, CubeActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
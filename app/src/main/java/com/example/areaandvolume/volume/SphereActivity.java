package com.example.areaandvolume.volume;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.areaandvolume.R;
import com.example.areaandvolume.data.DataSource;
import com.example.areaandvolume.domain.Sphere;

public class SphereActivity extends AppCompatActivity {

    private Sphere sp = new Sphere();
    private EditText txtRadius;
    private TextView lblSphereVolume;
    private TextView lblSphereResultTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere);

        txtRadius = findViewById(R.id.txtConeSide);
        lblSphereVolume = findViewById(R.id.lblConeVolume);
        lblSphereResultTitle = findViewById(R.id.lblConeResultTitle);

    }

    public void calculateVolume(View v){
        if(validate()) {
            sp.setRadius(Double.parseDouble(String.valueOf(txtRadius.getText())));
            sp.setPerformedAction(getResources().getString(R.string.strSquareArea));
            String res = getResources().getString(R.string.strVolumeResult)
                    .replaceAll("-volume-", String.valueOf(sp.calculate()));

            String dataStr = getResources().getString(R.string.strCircleRadius) + ": -radius-";
            sp.dataString(dataStr);

            DataSource.setPerformedActions(sp);

            lblSphereResultTitle.setVisibility(View.VISIBLE);
            lblSphereVolume.setText(res);
        }
    }

    public void clear(View v){
        txtRadius.setText("");
        txtRadius.requestFocus();
        lblSphereVolume.setText("");
        lblSphereResultTitle.setVisibility(View.INVISIBLE);
    }

    public boolean validate(){
        if(txtRadius.getText().toString().isEmpty()){
            txtRadius.setError(getResources().getString(R.string.strRequireField));
            txtRadius.requestFocus();
            return false;
        }
        return true;
    }
}
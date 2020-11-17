package com.example.areaandvolume.volume;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.areaandvolume.R;
import com.example.areaandvolume.data.DataSource;
import com.example.areaandvolume.domain.Cylinder;

public class CylinderActivity extends AppCompatActivity {
    private Cylinder cl = new Cylinder();
    private EditText txtRadius;
    private EditText txtHeight;
    private TextView lblCylinderVolume;
    private TextView lblClResultTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cylinder);

        txtRadius = findViewById(R.id.txtCnRadius);
        txtHeight = findViewById(R.id.txtCnHeight);
        lblCylinderVolume = findViewById(R.id.lblConeValume);
        lblClResultTitle = findViewById(R.id.lblCnResultTitle);
    }

    public void calculateVolume(View v){
        if(validate()) {
            cl.setRadius(Double.parseDouble(String.valueOf(txtRadius.getText())));
            cl.setHeight(Double.parseDouble(String.valueOf(txtHeight.getText())));

            cl.setPerformedAction(getResources().getString(R.string.strCylinderVolume));
            String res = getResources().getString(R.string.strVolumeResult)
                    .replaceAll("-volume-", String.valueOf(cl.calculate()));

            String dataStr = getResources().getString(R.string.strCircleRadius) + ": -radius-\n"
                    + getResources().getString(R.string.strHeight) + ": -height-";
            cl.dataString(dataStr);

            DataSource.setPerformedActions(cl);

            lblClResultTitle.setVisibility(View.VISIBLE);
            lblCylinderVolume.setText(res);
        }
    }

    public void clear(View v){
        txtRadius.setText("");
        txtHeight.setText("");
        txtRadius.requestFocus();

        lblCylinderVolume.setText("");
        lblClResultTitle.setVisibility(View.INVISIBLE);
    }

    public boolean validate(){
        if(txtRadius.getText().toString().isEmpty()){
            txtRadius.setError(getResources().getString(R.string.strRequireField));
            txtRadius.requestFocus();
            return false;
        }

        if(txtHeight.getText().toString().isEmpty()){
            txtHeight.setError(getResources().getString(R.string.strRequireField));
            txtHeight.requestFocus();
            return false;
        }
        return true;
    }
}
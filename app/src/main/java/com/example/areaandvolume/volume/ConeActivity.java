package com.example.areaandvolume.volume;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.areaandvolume.R;
import com.example.areaandvolume.data.DataSource;
import com.example.areaandvolume.domain.Cone;
import com.example.areaandvolume.domain.Cylinder;

public class ConeActivity extends AppCompatActivity {

    private Cone cn = new Cone();
    private EditText txtRadius;
    private EditText txtHeight;
    private TextView lblConeVolume;
    private TextView lblCnResultTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cone);

        txtRadius = findViewById(R.id.txtCnRadius);
        txtHeight = findViewById(R.id.txtCnHeight);
        lblConeVolume = findViewById(R.id.lblConeValume);
        lblCnResultTitle = findViewById(R.id.lblCnResultTitle);
    }

    public void calculateVolume(View v){
        if(validate()) {
            cn.setRadius(Double.parseDouble(String.valueOf(txtRadius.getText())));
            cn.setHeight(Double.parseDouble(String.valueOf(txtHeight.getText())));

            cn.setPerformedAction(getResources().getString(R.string.strConeVolume));
            String res = getResources().getString(R.string.strVolumeResult)
                    .replaceAll("-volume-", String.valueOf(cn.calculate()));

            String dataStr = getResources().getString(R.string.strCircleRadius) + ": -radius-\n"
                    + getResources().getString(R.string.strHeight) + ": -height-";
            cn.dataString(dataStr);

            DataSource.setPerformedActions(cn);

            lblCnResultTitle.setVisibility(View.VISIBLE);
            lblConeVolume.setText(res);
        }
    }

    public void clear(View v){
        txtRadius.setText("");
        txtHeight.setText("");
        txtRadius.requestFocus();

        lblConeVolume.setText("");
        lblCnResultTitle.setVisibility(View.INVISIBLE);
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
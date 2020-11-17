package com.example.areaandvolume.volume;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.areaandvolume.R;
import com.example.areaandvolume.data.DataSource;
import com.example.areaandvolume.domain.Cube;
import com.example.areaandvolume.domain.Sphere;

public class CubeActivity extends AppCompatActivity {

    private Cube sp = new Cube();
    private EditText txtSide;
    private TextView lblConeVolume;
    private TextView lblConeResultTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);

        txtSide = findViewById(R.id.txtConeSide);
        lblConeVolume = findViewById(R.id.lblConeVolume);
        lblConeResultTitle = findViewById(R.id.lblConeResultTitle);
    }

    public void calculateVolume(View v){
        if(validate()) {
            sp.setSide(Double.parseDouble(String.valueOf(txtSide.getText())));
            sp.setPerformedAction(getResources().getString(R.string.strCubeVolume));
            String res = getResources().getString(R.string.strVolumeResult)
                    .replaceAll("-volume-", String.valueOf(sp.calculate()));

            String dataStr = getResources().getString(R.string.strSide) + ": -side-";
            sp.dataString(dataStr);

            DataSource.setPerformedActions(sp);

            lblConeResultTitle.setVisibility(View.VISIBLE);
            lblConeVolume.setText(res);
        }
    }

    public void clear(View v){
        txtSide.setText("");
        txtSide.requestFocus();
        lblConeVolume.setText("");
        lblConeResultTitle.setVisibility(View.INVISIBLE);
    }

    public boolean validate(){
        if(txtSide.getText().toString().isEmpty()){
            txtSide.setError(getResources().getString(R.string.strRequireField));
            txtSide.requestFocus();
            return false;
        }
        return true;
    }
}
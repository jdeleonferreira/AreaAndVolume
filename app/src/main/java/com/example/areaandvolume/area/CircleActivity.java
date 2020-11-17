package com.example.areaandvolume.area;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.areaandvolume.AreasActivity;
import com.example.areaandvolume.R;
import com.example.areaandvolume.data.DataSource;
import com.example.areaandvolume.domain.Circle;
import com.example.areaandvolume.domain.Square;

public class CircleActivity extends AppCompatActivity {

    private Circle cr = new Circle();
    private EditText txtRadius;
    private TextView lblCircleArea;
    private TextView lblCircleResultTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        txtRadius = findViewById(R.id.txtRadius);
        lblCircleArea = findViewById(R.id.lblCircleArea);
        lblCircleResultTitle = findViewById(R.id.lblCircleResultTitle);
    }

    public void calculateArea(View v){
        if(validate()) {
            cr.setRadius(Double.parseDouble(String.valueOf(txtRadius.getText())));
            cr.setPerformedAction(getResources().getString(R.string.strCircleArea));
            String res = getResources().getString(R.string.strAreaResult)
                    .replaceAll("-area-", String.valueOf(cr.calculate()));

            String dataStr = getResources().getString(R.string.strCircleRadius) + ": -radius-";
            cr.dataString(dataStr);

            DataSource.setPerformedActions(cr);

            lblCircleResultTitle.setVisibility(View.VISIBLE);
            lblCircleArea.setText(res);
        }
    }

    public void clear(View v){
        txtRadius.setText("");
        txtRadius.requestFocus();
        lblCircleArea.setText("");
        lblCircleResultTitle.setVisibility(View.INVISIBLE);
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
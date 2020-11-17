package com.example.areaandvolume.area;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.areaandvolume.R;
import com.example.areaandvolume.data.DataSource;
import com.example.areaandvolume.domain.Rectangle;
import com.example.areaandvolume.domain.Triangle;

public class TriangleActivity extends AppCompatActivity {

    private EditText txtTrBase, txtTrHeight;
    private Triangle tr = new Triangle();
    private TextView lblTrResultTitle;
    private TextView lblTriangleArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);

        txtTrBase = findViewById(R.id.txtTrBase);
        txtTrHeight = findViewById(R.id.txtTrHeight);

        lblTrResultTitle = findViewById(R.id.lblTrResultTitle);
        lblTriangleArea = findViewById(R.id.lblTriangleArea);
    }

    public void calculateArea(View v){
        if(validate()) {
            tr.setBase(Double.parseDouble(String.valueOf(txtTrBase.getText())));
            tr.setHeight(Double.parseDouble(String.valueOf(txtTrHeight.getText())));

            tr.setPerformedAction(getResources().getString(R.string.strTriangleArea));
            String res = getResources().getString(R.string.strAreaResult)
                    .replaceAll("-area-", String.valueOf(tr.calculate()));

            String dataStr = getResources().getString(R.string.strBase) + ": -base-\n"
                    + getResources().getString(R.string.strHeight)  + ": -height-";
            tr.dataString(dataStr);

            DataSource.setPerformedActions(tr);

            lblTrResultTitle.setVisibility(View.VISIBLE);
            lblTriangleArea.setText(res);
        }
    }

    public void clear(View v){
        txtTrBase.setText("");
        txtTrBase.requestFocus();
        txtTrBase.setText("");
        lblTrResultTitle.setVisibility(View.INVISIBLE);
        lblTriangleArea.setVisibility(View.INVISIBLE);
    }

    public boolean validate(){
        if(txtTrBase.getText().toString().isEmpty()){
            txtTrBase.setError(getResources().getString(R.string.strRequireField));
            txtTrBase.requestFocus();
            return false;
        }

        if(txtTrHeight.getText().toString().isEmpty()){
            txtTrHeight.setError(getResources().getString(R.string.strRequireField));
            txtTrHeight.requestFocus();
            return false;
        }
        return true;
    }
}
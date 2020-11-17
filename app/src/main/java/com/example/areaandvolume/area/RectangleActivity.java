package com.example.areaandvolume.area;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.areaandvolume.R;
import com.example.areaandvolume.data.DataSource;
import com.example.areaandvolume.domain.Rectangle;


public class RectangleActivity extends AppCompatActivity {

    private EditText txtBase, txtHeight;
    private Rectangle rt = new Rectangle();
    private TextView lblRectangleResultTitle;
    private TextView lblRectangleArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);

        txtBase = findViewById(R.id.txtBase);
        txtHeight = findViewById(R.id.txtHeight);

        lblRectangleResultTitle = findViewById(R.id.lblRectangleResultTitle);
        lblRectangleArea = findViewById(R.id.lblRectangleArea);
    }

    public void calculateArea(View v){
        if(validate()) {
            rt.setBase(Double.parseDouble(String.valueOf(txtBase.getText())));
            rt.setHeight(Double.parseDouble(String.valueOf(txtHeight.getText())));

            rt.setPerformedAction(getResources().getString(R.string.strRectangleArea));
            String res = getResources().getString(R.string.strAreaResult)
                    .replaceAll("-area-", String.valueOf(rt.calculate()));

            String dataStr = getResources().getString(R.string.strBase) + " :-base-\n"
                    + getResources().getString(R.string.strHeight)  + " :-height-";
            rt.dataString(dataStr);

            DataSource.setPerformedActions(rt);

            lblRectangleResultTitle.setVisibility(View.VISIBLE);
            lblRectangleArea.setText(res);
        }
    }

    public void clear(){
        txtBase.setText("");
        txtBase.requestFocus();
        txtBase.setText("");
        lblRectangleResultTitle.setVisibility(View.INVISIBLE);
        lblRectangleArea.setVisibility(View.INVISIBLE);
    }

    public boolean validate(){
        if(txtBase.getText().toString().isEmpty()){
            txtBase.setError(getResources().getString(R.string.strRequireField));
            txtBase.requestFocus();
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
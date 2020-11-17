package com.example.areaandvolume.area;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.areaandvolume.AreasActivity;
import com.example.areaandvolume.MainActivity;
import com.example.areaandvolume.R;
import com.example.areaandvolume.data.DataSource;
import com.example.areaandvolume.domain.Square;

public class SquareActivity extends AppCompatActivity {

    private Square sq = new Square();
    private EditText sideValue;
    private TextView lblSquareArea;
    private TextView lblResultTitle;
    private Button btnOkaySquare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);

        sideValue = findViewById(R.id.txtSide);
        lblSquareArea = findViewById(R.id.lblSquareArea);
        lblResultTitle = findViewById(R.id.lblResultTitle);
        btnOkaySquare = findViewById(R.id.btnOkSquare);
    }

    public void calculateArea(View v){
        if(validate()) {
            sq.setSide(Double.parseDouble(String.valueOf(sideValue.getText())));
            sq.setPerformedAction(getResources().getString(R.string.strSquareArea));
            String res = getResources().getString(R.string.strAreaResult).replaceAll("-area-", String.valueOf(sq.calculate()));
            sq.dataString(getResources().getString(R.string.strBase));

            DataSource.setPerformedActions(sq);

            lblResultTitle.setVisibility(View.VISIBLE);
            btnOkaySquare.setVisibility(View.VISIBLE);
            lblSquareArea.setText(res);
        }
    }
    
    public void clear(View v){
        sideValue.setText("");
        sideValue.requestFocus();
        lblSquareArea.setText("");
        lblResultTitle.setVisibility(View.INVISIBLE);
        btnOkaySquare.setVisibility(View.INVISIBLE);
    }

    public void goArea(View v){
        Intent inten = new Intent(SquareActivity.this
                , AreasActivity.class);
        startActivity(inten);
    }
    
    public boolean validate(){
        if(sideValue.getText().toString().isEmpty()){
            sideValue.setError(getResources().getString(R.string.strRequireField));
            sideValue.requestFocus();
            return false;
        }
        return true;
    }
}
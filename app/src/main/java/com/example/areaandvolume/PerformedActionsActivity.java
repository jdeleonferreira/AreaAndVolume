package com.example.areaandvolume;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.areaandvolume.data.DataSource;
import com.example.areaandvolume.domain.GeometricShape;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PerformedActionsActivity extends AppCompatActivity {

    private TableLayout table;
    private ArrayList<GeometricShape> performedActions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performed_actions);

        table = (TableLayout) findViewById(R.id.tblPerformedActions);

        performedActions = DataSource.getPerformedActions();

        for(int i = 0; i < performedActions.size(); i++){
            TableRow row = new TableRow(this);

            TextView num = new TextView(this);
            TextView action = new TextView(this);
            TextView data = new TextView(this);
            TextView result = new TextView(this);

            num.setText("" + (i + 1));
            num.setGravity(Gravity.CENTER_HORIZONTAL);
            action.setText(performedActions.get(i).getPerformedAction());
            data.setText(performedActions.get(i).getDataString());
            result.setText(""+performedActions.get(i).calculate());

            row.addView(num);
            row.addView(action);
            row.addView(data);
            row.addView(result);

            table.addView(row);
        }
    }


}
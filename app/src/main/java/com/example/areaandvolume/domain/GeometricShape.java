package com.example.areaandvolume.domain;

import android.app.Activity;

public abstract class GeometricShape extends Activity {
    private String performedAction;
    private String dataString;

    public abstract double calculate();

    public String getPerformedAction(){
        return performedAction;
    };
    public void setPerformedAction(String performedAction) {
        this.performedAction = performedAction;
    }

    public String getDataString() { return dataString; }
    public void setDataString(String dataString) { this.dataString = dataString; }
}

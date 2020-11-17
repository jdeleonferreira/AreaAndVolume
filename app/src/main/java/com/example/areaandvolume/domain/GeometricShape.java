package com.example.areaandvolume.domain;

import android.app.Activity;

public abstract class GeometricShape extends Activity {
    private static String performedAction;
    private static String dataString;

    public abstract double calculate();

    public String getPerformedAction(){
        return performedAction;
    };
    public static void setPerformedAction(String action) {
        performedAction = action;
    }

    public static String getDataString() { return dataString; }
    public static void setDataString(String dataString) { GeometricShape.dataString = dataString; }
}

package com.example.areaandvolume.domain;

import android.widget.EditText;
import android.widget.TextView;

public class Sphere extends GeometricShape {
    private double radius;

    public void setRadius(double radius){
        this.radius = radius;
    }

    @Override
    public double calculate() {
        return (4/3) * Math.PI * radius;
    }

    public void dataString(String resource) {
        setDataString(resource.replaceAll("-radius-", String.valueOf(radius)));
    }

}

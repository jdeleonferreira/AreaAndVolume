package com.example.areaandvolume.domain;

import androidx.annotation.NonNull;
import com.example.areaandvolume.R;

public class Circle extends GeometricShape {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculate() {
        return Math.PI*radius*radius;
    }

    public void dataString(String resource) {
        setDataString(resource.replaceAll("-radius-", String.valueOf(radius)));
    }
}


package com.example.areaandvolume.domain;

import androidx.annotation.NonNull;

import com.example.areaandvolume.R;

public class Triangle extends GeometricShape {
    private double base;
    private double height;

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calculate() {
        return base*height/2;
    }

    public void dataString(String resource) {
        setDataString(resource.replace("-base-", String.valueOf(base))
                .replace("-height-",String.valueOf(height)));
    }
}

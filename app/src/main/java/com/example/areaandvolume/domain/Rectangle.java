package com.example.areaandvolume.domain;

import androidx.annotation.NonNull;

import com.example.areaandvolume.R;

public class Rectangle extends GeometricShape {
    private double base;
    private double height;


    public void setBase(double base) {
        this.base = base;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calculate() {
        return base * height;
    }



    public void dataString(String resource) {
        setDataString(resource.replaceAll("-base-",String.valueOf(base))
                .replaceAll("-height-", String.valueOf(height)));
    }
}
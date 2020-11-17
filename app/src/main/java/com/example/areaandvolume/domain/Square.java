package com.example.areaandvolume.domain;

import androidx.annotation.NonNull;

import com.example.areaandvolume.R;

public class Square extends GeometricShape {
    private double side;

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double calculate() {
        return side*side;
    }

    public void dataString(String resource) {
        setDataString(resource.replaceAll("-base-", ": " +String.valueOf(side)));
    }
}

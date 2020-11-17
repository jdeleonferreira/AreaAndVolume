package com.example.areaandvolume.domain;

public class Cube extends GeometricShape {
    private double side;

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double calculate() {
        return Math.pow(side,3);
    }

    public void dataString(String resource) {
        setDataString(resource.replaceAll("-side-", String.valueOf(side)));
    }
}

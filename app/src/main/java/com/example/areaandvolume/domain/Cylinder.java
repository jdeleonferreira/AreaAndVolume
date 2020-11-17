package com.example.areaandvolume.domain;

public class Cylinder extends GeometricShape {
    private double radius;
    private double height;

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calculate() {
        return Math.PI * Math.pow(radius,2) * height;
    }

    public void dataString(String resource) {
        setDataString(resource.replaceAll("-radius-", String.valueOf(radius))
                .replaceAll("-height-",String.valueOf(height)));
    }
}

package com.example.areaandvolume.data;

import com.example.areaandvolume.domain.GeometricShape;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<GeometricShape> performedActions = new ArrayList<>();

    public static ArrayList<GeometricShape> getPerformedActions() {
        return performedActions;
    }

    public static void setPerformedActions(GeometricShape performedAction) {
        performedActions.add(performedAction);
    }
}

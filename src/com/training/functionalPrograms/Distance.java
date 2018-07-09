package com.training.functionalPrograms;

import com.training.utility.InputScanner;

public class Distance {
    private double xCoordinate;
    private double yCoordinate;

    Distance(){
        xCoordinate = 0.0;
        yCoordinate = 0.0;
    }

    private double eucledianDistanceFromOrigin(){
        return (Math.pow( (Math.pow(xCoordinate,2.0) + Math.pow(yCoordinate,2.0)),0.5));
    }

    public void calcDistance(){
        InputScanner inputScannerObj =  new InputScanner();
        Distance distanceObj = new Distance();

        System.out.println("Enter X coordinate and Y coordinate Of Point!");
        distanceObj.xCoordinate = inputScannerObj.inputDouble();
        distanceObj.yCoordinate = inputScannerObj.inputDouble();

        System.out.println("Eucledian Distance :" + distanceObj.eucledianDistanceFromOrigin());
    }
}

package com.training.algorithmPrograms;

import com.training.utility.CommonAlgorithms;
import com.training.utility.InputScanner;

public class TemperatureConversionAux {
    private double temperature;
    TemperatureConversionAux(){
        this.temperature = 0.0;
    }
    public void temperatureConversion(){
        InputScanner inputScannerObj = new InputScanner();
        TemperatureConversionAux temperatureConversionAuxObj = new TemperatureConversionAux();

        System.out.println("Enter 1 to convert from C --> F or 2 to convert from F--> C");
        int choice = inputScannerObj.inputInteger();
        System.out.println("Enter Temperature!");
        temperatureConversionAuxObj.temperature = inputScannerObj.inputDouble();
        System.out.println("Converted temperature :" + CommonAlgorithms.temperatureConversion(choice,temperatureConversionAuxObj.temperature));
    }
}

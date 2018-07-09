package com.training.functionalPrograms;

import com.training.utility.InputScanner;

/*
Calculate windChill through the following formula and anotations
    w = 35.74 + 0.6215t + (0.4275 t - 35.75) v ^ 0.16
    t <= |50|
    120 >= v >= 3
 */
public class WindChill {
    private double t;
    private double v;
    WindChill(){
        this.t = 0;
        this.v = 0;
    }

    public boolean isInRange(){
        if(this.v >= 3 && this.v <= 120)
            return true;
        return  false;
    }

    public void windChillFinder(){
        InputScanner inputScannerObj = new InputScanner();
        WindChill windChillObj = new WindChill();

        do{
            System.out.println("Enter Correct Value of 't' in Fahrenheit");
            windChillObj.t = inputScannerObj.inputDouble();
        }while(Math.abs(windChillObj.t) > 50.0);

        do{
            System.out.println("Enter Correct Value of 'v' in miles per hour");
            windChillObj.v = inputScannerObj.inputDouble();
        }while(!windChillObj.isInRange());

        System.out.println(35.74 + 0.6215 * windChillObj.t + (0.4275 * windChillObj.t - 35.75) * Math.pow(v,0.16));
    }

}

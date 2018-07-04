package com.training.functionalPrograms;

import com.training.utility.InputScanner;

public class PowerOfTwo {

    private int limit;

    public PowerOfTwo(){
        this.limit = 0;
    }

    public void powerOfDos() {

        InputScanner inputScannerObj = new InputScanner();
        PowerOfTwo powerOfTwoObj = new PowerOfTwo();

        do {
            System.out.println("Enter valid range!");
            powerOfTwoObj.limit = inputScannerObj.inputInteger();
        }while(powerOfTwoObj.limit>31 || powerOfTwoObj.limit < 0);


        for(int i=0;i<powerOfTwoObj.limit;i++) {
            System.out.println((int)(Math.pow(2,i)));
        }
    }
}

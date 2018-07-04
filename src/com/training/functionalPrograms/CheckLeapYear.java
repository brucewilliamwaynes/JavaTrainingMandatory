package com.training.functionalPrograms;


import com.training.utility.InputScanner;


public class CheckLeapYear {
    private String yearInput;

    public  CheckLeapYear(){
        this.yearInput = "";
    }

    public void checkLeapYear() {
        InputScanner inputScannerObj = new InputScanner();
        CheckLeapYear checkLeapYearObj = new CheckLeapYear();
        do {
            System.out.println("Enter a Valid year!");
            checkLeapYearObj.yearInput = inputScannerObj.inputString();
        }while(checkLeapYearObj.yearInput.length() < 4 || checkLeapYearObj.yearInput.length() > 4);

        int yearInteger = Integer.parseInt(checkLeapYearObj.yearInput);

        if(yearInteger%4==0)
            System.out.println("Leap year.");
        else
            System.out.println("Not a Leap Year.");
    }

}

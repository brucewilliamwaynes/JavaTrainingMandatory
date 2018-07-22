package com.training.functionalPrograms;


import com.training.utility.InputScanner;


public class CheckLeapYear {
    private String yearInput;

    public  CheckLeapYear(){
        this.yearInput = "";
    }

    public static boolean leapYearValidator(String inputYear){
        int yearInput = Integer.parseInt(inputYear);
        if(yearInput % 4 == 0) {
            if (yearInput % 100 == 0) {
                if (yearInput % 400 == 0)
                    return true;
                return false;
            }
            return true;
        }
        return false;
    }

    public void checkLeapYear() {
        InputScanner inputScannerObj = new InputScanner();
        CheckLeapYear checkLeapYearObj = new CheckLeapYear();
        do {
            System.out.println("Enter a Valid year!");
            checkLeapYearObj.yearInput = inputScannerObj.inputString();
        }while(checkLeapYearObj.yearInput.length() < 4 || checkLeapYearObj.yearInput.length() > 4);

        if(checkLeapYearObj.leapYearValidator(checkLeapYearObj.yearInput))
        {
            System.out.println("Leap year.");
        }
        else {
            System.out.println("Not a Leap Year.");
        }
    }

}

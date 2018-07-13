package com.training.algorithmPrograms;

import com.training.utility.CommonAlgorithms;
import com.training.utility.InputScanner;

import java.text.ParseException;

public class DayOfWeekAux {
    private boolean validator;
    DayOfWeekAux(){
        this.validator = false;
    }

    public void displayDayOfWeek() throws ParseException{
        InputScanner inputScannerObj = new InputScanner();
        boolean validation;
        String inputDate;
        do {
            System.out.println("Enter Date in MM/DD/YYYY format!");
            inputDate = inputScannerObj.inputString();
            validation = CommonAlgorithms.dateValidator(inputDate);
        }while(!validation);

        System.out.println("The input Date : " + inputDate + " is a " + CommonAlgorithms.dayOfWeek(inputDate));
    }

}

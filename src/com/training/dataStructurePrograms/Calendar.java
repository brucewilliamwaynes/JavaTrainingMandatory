package com.training.dataStructurePrograms;

import com.training.functionalPrograms.CheckLeapYear;
import com.training.utility.CommonAlgorithms;
import com.training.utility.InputScanner;

import java.text.ParseException;

public class Calendar {
    private String inputString;
    Calendar(){
        this.inputString = "";
    }
    public void makeCalendar()throws ParseException{
        InputScanner inputScannerObj = new InputScanner();
        Calendar calendarObj = new Calendar();
        do {
            System.out.println("Enter month and year for Calendar!");
            calendarObj.inputString = inputScannerObj.inputString();
            if(calendarObj.inputString.length() == 6)
                calendarObj.inputString = "0" + calendarObj.inputString;
            calendarObj.inputString = calendarObj.inputString.substring(0, 2) + "/01/" + calendarObj.inputString.substring(2,6);
        }while(!CommonAlgorithms.dateValidator(calendarObj.inputString));
        String daysOfWeek[] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        String daysOfWeekShortHand[] = {"S","M","T","W","T","F","S"};
        String monthOfYear[] = {"","January","February","March","April","May","June","July","August","September","October","November","December"};
        int lastDateOfMonth[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        if(CheckLeapYear.leapYearValidator(calendarObj.inputString) && 2 == Integer.parseInt(calendarObj.inputString.substring(0,2))){
            lastDateOfMonth[2] = 29;
        }
        String firstDay = CommonAlgorithms.dayOfWeek(calendarObj.inputString);
        String[][] calendarString = new String[7][];
        for(int i=1;i<=lastDateOfMonth[Integer.parseInt(calendarObj.inputString.substring(0,2))];i++){

        }
    }
}

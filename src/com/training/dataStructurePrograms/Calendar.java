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
            calendarObj.inputString = calendarObj.inputString.substring(0, 2) + "/01/" + calendarObj.inputString.substring(3,7);
        }while(!CommonAlgorithms.dateValidator(calendarObj.inputString));
        String daysOfWeek[] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        String daysOfWeekShortHand[] = {"S","M","T","W","T","F","S"};
        String monthOfYear[] = {"","January","February","March","April","May","June","July","August","September","October","November","December"};
        int lastDateOfMonth[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        if(CheckLeapYear.leapYearValidator(calendarObj.inputString.substring(6,10)) && 2 == Integer.parseInt(calendarObj.inputString.substring(0,2))){
            lastDateOfMonth[2] = 29;
        }
        String firstDay = CommonAlgorithms.dayOfWeek(calendarObj.inputString);
        int offset = 0;
        if(firstDay.compareTo("Monday")==0)
            offset = 1;
        else if(firstDay.compareTo("Monday")==0)
            offset = 2;
        else if(firstDay.compareTo("Tuesday")==0)
            offset = 3;
        else if(firstDay.compareTo("Thursday")==0)
            offset = 4;
        else if(firstDay.compareTo("Friday")==0)
            offset = 5;
        else if(firstDay.compareTo("Saturday")==0)
            offset = 6;
        else
            offset = 0;
        String[][] calendar = new String[7][7];
        int date = 1;
        int flag = 0;
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                if(i==0)
                    calendar[i][j] = daysOfWeekShortHand[j];
                else if(j<offset && flag==0){
                    calendar[i][j] = " ";
                }
                else if(date<=lastDateOfMonth[Integer.parseInt(calendarObj.inputString.substring(0,2))]){
                    calendar[i][j] = String.valueOf(date);
                    date++;
                    flag = 1;
                }
                else
                    calendar[i][j] = "";
            }
        }
        System.out.println(monthOfYear[Integer.parseInt(calendarObj.inputString.substring(0,2))] + " " + calendarObj.inputString.substring(6,10));
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                System.out.print(calendar[i][j] + " ");
            }
            System.out.println();
        }
    }
}

package com.training.functionalPrograms;

import com.training.utility.InputScanner;

public class CouponNumbers {
    private int distinctNumbers;

    public CouponNumbers(){
        this.distinctNumbers = 0;
    }

    public int findCouponNumbers(){
        boolean checkList[] = new boolean[this.distinctNumbers];

        int currentDistinctCount = 0;
        int totalIterations = 0;
        int distinctNumberTest = 0;

        while(currentDistinctCount < this.distinctNumbers){

            distinctNumberTest = (int)(InputScanner.findRandomWithRange(0,this.distinctNumbers));

            System.out.println(distinctNumberTest);
            if((distinctNumberTest < this.distinctNumbers) && (!checkList[distinctNumberTest])){
                checkList[distinctNumberTest] = true;
//                System.out.println(distinctNumberTest);
                currentDistinctCount += 1;
            }

            totalIterations += 1;
        }

        return totalIterations;

    }

    public static void displayCouponNumbers(){

        InputScanner inputScannerObj = new InputScanner();
        CouponNumbers couponNumbersObj = new CouponNumbers();

        System.out.println("Enter Number of distinct numbers for which you want to check Math.random()!");

        couponNumbersObj.distinctNumbers = inputScannerObj.inputInteger();

        System.out.println(couponNumbersObj.findCouponNumbers());

    }
}

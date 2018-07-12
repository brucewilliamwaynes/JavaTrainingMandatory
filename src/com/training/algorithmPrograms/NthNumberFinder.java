package com.training.algorithmPrograms;

import com.training.utility.CommonAlgorithms;
import com.training.utility.InputScanner;
/*
Mocking Binary Searching ! Without Space ! Question format !
 */
public class NthNumberFinder {
    private int numberLowerLimit;

    NthNumberFinder(){
        this.numberLowerLimit = 0;
    }

    public static  void findNthNumber(){
        InputScanner inputScannerObj = new InputScanner();
        NthNumberFinder nthNumberFinderObj = new NthNumberFinder();

        System.out.println("Enter your number !");
        int rawNumber = inputScannerObj.inputInteger();

        nthNumberFinderObj.numberLowerLimit = CommonAlgorithms.getLowerLimitInPowerOf2(rawNumber);



        int leftIndex = (int)(Math.pow(2,nthNumberFinderObj.numberLowerLimit - 1));
        int rightIndex = (int)(Math.pow(2,(nthNumberFinderObj.numberLowerLimit)));

        int totalQuestionsAsked = 0;

        while(leftIndex  < rightIndex){
            if(rawNumber == leftIndex || rawNumber == rightIndex || rawNumber == (leftIndex+rightIndex)/2){
                System.out.println("No Need To Find Number ! Already Present ! Number Of Questions Asked ! " + totalQuestionsAsked);
                break;
            }
            else {
                System.out.println("Is your number between " + leftIndex + " and " + (leftIndex + rightIndex) / 2 + " ?");
                totalQuestionsAsked++;
                boolean ans = inputScannerObj.inputBoolean();
                if (ans) {
                    rightIndex = (leftIndex + rightIndex) / 2 - 1;
                } else {
                    leftIndex = (leftIndex + rightIndex) / 2 + 1;
                }
            }
        }
    }
}

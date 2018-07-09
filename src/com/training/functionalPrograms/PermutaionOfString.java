package com.training.functionalPrograms;

import com.training.utility.InputScanner;

public class PermutaionOfString {
    private String stringToPermute;
    PermutaionOfString(){
        this.stringToPermute = "";
    }

    private void calculatePermutationWithRecurrsion(String sampleString , int leftIndex , int rightIndex){
        if(leftIndex == rightIndex)
            System.out.println(sampleString);
        else{
            for(int i= leftIndex;i<= rightIndex;i++){
                sampleString = InputScanner.swapString(sampleString,leftIndex,i);
                calculatePermutationWithRecurrsion(sampleString,leftIndex + 1,rightIndex);
                sampleString = InputScanner.swapString(sampleString,leftIndex,i);
            }
        }
    }

    public static void calcPermutationWithRecurrsionAuxilary(){
        InputScanner inputScannerObj = new InputScanner();
        PermutaionOfString permutaionOfStringObj = new PermutaionOfString();

        System.out.println("Enter a String to find permutations !");
        permutaionOfStringObj.stringToPermute = inputScannerObj.inputString();

        permutaionOfStringObj.calculatePermutationWithRecurrsion(permutaionOfStringObj.stringToPermute,0,permutaionOfStringObj.stringToPermute.length()-1);
    }
}

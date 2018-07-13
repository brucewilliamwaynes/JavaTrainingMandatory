package com.training.algorithmPrograms;

import com.training.utility.CommonAlgorithms;
import com.training.utility.InputScanner;

public class Binary {
    private int number;
    private String binaryString;
    Binary(){
        this.number = 0;
        this.binaryString = "";
    }

    public void swapNibbles(){
        this.binaryString = CommonAlgorithms.addPaddingToBinaryToByte(this.binaryString);
//        System.out.println("The resulting padded binary number is: " + this.binaryString);
        this.binaryString = this.binaryString.substring(4,8) + this.binaryString.substring(0,4);
    }

    public void displayBinary(){
        InputScanner inputScannerObj = new InputScanner();
        Binary binaryObj = new Binary();

        System.out.println("Enter a number to convert to binary array ! ");
        binaryObj.number = inputScannerObj.inputInteger();

        binaryObj.binaryString = CommonAlgorithms.toBinary(binaryObj.number);

        System.out.println("The converted Binary equivalent of " + binaryObj.number + " is : " + binaryObj.binaryString);

        System.out.println("Now we will swap nibbles ! ");

        binaryObj.swapNibbles();

        long number = CommonAlgorithms.toDecimal(binaryObj.binaryString);

        System.out.println("The Swapped Nibbles Formed number is : " + number);
        long count = CommonAlgorithms.getLowerLimitInPowerOf2(number);
        count = (long)(Math.pow(2,count - 1));
        if(count == number){
            System.out.println("New Number Formed is a power of 2 multiple!");
        }
    }
}

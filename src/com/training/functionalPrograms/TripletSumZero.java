package com.training.functionalPrograms;

import com.training.utility.InputScanner;

import java.util.Arrays;

/*
    Find and Print All Triplets in an Array whose Sum is Zero ()
 */
public class TripletSumZero {

    private int listOfNumbers[];
    private int leftElement , rightElemeent;
    private boolean found;

    TripletSumZero(){
        this.found = false;
        this.leftElement = 0;
    }

    TripletSumZero(int limit){
        this.listOfNumbers = new int[limit];
        this.rightElemeent = limit-1;
    }

    private void displayTripletSumZero(){

        Arrays.sort(this.listOfNumbers);

        for(int i=0;i<(this.listOfNumbers.length)-1;i++)
        {
            leftElement = i + 1;
            rightElemeent = (this.listOfNumbers.length) -1;

            while(leftElement < rightElemeent){
                if(this.listOfNumbers[i] + this.listOfNumbers[leftElement] + this.listOfNumbers[rightElemeent] == 0){
                        System.out.println(this.listOfNumbers[i] + " " + this.listOfNumbers[leftElement] + " " + this.listOfNumbers[rightElemeent]);
                        found = true;
                        leftElement++;
                        rightElemeent--;
                }

                else if(this.listOfNumbers[i] + this.listOfNumbers[leftElement] + this.listOfNumbers[rightElemeent] < 0){
                        leftElement++;
                }

                else{
                        rightElemeent--;
                }
            }
        }
    }

    public void calcTripletSumZero(){
        InputScanner inputScannerObj = new InputScanner();

        System.out.println("Enter size of Array");
        int limit = inputScannerObj.inputInteger();

        TripletSumZero tripletSumZeroObj = new TripletSumZero(limit);

        for(int i = 0;i<tripletSumZeroObj.listOfNumbers.length;i++){
            System.out.println("Enter a number!");
            tripletSumZeroObj.listOfNumbers[i] = inputScannerObj.inputInteger();
        }

        tripletSumZeroObj.displayTripletSumZero();

    }

}

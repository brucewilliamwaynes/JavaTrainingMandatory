package com.training.functionalPrograms;

import com.training.utility.InputScanner;

public class GenericTwoDimensionalArray {
    private int row;
    private int column;

    public GenericTwoDimensionalArray(){
        this.row = 0;
        this.column = 0;
    }

    public void makeTwoDimensionalArrayForInteger(){

        InputScanner inputScannerObj = new InputScanner();

        int twoDimensionalArray[][] = new int[this.row][this.column];

        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.column;j++){
                System.out.println("Enter a number!");
                twoDimensionalArray[i][j] = inputScannerObj.inputInteger();
            }
        }

        for(int i = 0;i<this.row;i++){
            for(int j=0;j<this.column;j++)
                System.out.print(twoDimensionalArray[i][j] + " ");
            System.out.println();
        }
    }

    public void makeTwoDimensionalArrayForDouble(){

        InputScanner inputScannerObj = new InputScanner();

        double twoDimensionalArray[][] = new double[this.row][this.column];

        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.column;j++){
                System.out.println("Enter a double Value");
                twoDimensionalArray[i][j] = inputScannerObj.inputDouble();
            }
        }

        for(int i = 0;i<this.row;i++){
            for(int j=0;j<this.column;j++)
                System.out.println(twoDimensionalArray[i][j] + " ");
            System.out.println();
        }
    }

    public void makeTwoDimensionalArrayForBoolean(){

        InputScanner inputScannerObj = new InputScanner();

        boolean twoDimensionalArray[][] = new boolean[this.row][this.column];

        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.column;j++){
                System.out.println("Enter a Boolean Value");
                twoDimensionalArray[i][j] = inputScannerObj.inputBoolean();
            }
        }

        for(int i = 0;i<this.row;i++){
            for(int j=0;j<this.column;j++)
                System.out.println(twoDimensionalArray[i][j] + " ");
            System.out.println();
        }
    }

    public void displayTwoDimensionalArray(){

        InputScanner inputScannerObj = new InputScanner();
        GenericTwoDimensionalArray genericTwoDimensionalArrayObj = new GenericTwoDimensionalArray();

        System.out.println("Enter Row and Column For Matrix!");
        genericTwoDimensionalArrayObj.row = inputScannerObj.inputInteger();
        genericTwoDimensionalArrayObj.column = inputScannerObj.inputInteger();

        System.out.println("Enter 1 for integer type , 2 for double type , 3 for booleans!");
        int ch = inputScannerObj.inputInteger();

        switch (ch){
            case 1:genericTwoDimensionalArrayObj.makeTwoDimensionalArrayForInteger();
                    break;
            case 2:genericTwoDimensionalArrayObj.makeTwoDimensionalArrayForDouble();
                    break;
            case 3:genericTwoDimensionalArrayObj.makeTwoDimensionalArrayForBoolean();
        }
    }
}

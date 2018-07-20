package com.training.dataStructurePrograms;

import com.training.utility.InputScanner;
import com.training.utility.OrderedMapCustom;

import java.io.FileNotFoundException;
import java.io.IOException;

public class NumberInASlot{
    private int searcKey;
    NumberInASlot(){
        this.searcKey = 0;
    }
    public void findKeyOfNumber() throws FileNotFoundException,IOException{
        InputScanner inputScannerObj = new InputScanner();
        NumberInASlot numberInASlotObj = new NumberInASlot();
        String inputFileString = InputScanner.readInputFromFile();
        OrderedMapCustom<Integer,Integer> myHashMap = new OrderedMapCustom<Integer, Integer>();
        myHashMap = myHashMap.segregateNumbersIntoFile(inputFileString);
        System.out.println("Enter number to be searched !");
        numberInASlotObj.searcKey = inputScannerObj.inputInteger();
        if(myHashMap.doesKeyExist(numberInASlotObj.searcKey%11)){
            myHashMap.removeElementFromHashMap(numberInASlotObj.searcKey%11,numberInASlotObj.searcKey);
        }
        else {
            myHashMap.addElementToHashMap(numberInASlotObj.searcKey % 11, numberInASlotObj.searcKey);
        }
        InputScanner.writeInputToFile(myHashMap);
    }
 }

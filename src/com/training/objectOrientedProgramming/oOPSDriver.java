package com.training.objectOrientedProgramming;

public class oOPSDriver {
    oOPSDriver(){
        CreateInventory createInventoryObj = new CreateInventory();
        createInventoryObj.workingWithInventory();
    }
    public static void main(String args[]){
        new oOPSDriver();
    }
}

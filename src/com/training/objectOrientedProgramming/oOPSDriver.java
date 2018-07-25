package com.training.objectOrientedProgramming;

public class oOPSDriver {
    oOPSDriver() throws Exception{

        CreateInventory createInventoryObj = new CreateInventory();
        createInventoryObj.workingWithInventory();
    }
    public static void main(String args[]) throws Exception{
        new oOPSDriver();
    }
}

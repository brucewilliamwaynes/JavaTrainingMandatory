package com.training.objectOrientedProgramming;

import com.training.objectOrientedProgramming.RegexUsageDemonstration;

public class oOPSDriver {
    oOPSDriver() throws Exception{
        /*
    	CreateInventory createInventoryObj = new CreateInventory();
        createInventoryObj.workingWithInventory();
    	*/
//    	RegexUsageDemonstration.regexDemo();
//    	StockPortfolio.workWithStock();
    	/*
    	DeckOfCards docObj = new DeckOfCards();
    	docObj.playCards();
    	*/
    	DeckOfCards deckObj = new DeckOfCards();
    	deckObj.playGame();
    }
    public static void main(String args[]) throws Exception{
        new oOPSDriver();
    }
}

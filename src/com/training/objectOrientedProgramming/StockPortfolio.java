/**
 * 
 */
package com.training.objectOrientedProgramming;
import java.util.ArrayList;

import com.training.sampleClassTypes.Stock;
import com.training.utility.InputScanner;
/**
 * @author bridgelabz
 *
 */
public class StockPortfolio {
	private static ArrayList<Double> valuationList;
	public static void workWithStock(){
		InputScanner inputScannerObj = new InputScanner();
		
		int numberOfStock;
		
		System.out.println("Enter total number of stocks to process!");
		numberOfStock = inputScannerObj.inputInteger();
		
		ArrayList<Stock> stockList = new ArrayList<Stock>(numberOfStock);
		valuationList = new ArrayList<Double>(numberOfStock);
		
		fillUpStockList(inputScannerObj,stockList,numberOfStock);
		calcValueEachStock(stockList);
		double totalCost  = calcValueTotalStock();
	}


	private static double calcValueTotalStock() {
		// TODO Auto-generated method stub
		double totalValuation = 0.0;
		for(int i=0;i<valuationList.size();i++){
			totalValuation += valuationList.get(i);
		}
		return totalValuation;
	}


	private static void calcValueEachStock(ArrayList<Stock> stockList) {
		// TODO Auto-generated method stub
		for(int i=0;i<stockList.size();i++){
			valuationList.add(i, (stockList.get(i).getNumberOfShares() * stockList.get(i).getEachSharePrice()));
		}
	}

	
	private static void fillUpStockList(InputScanner inputScannerObj,ArrayList<Stock> stockList, int numberOfStock) {
		// TODO Auto-generated method stub
		System.out.println("Create Stock Details!");
		Stock element = new Stock();
		for(int i=0;i<numberOfStock;i++){
			System.out.println("Enter stock name!");
			element.setStockName(inputScannerObj.inputString());
			System.out.println("Enter number of shares!");
			element.setNumberOfShares(inputScannerObj.inputInteger());
			System.out.println("Enter share price!");
			element.setEachSharePrice(inputScannerObj.inputDouble());
			stockList.add(i, element);
		}
	}
	
}

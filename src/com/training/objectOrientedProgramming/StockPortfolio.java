/**
 * 
 */
package com.training.objectOrientedProgramming;
import java.io.IOException;
import java.util.ArrayList;

import com.training.sampleClassTypes.Stock;
import com.training.utility.InputScanner;
/**
 * @author bridgelabz
 *
 */
public class StockPortfolio {
	public static void workWithStock() throws IOException{
		InputScanner inputScannerObj = new InputScanner();
		
		int numberOfStock;
		
		System.out.println("Enter total number of stocks to process!");
		numberOfStock = inputScannerObj.inputInteger();
		
		ArrayList<Stock> stockList = new ArrayList<Stock>(numberOfStock);
		
		fillUpStockList(inputScannerObj,stockList,numberOfStock);
		calcValueEachStock(stockList);
		double totalCost  = calcValueTotalStock(stockList);
		
		InputScanner.writeInputToFileFromArray(stockList);
		
		System.out.println("Total Valuation :" + totalCost);
	}


	private static double calcValueTotalStock(ArrayList<Stock> stockList) {
		// TODO Auto-generated method stub
		double totalValuation = 0.0;
		for(int i=0;i<stockList.size();i++){
			totalValuation += stockList.get(i).getValuationEachStock();
		}
		return totalValuation;
	}


	private static void calcValueEachStock(ArrayList<Stock> stockList) {
		// TODO Auto-generated method stub
		for(int i=0;i<stockList.size();i++){
			stockList.get(i).setValuationEachStock(stockList.get(i).getNumberOfShares() * stockList.get(i).getEachSharePrice());
		}
	}

	
	private static void fillUpStockList(InputScanner inputScannerObj,ArrayList<Stock> stockList, int numberOfStock) {
		// TODO Auto-generated method stub
		System.out.println("Create Stock Details!");
		String stockName;
		int numberOfShares;
		double sharePrice;
		
		for(int i=0;i<numberOfStock;i++){
			Stock element = new Stock();
			inputScannerObj = new InputScanner();
			System.out.println("Enter stock name!");
			stockName = inputScannerObj.inputString();
			System.out.println(stockName);
			System.out.println("Enter number of shares!");
			numberOfShares = inputScannerObj.inputInteger();
			System.out.println("Enter share price!");
			sharePrice = inputScannerObj.inputDouble();
			element.setStockName(stockName);
			element.setNumberOfShares(numberOfShares);
			element.setEachSharePrice(sharePrice);
			stockList.add(i, element);
		}
	}
	
}

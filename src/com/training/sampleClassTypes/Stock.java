/**
 * 
 */
package com.training.sampleClassTypes;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.training.utility.InputScanner;

/**
 * @author brucewilliamwaynes
 *
 */
public class Stock {
		private  String stockName;
		private  int numberOfShares;
		private  double eachSharePrice;
		private double valuationEachStock;
		private static JSONObject shareJSON;
		/*
		 * Initialize instance variables when called
		 */
		
		public Stock(){
			this.stockName = "";
			this.numberOfShares = 0;
			this.eachSharePrice = 0.0;		
			this.setValuationEachStock(0.0);
		}
		
		/**
		 * @return the stockName
		 */
		public  String getStockName() {
			return this.stockName;
		}
		/**
		 * @param stockName the stockName to set
		 */
		public  void setStockName(String stockName) {
			this.stockName = stockName;
		}
		/**
		 * @return the numberOfShares
		 */
		public  int getNumberOfShares() {
			return this.numberOfShares;
		}
		/**
		 * @param numberOfShares the numberOfShares to set
		 */
		public  void setNumberOfShares(int numberOfShares) {
			this.numberOfShares = numberOfShares;
		}
		/**
		 * @return the eachSharePrice
		 */
		public  double getEachSharePrice() {
			return this.eachSharePrice;
		}
		/**
		 * @param eachSharePrice the eachSharePrice to set
		 */
		public  void setEachSharePrice(double eachSharePrice) {
			this.eachSharePrice = eachSharePrice;
		}

		/**
		 * @return the valuationEachStock
		 */
		public double getValuationEachStock() {
			return valuationEachStock;
		}

		/**
		 * @param valuationEachStock the valuationEachStock to set
		 */
		public void setValuationEachStock(double valuationEachStock) {
			this.valuationEachStock = valuationEachStock;
		}
		
		public String getDetails(){
			return (this.stockName + " with " + this.numberOfShares + " shares, is of  worth " + this.eachSharePrice + " each.");
		}
		
		public static void updateListInitialize(ArrayList<Stock> stockList) throws Exception{
			System.out.println("Enter Shares JSON file destination!");
			shareJSON = InputScanner.readJSONFromFile();
			for(Object key : shareJSON.keySet()){
				JSONObject stockObj = (JSONObject)shareJSON.get(key);
				Stock currentStock = new Stock();
				currentStock.setStockName((String) stockObj.get("CompanyName"));
				currentStock.setNumberOfShares((Integer.parseInt(String.valueOf(stockObj.get("NumberOfStock")))));
				currentStock.setEachSharePrice(Double.valueOf(String.valueOf(stockObj.get("PricePerShare"))) );
				stockList.add(currentStock);
			}
		}
		
}

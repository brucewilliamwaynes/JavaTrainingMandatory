/**
 * 
 */
package com.training.sampleClassTypes;

/**
 * @author brucewilliamwaynes
 *
 */
public class Stock {
		private  String stockName;
		private  int numberOfShares;
		private  double eachSharePrice;
		private double valuationEachStock;
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
}

/**
 * 
 */
package com.training.sampleClassTypes;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;

import com.training.utility.InputScanner;

/**
 * @author bridgelabz
 *
 */
public class Transaction {

	private static JSONObject transactionDetailsJSON;
	private String customerName;
	private String stockName;
	private int numberOfShares;
	private String dateOfTransaction;
	
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return this.customerName;
	}
	
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(Customer customerNew) {
		this.customerName = customerNew.getName();
	}

	/**
	 * @return the stockName
	 */
	public String getStockName() {
		return this.stockName;
	}

	/**
	 * @param stockName the stockName to set
	 */
	public void setStockName(Stock stockElement) {
		this.stockName = stockElement.getStockName();
	}

	/**
	 * @return the numberOfShares
	 */
	public int getNumberOfShares() {
		return this.numberOfShares;
	}

	/**
	 * @param numberOfShares the numberOfShares to set
	 */
	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	/**
	 * @return the dateOfTransaction
	 */
	public String getDateOfTransaction() {
		return dateOfTransaction;
	}

	/**
	 * @param dateOfTransaction the dateOfTransaction to set
	 */
	public void setDateOfTransaction() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		this.dateOfTransaction = String.valueOf(sdf.format(date));
	}


	public static Stock processPurchase(Customer customerNew, Stock stockElement) {
		// TODO Auto-generated method stub
			InputScanner sc = new InputScanner();
			
			Stock stockDetails = null;
			
			System.out.println("Enter number of shares you want to buy!");
		
			int numberOfShares = sc.inputInteger();
		
		/*
		 * Please validate if shares can be purchased and update the price or balance of customer!
		 */
			
			if(customerNew.getBalanceAvailable() - numberOfShares * stockElement.getEachSharePrice() >= 1000.00 || stockElement.getNumberOfShares() - numberOfShares < 0){
				customerNew.setBalanceAvailable(customerNew.getBalanceAvailable() - 1000.00 - numberOfShares *stockElement.getEachSharePrice());
				stockElement.setNumberOfShares(stockElement.getNumberOfShares() - numberOfShares);
				stockDetails = new Stock();
				stockDetails.setStockName(stockElement.getStockName());
				stockDetails.setNumberOfShares(numberOfShares);
				stockDetails.setEachSharePrice(stockElement.getEachSharePrice());
			}
			
			else{
				System.out.println("Cannot buy so many stocks!");
				System.out.println("Available Balance :" + customerNew.getBalanceAvailable());
			}
			
			return stockDetails;
			
	}
	
	public static void loadTransactionJSON() throws Exception{
		System.out.println("Enter details forTransaction JSON!");
		transactionDetailsJSON = InputScanner.readJSONFromFile();
	}

	public static void updateTransactionJSON(Customer customerNew, Stock stockDetails, String symbol) {
		// TODO Auto-generated method stub
		JSONObject transactionElement = new JSONObject();
		if(stockDetails != null){
			if( symbol.compareTo("+") == 0 ){
				
				transactionElement.put("CustomerName",customerNew.getName());
				transactionElement.put("CompanyName",stockDetails.getStockName());
				transactionElement.put("NumberOfShares", stockDetails.getNumberOfShares());
				transactionElement.put("Balance", customerNew.getBalanceAvailable());
				
				
			}
		}
		else{
			System.out.println("Cannot Work with Empty Stock!");
			return;
		}
	}

}

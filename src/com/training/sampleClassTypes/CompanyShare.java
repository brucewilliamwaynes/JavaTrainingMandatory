/**
 * 
 */
package com.training.sampleClassTypes;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bridgelabz
 *
 */
public class CompanyShare {
	private String stockSymbol;
	private int numberOfShare;
	private String dateOfTransaction;
	private String timeOfTransaction;
	
	public CompanyShare(){
		this.stockSymbol = "";
		this.numberOfShare = 0;
		this.dateOfTransaction = "";
		this.timeOfTransaction = "";
	}
	
	
	/**
	 * @return the stockSymbol
	 */
	public String getStockSymbol() {
		return this.stockSymbol;
	}
	/**
	 * @param stockSymbol the stockSymbol to set
	 */
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	/**
	 * @return the numberOfShare
	 */
	public int getNumberOfShare() {
		return this.numberOfShare;
	}
	/**
	 * @param numberOfShare the numberOfShare to set
	 */
	public void setNumberOfShare(int numberOfShare) {
		this.numberOfShare = numberOfShare;
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
		Date currentDate = new Date();
		SimpleDateFormat formatDate = new SimpleDateFormat("MM-dd-YYYY");
		this.dateOfTransaction = String.valueOf(formatDate.format(currentDate));
	}


	/**
	 * @return the timeOfTransaction
	 */
	public String getTimeOfTransaction() {
		return timeOfTransaction;
	}


	/**
	 * @param timeOfTransaction the timeOfTransaction to set
	 */
	public void setTimeOfTransaction() {
		Date currentDate = new Date();
		SimpleDateFormat formatDate = new SimpleDateFormat("kk:mm:ss");
		this.timeOfTransaction = String.valueOf(formatDate.format(currentDate));
	}
}

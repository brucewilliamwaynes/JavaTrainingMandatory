/**
 * 
 */
package com.training.sampleClassTypes;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.training.objectOrientedProgramming.Bank;
import com.training.utility.InputScanner;

/**
 * @author bridgelabz
 *
 */
public class StockAccount {

	/**
	 * @param args
	 */
	
	public static void processCustomer(Customer customerNew){
		
		String choice = null;
		
		ArrayList<Stock> stockList = Bank.getStockList();
		
		Stock stockElement = null;
		Stock stockDetails = null;
		
		InputScanner sc = new InputScanner();
		
		do{
			
			System.out.println("Enter 1 to Buy Share,2 To Sell Share, 3 to find Evaluation of customer, 4 to save the details ");
			
			choice  = sc.inputString();
			
			
			if(choice == "1"){
				
				System.out.println("Enter name of Stock!");
				
				String stockName = sc.inputString();
				
				if(!Validation.doesStockExist(stockList,stockName)){
					System.out.println("No Such company Exists !");
					continue;
				}
				
				stockElement = Validation.searchStock(stockList, stockName);
				
				stockDetails = Transaction.processPurchase(customerNew,stockElement);
				
			}
			else if(choice == "2"){
				
			}
			else if (choice == "3"){
				
			}
			else if (choice == "4"){
				Transaction.updateTransactionJSON(customerNew, stockDetails,"+");
			}
			else {
				System.out.println("Wrong choice! Please enter a valid choice!");
			}
		}while(!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")) ;
	}
}

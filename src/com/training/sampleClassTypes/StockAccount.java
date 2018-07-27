/**
 * 
 */
package com.training.sampleClassTypes;

import org.json.simple.JSONObject;

/**
 * @author bridgelabz
 *
 */
public class StockAccount {

	/**
	 * @param args
	 */
	public static void processCustomer(JSONObject customer){
				System.out.println("Hello " + customer.get("Name"));
				System.out.println("You have " + customer.get("Balance") + "$ as your current balance!");
				
	}
}

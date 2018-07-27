/**
 * 
 */
package com.training.sampleClassTypes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author bridgelabz
 *
 */
public class Validation {
	public static boolean isUserACustomer(JSONObject fileJSONObject,String userName){
		if(fileJSONObject.containsKey(userName))
			return true;
		return false;
	}
	
	public static boolean isAccountNumberCorrect(JSONObject fileJSONObject,int accNumber ){
		for(Object key : fileJSONObject.keySet()){
			JSONObject itemObject = (JSONObject)fileJSONObject.get(key);
			if(itemObject.get("AccNumber").equals(String.valueOf(accNumber)))
					return true;
		}
		return false;
	}
	public static boolean doesStockExist(JSONObject fileJSONObject,String stockName){
		JSONArray stockList = (JSONArray)fileJSONObject.get("StockList");
		if(stockList.contains(stockName))
			return true;
		return false;
	}
}

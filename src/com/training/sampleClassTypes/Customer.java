/**
 * 
 */
package com.training.sampleClassTypes;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.training.utility.InputScanner;

/**
 * @author bridgelabz
 *
 */
public class Customer {
	private String name;
	private double balanceAvailable;
	private String mobileNumber;
	private static JSONObject customerJSON;
	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the accountNumber
	 */
	/**
	 * @return the balanceAvailable
	 */
	public double getBalanceAvailable() {
		return this.balanceAvailable;
	}
	/**
	 * @param balanceAvailable the balanceAvailable to set
	 */
	public void setBalanceAvailable(double balanceAvailable) {
		this.balanceAvailable = balanceAvailable;
	}
	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return this.mobileNumber;
	}
	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public static Customer createNewUser(String name, String phoneNumber,String balance) {
		// TODO Auto-generated method stub
		Customer customerNew = new Customer();
		customerNew.setName(name);
		customerNew.setMobileNumber(phoneNumber);
		customerNew.setBalanceAvailable(Double.parseDouble(balance));
		return customerNew;
	}
	
	public static void addToCustomerList(ArrayList<Customer> customerList, Customer customer){
		customerList.add(customer);
	}
	
	public static void updateCustomerJSON(Customer customerNew) {
		// TODO Auto-generated method stub
		JSONObject customerObj =  new JSONObject();
		customerObj.put("PhoneNumber", customerNew.getMobileNumber());
		customerObj.put("Balance", String.valueOf(customerNew.getBalanceAvailable()));
		customerObj.put("Name",customerNew.getName());
		customerJSON.put("",customerObj);
	}
	
	
	public static void updateListInitialize(ArrayList<Customer> customerList) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Enter Customer JSON file destination!");
		customerJSON = InputScanner.readJSONFromFile();
		for(Object key : customerJSON.keySet()){
			JSONObject customer = (JSONObject)customerJSON.get(key);
			Customer customerElement = new Customer();
			customerElement.setName(String.valueOf(customer.get("Name")));
			customerElement.setBalanceAvailable(Double.valueOf((String) customer.get("Balance")));
			customerElement.setMobileNumber((String)customer.get("PhoneNumber"));
			customerList.add(customerElement);
		}
	}
}

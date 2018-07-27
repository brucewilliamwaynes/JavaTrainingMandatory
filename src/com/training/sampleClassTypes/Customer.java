/**
 * 
 */
package com.training.sampleClassTypes;

import java.util.ArrayList;

import org.json.simple.JSONObject;

/**
 * @author bridgelabz
 *
 */
public class Customer {
	private String name;
	private double balanceAvailable;
	private String mobileNumber;
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
	
	public static void updateCustomerJSON(JSONObject customerJSON, Customer customerNew) {
		// TODO Auto-generated method stub
		customerJSON.put("PhoneNumerr", customerNew.getMobileNumber());
		customerJSON.put("Balance", String.valueOf(customerNew.getBalanceAvailable()));
		customerJSON.put("Name",customerNew.getName());
	}
	
}

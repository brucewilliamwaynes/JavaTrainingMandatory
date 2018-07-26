/**
 * 
 */
package com.training.objectOrientedProgramming;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.training.sampleClassTypes.Inventory;
import com.training.utility.InputScanner;

/**
 * @author brucewilliamwaynes
 *
 */
public class InventoryManagement {
	
	/*
	 * Finding if item is present or not!
	 * In InsideList
	 */
	public static boolean isItemPresentInList(ArrayList<Inventory> itemList, String itemName){
		for(int i=0;i<itemList.size();i++){
			if(itemList.get(i).getName().compareTo(itemName) == 0)
				return true;
		}
		return false;
	}
	
	/*
	 * Find the price of an item , present in Inventory List
	 */
	
	public static double calculatePriceOfItem(ArrayList<ArrayList<Inventory>> inventoryList, String item){
		
		for(int i=0;i<inventoryList.size();i++){
			/*
			 * Going into the different types if available!
			 */
			ArrayList<Inventory> itemList = inventoryList.get(i);
			//Check if Item is Present in List ! 
			if(isItemPresentInList(itemList,item)){
				/*
				 * If Present in Inventory List , then find the inventory price for that item and set the price!
				 */
				for(Inventory element : itemList){
					if(element.getName().compareTo(item) == 0){
						element.setInventoryPrice(element.getrate() * element.getWeight());
						return element.getInventoryPrice();
					}
				}//Coming out of Individual Inventory List
			}//Coming out if item present or not 
		}//Coming out of the entire List holding individual Inventory List
		
		/*
		 * If Item not found return 0.0 !
		 */
		return 0.0;
	}
	
	public static ArrayList<Inventory> searchInventoryForItem(ArrayList<ArrayList<Inventory>> inventoryObjectList,String item){
		ArrayList<Inventory> itemList;
		for(int i=0;i<inventoryObjectList.size();i++){
			itemList = inventoryObjectList.get(i);
			if(isItemPresentInList(itemList,item))
				return itemList;
		}
		return null;
	}
	
	public static void addInventory(ArrayList<ArrayList<Inventory>> inventoryObjectList, String item){
		ArrayList<Inventory> itemList = searchInventoryForItem(inventoryObjectList,item);
//		Inventory element 
		if(itemList != null){
		
		}
	}
	
	
	public static void main(String args[])throws Exception{
		JSONObject fileJSONObj = InputScanner.readJSONFromFile();
		ArrayList<ArrayList<Inventory>> inventoryObjectList = new ArrayList<ArrayList<Inventory>>();
		inventoryObjectList = InventoryFactory.buildInventoryList(fileJSONObj);
		/*
		ArrayList<Inventory> inventoryItemList = new ArrayList<Inventory>();
		inventoryItemList = InventoryFactory.buildInventoryItemList(fileJSONObj);
		*/
	}
}

/**
 * 
 */
package com.training.objectOrientedProgramming;

import java.util.ArrayList;

import org.json.simple.JSONObject;

/**
 * @author brucewilliamwaynes
 *
 */
public class InventoryManagement {
	public void manageInventory(){
		try {
			ArrayList<CreateInventory> inventoryObjects = (ArrayList<CreateInventory>) InventoryFactory.createInventoryObjects();
			inventoryObjects.get(0).workingWithInventory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[])throws Exception{
		InventoryManagement inventoryManagementObj = new InventoryManagement();
		inventoryManagementObj.manageInventory();
	}
}

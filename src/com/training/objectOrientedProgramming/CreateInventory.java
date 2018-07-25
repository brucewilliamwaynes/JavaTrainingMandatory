package com.training.objectOrientedProgramming;

import com.training.utility.InputScanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/*
JSON Parsing using simpleJSON Object
Creating a JSON of Inventory including attributes as name / weight / $ per kg for each one of Rice , Pulse and Wheat.
 */
public class CreateInventory{

    private JSONObject inventoryObj;

    CreateInventory(){
        this.inventoryObj = new JSONObject();
    }

    public void addToJSONArray(String categoryName,JSONArray categoryArray){
        Map myMap = new LinkedHashMap(3);
        InputScanner.getInventoryDetails(myMap);
        categoryArray.add(myMap);
        this.inventoryObj.put(categoryName, categoryArray);
    }

    public void addToJSONObject(String categoryName){
        Map myMap = new LinkedHashMap(3);
        InputScanner.getInventoryDetails(myMap);
        this.inventoryObj.put(categoryName,myMap);
    }

    public void initializeInventory(String categoryName){
        if(this.inventoryObj.containsKey(categoryName)){
            if(this.inventoryObj.get(categoryName).getClass().getName().compareTo("org.json.simple.JSONArray") == 0) {
                JSONArray categoryArray = (JSONArray) this.inventoryObj.get(categoryName);
                this.addToJSONArray(categoryName,categoryArray);
            }
            else{
                this.addToJSONObject(categoryName);
            }
        }
        else{
            InputScanner inputScannerObj = new InputScanner();
            System.out.println("Does the category contains variety!");
            boolean variety = inputScannerObj.inputBoolean();
            if(variety){
                JSONArray categoryArray = new JSONArray();
                this.addToJSONArray(categoryName,categoryArray);
            }
            else{
                this.addToJSONObject(categoryName);
            }
        }
    }
    
    public void removeItemFromInventory(String itemName , String categoryName){
    	if(this.inventoryObj.get(categoryName).getClass().getName().compareTo("org.json.simple.JSONArray") == 0){
    		JSONArray categoryArray = (JSONArray)this.inventoryObj.get(categoryName);
    		for(int i=0;i<categoryArray.size();i++){
    			JSONObject itemList = (JSONObject) categoryArray.get(i);
    			if(itemList.get("name").equals(itemName)){
    				categoryArray.remove(itemList);
    			}
    		}
    	}
    	else{
//    		JSONObject itemObject = (JSONObject) this.inventoryObj.get(categoryName);
    		Map itemList = (Map)this.inventoryObj.get(categoryName);
    		if(itemList.get("name").equals(itemName)){
//    			this.inventoryObj.remove(itemList);
//    			this.inventoryObj.remove(itemObject);
    			this.inventoryObj.remove(categoryName);
    		}
    	}
    }
    

    public boolean isItemPresentInInventory(String itemName, String categoryName){
<<<<<<< HEAD
        if(this.inventoryObj.get(categoryName).getClass().getName().compareTo("org.json.simple.JSONArray") == 0) {
            JSONArray categoryArray = (JSONArray) this.inventoryObj.get(categoryName);
            for (int i = 0; i < categoryArray.size(); i++) {
                JSONObject itemList = (JSONObject) categoryArray.get(i);
                if (itemList.get("name").equals(itemName)) {
                    return true;
                }
            }
=======
        if(this.inventoryObj.get(categoryName).getClass().getName().compareTo("org.json.simple.JSONArray") == 0){
	    	JSONArray categoryArray = (JSONArray)this.inventoryObj.get(categoryName);
	        for(int i=0;i<categoryArray.size();i++){
	            JSONObject itemList = (JSONObject) categoryArray.get(i);
	            if(itemList.get("name").equals(itemName)){
	                return true;
	            }
	        }
        }
        else{
        	Map itemList = (Map) this.inventoryObj.get(categoryName);
        	if(itemList.get("name").equals(itemName)){
        		return true;
        	}
>>>>>>> 1dd442f5aa357491f30c0301b67c6bfbb2f68c2e
        }
        else{
            JSONObject itemList = (JSONObject) this.inventoryObj.get(categoryName);
            if(itemList.get("name").equals(itemName))
                return true;
        }
        return false;
    }

    public double calculateValueOfItem(String itemName,String categoryName){
<<<<<<< HEAD
        if(this.inventoryObj.get(categoryName).getClass().getName().compareTo("org.json.simple.JSONArray") == 0) {
            JSONArray categoryArray = (JSONArray) this.inventoryObj.get(categoryName);
            for (int i = 0; i < categoryArray.size(); i++) {
                JSONObject itemList = (JSONObject) categoryArray.get(i);
                if (itemList.get("name").equals(itemName)) {
                    return Double.valueOf(String.valueOf(itemList.get("weight"))) * Double.valueOf(String.valueOf(itemList.get("value")));
                }
            }
        }
        else{
            JSONObject itemList = (JSONObject) this.inventoryObj.get(categoryName);
            if(itemList.get("name").equals(itemName)){
                return Double.valueOf(String.valueOf(itemList.get("weight"))) * Double.valueOf(String.valueOf(itemList.get("value")));
            }
        }
=======
    	if(this.inventoryObj.get(categoryName).getClass().getName().compareTo("org.json.simple.JSONArray") == 0){
	        JSONArray categoryArray = (JSONArray) this.inventoryObj.get(categoryName);
	        for(int i=0;i<categoryArray.size();i++){
	            JSONObject itemList = (JSONObject) categoryArray.get(i);
	            if(itemList.get("name").equals(itemName)){
	                return Double.valueOf(String.valueOf(itemList.get("weight"))) * Double.valueOf(String.valueOf(itemList.get("price")));
	            }
	        }
    	}
    	else{
    			Map itemList = (Map) this.inventoryObj.get(categoryName);
    			if(itemList.get("name").equals(itemName)){
    				return Double.valueOf(String.valueOf(itemList.get("weight"))) * Double.valueOf(String.valueOf(itemList.get("price")));
    			}
    	}
>>>>>>> 1dd442f5aa357491f30c0301b67c6bfbb2f68c2e
        return 0.0;
    }

    public void processItemOfCategory(String categoryName,String toDo){
    	InputScanner inputScannerObj = new InputScanner();
    	if(toDo.compareTo("calculate") ==0){
	        System.out.println("Enter item to calculate Value!");
	        String itemName = inputScannerObj.inputString();
	        if(isItemPresentInInventory(itemName,categoryName)){
	            System.out.println(calculateValueOfItem(itemName,categoryName));
	        }
	        else{
	            System.out.println("Opps! Item Missing!");
	        }
    	}
    	else if(toDo.compareTo("remove") == 0){
    		System.out.println("Enter item to remove");
    		String itemName = inputScannerObj.inputString();
    		if(isItemPresentInInventory(itemName,categoryName)){
    			removeItemFromInventory(itemName,categoryName);
    		}
    		else{
    			System.out.println("Cannot Delete Item not found!");
    		}
    	}
    }

    public void workingWithInventory() throws Exception{
        InputScanner inputScannerObj = new InputScanner();
        CreateInventory createInventoryObj = new CreateInventory();
        String choice;
        String type = "";
        while (true){
            System.out.println("Enter 1 to read Inventory details from file, 2 To write Inventory details to file, 3 to create/add  Inventory,4 to calculate value of item in  inventory, 5 to Remove Item form Inventory ,0 to Exit!");
            choice = inputScannerObj.inputString();
            if(choice.compareTo("1") == 0){
                //Read from JSON
            	JSONObject readFileObj = InputScanner.readJSONFromFile();
            	createInventoryObj.inventoryObj = readFileObj;
            }
            else if(choice.compareTo("2") == 0){
                //Write to File in JSON format
                String fileDestination = InputScanner.createJSON(createInventoryObj.inventoryObj);
            }
            else if(choice.compareTo("3") == 0) {
                System.out.println("Enter category name!");
                type = inputScannerObj.inputString();
                createInventoryObj.initializeInventory(type);
            }
            else if(choice.compareTo("4") == 0){
                String categoryName;
                do {
                    System.out.println("Enter category of inventory to calculate value!");
                    categoryName = inputScannerObj.inputString();
                }while(!createInventoryObj.inventoryObj.containsKey(categoryName));
                createInventoryObj.processItemOfCategory(categoryName,"calculate");
                /*
                JSONArray categoryItemArray = (JSONArray) createInventoryObj.inventoryObj.get(categoryName);
                createInventoryObj.processItemOfCategory(categoryItemArray);
                */
            }
            else if(choice.compareTo("5") == 0){
            	String categoryName;
            	System.out.println("Enter category of item, to be removed!");
            	categoryName = inputScannerObj.inputString();
            	createInventoryObj.processItemOfCategory(categoryName,"remove");
            }
            else
                break;
        }
    }
}

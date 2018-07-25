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
public class CreateInventory {

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

    public boolean isItemPresentInInventory(String itemName, String categoryName){
        if(this.inventoryObj.get(categoryName).getClass().getName().compareTo("org.json.simple.JSONArray") == 0) {
            JSONArray categoryArray = (JSONArray) this.inventoryObj.get(categoryName);
            for (int i = 0; i < categoryArray.size(); i++) {
                JSONObject itemList = (JSONObject) categoryArray.get(i);
                if (itemList.get("name").equals(itemName)) {
                    return true;
                }
            }
        }
        else{
            JSONObject itemList = (JSONObject) this.inventoryObj.get(categoryName);
            if(itemList.get("name").equals(itemName))
                return true;
        }
        return false;
    }

    public double calculateValueOfItem(String itemName,String categoryName){
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
        return 0.0;
    }

    public void processItemOfCategory(String categoryName){
        InputScanner inputScannerObj = new InputScanner();
        System.out.println("Enter item to calculate Value!");
        String itemName = inputScannerObj.inputString();
        if(isItemPresentInInventory(itemName,categoryName)){
            System.out.println(calculateValueOfItem(itemName,categoryName));
        }
        else{
            System.out.println("Opps! Item Missing!");
        }
    }

    public void workingWithInventory() {
        InputScanner inputScannerObj = new InputScanner();
        CreateInventory createInventoryObj = new CreateInventory();
        String choice;
        String type = "";
        while (true){
            System.out.println("Enter 1 to read Inventory details from file, 2 To write Inventory details to file, 3 to create Inventory,4 to calculate value for inventory, 0 to Exit!");
            choice = inputScannerObj.inputString();
            if(choice.compareTo("1") == 0){
                //Read from JSON
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
                createInventoryObj.processItemOfCategory(categoryName);
                /*
                JSONArray categoryItemArray = (JSONArray) createInventoryObj.inventoryObj.get(categoryName);
                createInventoryObj.processItemOfCategory(categoryItemArray);
                */
            }
            else
                break;
        }
    }
}

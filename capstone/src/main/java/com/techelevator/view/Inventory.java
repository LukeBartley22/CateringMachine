package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*
STOCK hash map with EX> A1, quantity 7
INVENTORY hash map that imports the catering file
make map with slot # and quantity
make map with slot #, price , catagory and name
 */
public class Inventory {

    private static final Map<String, Integer> initialInventory = new HashMap<>();  //initializing maps for both the stock w quantity and one with complete item info
    private final Map<String, Product> itemMap = new HashMap<>();


    public Inventory() {
        String filePath = "catering.csv";
        File inputFile = new File(filePath);

        initialInventory.put("A1", 7);                                      //initializes inventory to the maximum 0f 7 prior to running the app
        initialInventory.put("A2", 7);
        initialInventory.put("A3", 7);
        initialInventory.put("A4", 7);
        initialInventory.put("B1", 7);
        initialInventory.put("B2", 7);
        initialInventory.put("B3", 7);
        initialInventory.put("B4", 7);
        initialInventory.put("C1", 7);
        initialInventory.put("C2", 7);
        initialInventory.put("C3", 7);
        initialInventory.put("C4", 7);
        initialInventory.put("D1", 7);
        initialInventory.put("D2", 7);
        initialInventory.put("D3", 7);
        initialInventory.put("D4", 7);

        try {
            Scanner fileScanner = new Scanner(inputFile);                   //converting catering.csv to an array based on comma seperation
            while (fileScanner.hasNextLine()) {
                String thisLine = fileScanner.nextLine();                   //used while loop to add all items from the .csv file into an array than map
                String[] itemInfo = thisLine.split(",");

                String itemID = itemInfo[0];
                String itemName = itemInfo[1];
                String itemCategory = itemInfo[2];
                Double itemPrice = Double.parseDouble(itemInfo[3]);


                Product currentProduct = new Product(itemName, itemCategory, itemID, itemPrice);  // puts all the item info into the map

                itemMap.put(itemID, currentProduct);
            }
        } catch (FileNotFoundException e) {
            System.out.println("There was an error with your file");
        }


    }


    public Map<String, Integer> getInitialInventory() {
        return initialInventory;
    }

    public Map<String, Product> getItemMap() {
        return itemMap;
    }

    public double getItemPrice(String itemID) {
        return itemMap.get(itemID).getPrice();
    }

    public boolean checkInventory(String itemID) {          //checks if theres enough items in stock to be purchased
        if (initialInventory.get(itemID) <= 0) {
            return false;

        } else {
            int currentInventory = initialInventory.get(itemID);
            currentInventory--;
            initialInventory.put(itemID, currentInventory);
            return true;
        }
    }

    public String printedItems() {                          //displays inventory to user when they select either "display items" or " select item"
        String printStr = "";

        Set<String> IDs = initialInventory.keySet();    //taking keySet of initial inventory turning a set

        List<String> orderedIDs = Arrays.asList(IDs.toArray(new String[0])); // turning IDs set into List to display inventory in order
        orderedIDs.sort(null);   // List ListofKeys = new ArrayList (initialInventory.keySet())

        for (int i = 0; i < orderedIDs.size(); i++) {
            String ID = orderedIDs.get(i);

            if (initialInventory.get(ID) > 0) {
                printStr += "\n" + itemMap.get(ID).getItemID() + " " + itemMap.get(ID).getItemName() +
                        " $" + String.format("%.2f", itemMap.get(ID).getPrice()) + " ," + initialInventory.get(ID);

            }
        }
        return printStr;
    }

}

package com.techelevator.view;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//include the audit printwriter to make a list of transactions
//make sure to add getters for the inventory nd drawer nd menu
//add the sales report method if time permits


public class CateringMachine {

    private final Inventory currentInventory = new Inventory();
    private final CashDrawer currentDrawer = new CashDrawer();
    private final Menu menu = new Menu();




    public void logger (double initialBalance, double newBalance, String type) {

        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        String dateAndTime = dateTime.format(LocalDateTime.now());

        File auditLog = new File("src/main/java/com/techelevator/filePath/auditLog.txt");

//      try (PrintWriter ghostWriter = new PrintWriter(auditLog, String.valueOf(true))){
        try(FileWriter ghostWriter = new FileWriter(auditLog, true)){
            if (!auditLog.exists()){
             PrintWriter writer = new PrintWriter("src/main/java/com/techelevator/filePath/auditLog.txt");
                auditLog.createNewFile();
            }
            ghostWriter.write(dateAndTime + " " + type + " $" + initialBalance + " $" + newBalance + "\n");
        } catch (IOException e) {
            System.err.println("Log not created.");
        }
    }





    //getters

    public Inventory getCurrentInventory() {
        return currentInventory;
    }

    public CashDrawer getCurrentDrawer() {
        return currentDrawer;
    }

    public Menu getMenu() {
        return menu;
    }
}

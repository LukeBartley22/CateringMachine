package com.techelevator.view;

import com.sun.tools.javac.Main;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/*
1. display main menu
switch statements
if user input is not valid
call cash drawer class to show money avaliable
 */
public class Menu {
   // public boolean shouldRun = true;
    public static CateringMachine cateringMachine = new CateringMachine(); //instantiating cateringmachine class

    public static void main(String[] args) {
        cateringMachine.getMenu().run();
    }

    public void run() {

        Scanner userInput = new Scanner(System.in);

        while (true) {

            System.out.println("***************************");      //Display initial user menu
            System.out.println("         Main Menu         ");
            System.out.println("(D) Display catering items");
            System.out.println("(P) Purchase item");
            System.out.println("(E) Exit ");
            System.out.println("***************************");


            System.out.println("Make a selection: ");                //Gather user input
            String userChoice = userInput.nextLine();
            String convertedChoice = userChoice.toUpperCase().trim(); // validate or check userinput


            if (convertedChoice.equals("D")) {                            //more validation with choice conditional statements
                System.out.println(Menu.cateringMachine.getCurrentInventory().printedItems()); //display menu items
            }

            if (convertedChoice.equals("P")) {              //call purchase menu method
                purchaseMenu();                         //show options to feed (m)oney, (s)elect item, and (f)inish transaction
            }

            if (convertedChoice.equals("E")) {
                                                            //exit program and stop running
                //shouldRun = false;
                System.out.println("Goodbye!");
                System.exit(1);

            } else if (!convertedChoice.equals("E") && !convertedChoice.equals("D") && !convertedChoice.equals("P")){
                System.out.println("Invalid choice, try again bozo");
            }



        }
// to-do -- build out


    }

    public void purchaseMenu() {   //display when choice p is selected

        Scanner userInput = new Scanner(System.in);

        while (true) {

            //get current money from drawer class
            double currentAmount = Menu.cateringMachine.getCurrentDrawer().getBalance();
            //starting balance
            double currentBalance = currentAmount;  // made for ease of use
            System.out.println("*********************");
            System.out.println("****Purchase Menu****");
            System.out.println("(M) Feed Money");
            System.out.println("(S) Select Item");
            System.out.println("(F) Finish Transaction");

            System.out.println("*********************");
            System.out.println("Time to make a choice. What would you like to do?");
            System.out.println("*********************");
            String choiceInput = userInput.nextLine();

            switch (choiceInput.toUpperCase().trim()) {
                case "M": {
                    System.out.println("Enter the amount would you like to add (Whole number/Integer) ");
                    int cashDeposit = 0;
                    double initialBalance = currentBalance;

                    try {
                        cashDeposit = Integer.parseInt(userInput.nextLine().trim());   //converts user input of a string to an integer

                    } catch (Exception e) {
                        System.out.println("Please enter: 1, 5, 10, 20");
                    }
                    if (cashDeposit < 1) {
                        System.out.println("Please enter: 1, 5, 10, 20");      //defensive programming so you dont break my code
                    }
                    if (cashDeposit == 1 || cashDeposit == 5 || cashDeposit == 10 || cashDeposit == 20) {
                        Menu.cateringMachine.getCurrentDrawer().addCash(cashDeposit);
                        System.out.println("Deposited: $ " + cashDeposit);
                        currentAmount = Menu.cateringMachine.getCurrentDrawer().getBalance();
                        System.out.println("$ " + currentAmount);                   //System.out.println() current money provided

                        Menu.cateringMachine.logger(initialBalance, currentAmount, "Enter money");       //add audit method from cateringmachine class to log the transaction

                    } else {
                        System.out.println("Please enter: 1, 5, 10, 20 ");     //more defensive programming
                    }
                    break;
                }
                case "S":
                    System.out.println("Which item? ");
                    System.out.println(Menu.cateringMachine.getCurrentInventory().printedItems()); //print menu items from method in inventory class
                    System.out.println("Enter item ID: ");
                    String idInput = userInput.nextLine().toUpperCase().trim();                            //convert string to uppercase

                    if (!Menu.cateringMachine.getCurrentInventory().getInitialInventory().containsKey(idInput)) {
                        System.out.println("Not valid item ID, try again.");

                    } else if (!Menu.cateringMachine.getCurrentDrawer().verifyPrice(idInput)) {         //checks if balance is enough to purchase selected item
                        System.out.println("Not enough money.");
                    } else if (!Menu.cateringMachine.getCurrentInventory().checkInventory(idInput)) {       //Checks if item is out of stock
                        System.out.println("Product is sold out.");
                    } else {
                        Product currentItem = Menu.cateringMachine.getCurrentInventory().getItemMap().get(idInput);
                        Menu.cateringMachine.getCurrentDrawer().deductPrice(currentItem.getPrice());
                        System.out.println("Congrats you get to eat!");
                        System.out.println(currentItem.getItemName() + " Cost: $" + String.format("%.2f", currentItem.getPrice()) + " Balance: $" + String.format("%.2f", Menu.cateringMachine.getCurrentDrawer().getBalance()));
                        System.out.println(currentItem.getSound());

                        currentAmount = Menu.cateringMachine.getCurrentDrawer().getBalance();        //try to move around the if statments so that we are coding for what we're looking for first
                        Menu.cateringMachine.logger(currentBalance, currentAmount, currentItem.getItemName() + " " + currentItem.getItemID());// audit methods


                    }

                    break;
                case "F": {
                    currentAmount = Menu.cateringMachine.getCurrentDrawer().getBalance();
                    double initialBalance = currentAmount;

                   // CashDrawer drawer = Menu.cateringMachine.getCurrentDrawer();
                    System.out.println("Take your money back.");
                    String change = Menu.cateringMachine.getCurrentDrawer().returnChange();  //prints out change to e given back
                    System.out.println(change);


                    //audit method
                    currentAmount = Menu.cateringMachine.getCurrentDrawer().getBalance();
                    Menu.cateringMachine.logger(initialBalance, currentAmount,"Change Returned");

                    return;

                }

            }

        }

    }

}






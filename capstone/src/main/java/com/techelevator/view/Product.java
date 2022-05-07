package com.techelevator.view;

public class Product {

    private final String itemName;
    private final String itemCategory;
    private final String itemID;
    private final double price;

    public Product (String itemName, String itemCategory, String itemID, double price ){
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemID = itemID;
        this.price = price;
    }



    public String toMunch() {

        String sound;
        if(this.itemCategory.equals("Dessert")) {
            sound = "Sugar Sugar, so Sweet!";
        } else if(this.itemCategory.equals("Munchy")) {
            sound = "Munchy Munchy, so Good!";
        } else if(this.itemCategory.equals("Sandwich")) {
            sound = "Sandwich So Delicious, Yum!";
        } else if(this.itemCategory.equals("Drink")) {
            sound = "Drinky Drinky, Slurp Slurp!";
        } else {
            sound = "Tastes like McGarbage! ";
        }
        return sound;
    }
    //add sounds for each type of item crunch crunch, munch munch, etc.


    // getters
    public String getItemName() {
        return itemName;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public String getItemID() {
        return itemID;
    }

    public double getPrice() {
        return price;
    }


    public String getSound() {
        return toMunch();
    }

}

package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

public class ProductTests {

    @Test

    public void checkConstructorBuild(){
        String expected = "Nachos";

        Product product = new Product("Nachos", "Munchy", "A1", 3.85);
        String actual = product.getItemName();

        Assert.assertEquals(expected,actual);

    }

    @Test

    public void checkConstructorItemCategory(){
        String expected = "Munchy";

        Product product = new Product("Nachos", "Munchy", "A1", 3.85);
        String actual = product.getItemCategory();

        Assert.assertEquals(expected,actual);

    }

    @Test

    public void checkConstructorItemID(){
        String expected = "A1";

        Product product = new Product("Nachos", "Munchy", "A1", 3.85);
        String actual = product.getItemID();

        Assert.assertEquals(expected,actual);

    }

    @Test

    public void checkConstructorItemPrice(){
        double expected = 3.85;

        Product product = new Product("Nachos", "Munchy", "A1", 3.85);
        double actual = product.getPrice();

        Assert.assertEquals(expected,actual,0);

    }

    @Test

    public void checkConstructorSoundOutput(){
        String expected = "Munchy Munchy, so Good!";

        Product product = new Product("Nachos", "Munchy", "A1", 3.85);
        String actual = product.getSound();

        Assert.assertEquals(expected,actual);

    }

    @Test

    public void checkConstructorSandwichSoundOutput(){
        String expected = "Sandwich So Delicious, Yum!";

        Product product = new Product("Walking Tacos", "Sandwich", "A2", 5.25);
        String actual = product.getSound();

        Assert.assertEquals(expected,actual);

    }

    @Test

    public void checkConstructorDrinkSoundOutput(){
        String expected = "Drinky Drinky, Slurp Slurp!";

        Product product = new Product("Mountain Melter", "Drink", "A3", 2.35);
        String actual = product.getSound();

        Assert.assertEquals(expected,actual);

    }

    @Test

    public void checkConstructorDessertSoundOutput(){
        String expected = "Sugar Sugar, so Sweet!";

        Product product = new Product("Chocolate Bar", "Dessert", "A4", 1.75);
        String actual = product.getSound();

        Assert.assertEquals(expected,actual);

    }

    @Test

    public void checkConstructorSoundOutputForInvalidInput(){
        String expected = "Tastes like McGarbage! ";

        Product product = new Product("McTrash", "Crunchy", "A5", 3.85);
        String actual = product.getSound();

        Assert.assertEquals(expected,actual);

    }



}

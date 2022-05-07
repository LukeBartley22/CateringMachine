package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

public class CashDrawerTest {
    @Test


    public void checksAddAndSubtractMethod () {
        CashDrawer addMethod = new CashDrawer();
        addMethod.addCash(5);
        addMethod.deductPrice(5);
        double balance = 0.00;

        double actualBalance = addMethod.getBalance();

        Assert.assertEquals(balance, actualBalance, 0);

    }

    @Test

    public void checkAddMethod () {
        CashDrawer addMethod = new CashDrawer();
        addMethod.addCash(2);
        double expected = 2.00;

        double actualBalance = addMethod.getBalance();

        Assert.assertEquals(expected,actualBalance, 0);
    }

    @Test

    public void checkAddMethodEdgeCase () {
        CashDrawer addMethod = new CashDrawer();
        addMethod.addCash(0);
        double expected = 0.00;

        double actualBalance = addMethod.getBalance();

        Assert.assertEquals(expected,actualBalance, 0);
    }









//    @Test
//
//    public void checksVerifyCostByItemIDMethod () {
//        CashDrawer verifyCost = new CashDrawer();
//        verifyCost.verifyPrice("D4");
//        boolean expected = false;
//
//        boolean actual = verifyCost.verifyPrice("D4");
//
//
//
//
//
//    }






}

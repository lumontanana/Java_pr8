/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8.generics.shop;

import lab8.generics.vegetable.Vegetable;
import lab8.basic.Customer;

/**
 *
 * @author julia
 */
public class GenericsTester1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Grocery g = new Grocery(20);
        g.storeNewSuppliesFromTruck();
        
        System.out.println("Generics: ");
        g.showAllItems();
        System.out.println("===================\n\n");
        
        System.out.println("Raw: ");
        g.showAllItemsRaw();
        System.out.println("===================\n\n");
        
        //Uncomment and test this line of code and try to understand what happens
        //System.out.println(g.stock.toString().replaceAll(",", "\n"));
        Vegetable v1 = UsingGenerics.getMostExpensiveItem1(g.stock);
        Vegetable v2 = UsingGenerics.getMostExpensiveItem2(g.stock);
        System.out.println("v1 is " + v1);
        System.out.println("v2 is " + v2);
        System.out.println("is v1 equals to f2? " + v1.equals(v2));
        
        //Uncomment to see Thinking Point T15
        /*
        Customer pepe = new Customer("PEPE rodriguez","X00000");
        g.stock.add(pepe);
        */
                
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8.generics.shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import lab8.basic.Customer;
import lab8.basic.CustomerFinder;
import lab8.basic.NoCustomerFound;
import lab8.generics.vegetable.Vegetable;
import lab8.util.Util;

/**
 *
 * @author julia
 */
public class GenericsTester4 {

    static final int NUM_ELEM = 100;
    //static Random r = new Random(888);
    static Random r = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoCustomerFound {

        Grocery g = new Grocery(NUM_ELEM);
        g.storeNewSuppliesFromTruck();

        int numItemsAtBasket = r.nextInt(15) + 7;
        System.out.println("numItemsAtBasket is " + numItemsAtBasket);
        Vegetable[] bought = new Vegetable[numItemsAtBasket];
        ArrayList basket = new ArrayList(numItemsAtBasket);
        int index = 1, item = -1;
        Vegetable f;

        for (int i = 0; i < numItemsAtBasket; i++) {
            System.out.println("index is " + index);
            do {
                item = r.nextInt(NUM_ELEM);
                System.out.println("item is " + item);
                f = g.stock.get(item);
                index = basket.indexOf(f);
                System.out.println("index is " + index);
            } while (index != -1);
            basket.add(g.stock.get(item));
            bought[i] = g.stock.get(item);
            System.out.println("Element " + i + " treated.");

        }
        
        System.out.println("\nBefore sorting " + basket.toString().replaceAll(",", "\n"));
        Collections.sort(basket);
        System.out.println("\n\nAfter sorting " + basket.toString().replaceAll(",", "\n"));

        ArrayList boughtAL = new ArrayList(Arrays.asList(bought));
       
        int customerId = r.nextInt(10000);
        boolean found = false;
        Customer c = null;
        try {
            CustomerFinder cf = new CustomerFinder();
            while (!found) {
                try {
                    c = cf.getCustomer(customerId);
                    found = true;
                } catch (NoCustomerFound ncf) {
                    customerId = r.nextInt(10000);
                }
            }
            
            Util.showVegetableList(boughtAL, c);
        } catch (IOException ex) {
            System.out.println("Problems painting the shopping list items " +ex);
        }
    }

}

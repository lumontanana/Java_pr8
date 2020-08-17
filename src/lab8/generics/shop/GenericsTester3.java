/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8.generics.shop;

import lab8.generics.vegetable.Root;
import lab8.generics.vegetable.Vegetable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author julia
 */
public class GenericsTester3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Grocery g = new Grocery(200);
        g.storeNewSuppliesFromTruck();

        ArrayList al = UsingGenerics.returnRootsArrayListBasic(g.stock);
        ArrayList<Root> al2 = UsingGenerics.returnRootsArrayListGeneric(g.stock);
        Vegetable[] fs = new Vegetable[g.stock.size()];

        Root[] ms = UsingGenerics.returnRootsInCurrentCharListArray(fs);

        Vegetable veg1 = UsingGenerics.getMostExpensiveItem2(al);
        System.out.println(al.toString().replaceAll(",", "\n"));
        System.out.println("most expensive: " + veg1.toString());
        //Part 4.4.5
       // Vegetable veg2 = UsingGenerics.getMostExpensiveItem2(al2);
        //When next line compiles, you can comment previous one
        //Part 4.4.6
        //Vegetable veg3 = UsingGenerics.getMostExpensiveItem3(al2);
        //System.out.println("most expensive: " + veg3.toString());
    }
}

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
import lab8.basic.*;

/**
 *
 * @author julia
 */
public class GenericsTester2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Grocery g = new Grocery(200);
        g.storeNewSuppliesFromTruck();
        
        ArrayList al = UsingGenerics.returnRootsArrayListBasic(g.stock);
        ArrayList<Root> al2 = UsingGenerics.returnRootsArrayListGeneric(g.stock);
        Vegetable[] vs = new Vegetable[g.stock.size()];
        vs = g.stock.toArray(vs);
        Root[] rs =  UsingGenerics.returnRootsInCurrentCharListArray(vs);   
              
        //part 4.4.4
        //add your code here to see if they contain the right objects
        
        //....
        
        ///   
    }
}

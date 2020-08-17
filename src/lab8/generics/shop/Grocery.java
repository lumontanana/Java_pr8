/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8.generics.shop;

import lab8.generics.vegetable.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import lab8.util.Util;

/**
 *
 * @author julia
 */
public class Grocery {

    int NUM_ELEMS_SUPPLIED = 100;
    static Random r;
    static String[] origins = {"Spain", "Africa", "Chile", "Argentina", "Central America"};
    static String[] types = {"Flower", "Root", "Fruit"};
    static String[][] subtypes = {{"Cauliflower", "Broccoli"}, {"Carrot", "Radish"}, {"Raf", "Pear","Pepper"}};

    static {
        r = new Random(1);
    }

    public ArrayList<Vegetable> stock = new ArrayList<>();
    
    
       public Grocery(int initialStock){
        NUM_ELEMS_SUPPLIED = initialStock;
    }

    public void storeNewSuppliesFromTruck() {
        System.out.println("---- Filling stock with " + NUM_ELEMS_SUPPLIED + " items ----");
        for (int i = 0; i < NUM_ELEMS_SUPPLIED; i++) {
            stock.add(generateItem());
        }
        System.out.println();
    }


    /* This method generates a Vegetable randomly, it has to be an
     instantiable object, so a raf, pepper, radish, carrot ...
     */
    public Vegetable generateItem() {

        //ratio 
        double ratio = r.nextDouble();
        if (ratio < 0.1) {
            ratio = 0.10;
        } else if (ratio > 0.85) {
            ratio = 1.0;
        }

        //origin
        String o = origins[r.nextInt(origins.length - 1)];

        //type of vegetable
        int which = r.nextInt(types.length);
        //we access subtypes
        String[] subtype = subtypes[which];
        int which2 = r.nextInt(subtype.length);
        //finally we know which one
        String nameClass = subtype[which2];
        String nameClass2 = "lab8.generics.vegetable." + nameClass;

        //Code to instantiate the object
        //for example if nameClass is "lab8.generics.vegetable.Pepper
        //it does veg = new Pepper();
        //You don't have to understand everything below, this uses Reflection
        Vegetable veg = null;
        try {
            veg = (Vegetable) (Class.forName(nameClass2).getConstructor().newInstance());
        } catch (ClassNotFoundException ex1) {
            System.out.println("Exception 1 ocurred " + ex1);
        } catch (NoSuchMethodException ex2) {
            System.out.println("Exception 2 ocurred " + ex2);
        } catch (InstantiationException ex3) {
            System.out.println("Exception 3 ocurred " + ex3);
        } catch (IllegalAccessException ex4) {
            System.out.println("Exception 4 ocurred " + ex4);
        } catch (IllegalArgumentException ex5) {
            System.out.println("Exception 5 ocurred " + ex5);
        } catch (InvocationTargetException ex6) {
            System.out.println("Exception 6 ocurred " + ex6);
        }

        //we put the origin in the vegetable
        veg.setOrigin(o);

        //some random values for the fields depending on the kind of
        //vegetable we got at veg
        if (veg instanceof Carrot) {
            //it needs a color between 3
            int c = (int)(Math.random()*3);
            Carrot.Color color = Carrot.Color.values()[c];
            ((Carrot) veg).setColor(color);            
            ((Carrot) veg).setPricePerBunch(Util.generateDoubleNumber(0.9, 1.5));
        }
        
        //Radish
        if (veg instanceof Radish) {
            //it needs a color between 3
            int t = (int)(Math.random()*2);
            Radish.Type type = Radish.Type.values()[t];
            ((Radish) veg).setType(type);            
            ((Radish) veg).setPricePerBunch(Util.generateDoubleNumber(1.9, 2.4));
        }

        //Raf
         if (veg instanceof Raf) {
            int r = (int) (Math.random() * 3);
            Tomato.Ripeness ripe = Tomato.Ripeness.values()[r];
            ((Raf) veg).setRipeness(ripe);
            ((Raf) veg).setPricePerWeight(Util.generateDoubleNumber(0.6, 1.5));
            ((Raf) veg).setWeight(Util.generateDoubleNumber(0.25, 1.9));
        }

        //Pear
        if (veg instanceof Pear) {
            int r = (int)(Math.random()*3);
            Tomato.Ripeness ripe = Tomato.Ripeness.values()[r];
            ((Pear) veg).setRipeness(ripe);
            ((Pear) veg).setPricePerWeight(Util.generateDoubleNumber(0.2, 0.5));
            ((Pear) veg).setWeight(Util.generateDoubleNumber(0.5, 1.1));
        }
         
        //Pepper
        if (veg instanceof Pepper) {
            int c = (int)(Math.random()*3);
            Pepper.Color color = Pepper.Color.values()[c];
            ((Pepper) veg).setColor(color);
            
        }

        //Broccoli
        if (veg instanceof Broccoli) {
            int s = (int)(Math.random()*3);
            Flower.Size size = Flower.Size.values()[s];
           ((Broccoli) veg).setSize(size);
        }
        
        //CauliFlower
        if (veg instanceof Cauliflower) {
            int s = (int)(Math.random()*3);
            Flower.Size size = Flower.Size.values()[s];
           ((Cauliflower) veg).setSize(size);
        }

        veg.computePrice();            
        return veg;
    }
    

    //This method has to print all items (vegetables) in the grocery stock,
    //but with the requirement of using an iterator
    //(with generics)
    //Notice it would be similar to stock.toString().replaceAll(",","\n");
    public void showAllItems() {
        //Part 4.3.1
        //Add your code here
        //CONDITION:  You need an iterator that will be declared with generics
    }

    public void showAllItemsRaw() {
        Iterator it = stock.iterator();
        Vegetable f;
        while (it.hasNext()) {
            f = (Vegetable) it.next();
            System.out.println(f.toString());
        }
    }

    public static void showAllItems3(HashMap sm) {
        Iterator it = sm.values().iterator();
        Vegetable f = null;
        while (it.hasNext()) {
            try {
                f = (Vegetable) it.next();
                System.out.println(f.toString());
            } catch (ClassCastException ex) {
                System.err.println("f is " + f + " -- of class ");
            }
        }
    }

    public static void main(String[] args) {
        Grocery g = new Grocery(100);
        g.storeNewSuppliesFromTruck();
        System.out.println("Generics: ");
        g.showAllItems();
        System.out.println("===================\n\n");
        System.out.println("Raw: ");
        g.showAllItemsRaw();
        System.out.println("===================\n\n");
    }
}

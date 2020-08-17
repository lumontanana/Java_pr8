package lab8.generics.shop;

import lab8.generics.vegetable.Root;
import lab8.generics.vegetable.Vegetable;
import java.util.ArrayList;

/**
 *
 * @author julia
 */
public class UsingGenerics {

    //This method returns the most expensive item from an array list of vegetables
    public static Vegetable getMostExpensiveItem1(ArrayList vs) {
        Vegetable veg = null;
        double max = Double.MIN_VALUE;
        for (Object v : vs) {
            if (((Vegetable) v).getPrice() > max) {
                veg = (Vegetable) v;
                max = ((Vegetable) v).getPrice();
            }
        }
        //previous code is the same as
        
        /*for (int i=0;i<fs.size();i++) {
            if (((Vegetable) fs.get(i)).getPrice() > max){
                veg = (Vegetable) fs.get(i);
                max = ((Vegetable) fs.get(i)).getPrice();
            }
        }*/
        
        return veg;

    }

    //This method returns the most expensive item from an array list generics of vegetables
    //part 4.4.1
    public static Vegetable getMostExpensiveItem2(ArrayList<Vegetable> vs) {
        Vegetable veg = null;
        //Add your code here
        //CONDITION:  You shouldn't do unnecessary casting
        return veg;
    }
    
    //part 4.4.3.a)
     public static ArrayList returnRootsArrayListBasic(ArrayList basic) {
        ArrayList roots = new ArrayList();
        //Add your code here
        //return those elements in basic that are Root
        return roots;
    }
    
     //part 4.4.3.b)
    public static ArrayList<Root> returnRootsArrayListGeneric(ArrayList<Vegetable> generic) {
        ArrayList<Root> roots = new ArrayList<Root>();
        //Add your code here
        //return those elements in basic as a generics list containing elements that belong to Root 
        return roots;
    }

    //part 4.4.3.c)
    //Add your code here
    public static Root[] returnRootsInCurrentCharListArray(Vegetable[] vs) {
         Root[] rs = null;
        //You may find useful the method System.arrayCopy()
        //public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        //More info at https://docs.oracle.com/javase/7/docs/api/java/lang/System.html
        return rs;
    }
    
    //Part 4.4.6
     //you will have to reprogram a new method doing something similar to
    //getMostExpensiveItem2 but with a different argument 
    // public static Vegetable getMostExpensiveItem3(correct argument) 
    // and change arguments at it
    //So that it can receive an array of a descendant class of Vegetable
    //What if this has to be a direct child of Vegetable?
  
    //This method returns the most expensive item from an array list generics of fvegetables
    //Add your code here, notice the argumengs of the method have to be included
    //Now it is commented to avoid compilation errors here
    //add your code here 
    /*public static Vegetable getMostExpensiveItem3(argument??) {
    
    }*/
}

package lab8.generics.vegetable;


/**
 *
 * @author Maria.Alonso
 */
public class Raf extends Tomato {
    
    public Raf(){
        super();
        this.ImageFile="raf.jpg";
        this.weight=1.5;
        this.pricePerWeight = 0.6;
    }
    
    public Raf(Ripeness m){
        this();        
        ripeness=m;
    }
    
    @Override
    public double getPrice(){   
        computePrice();
        return price;
    }
    
}

    

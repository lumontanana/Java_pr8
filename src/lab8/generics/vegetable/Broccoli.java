package lab8.generics.vegetable;

/**
 *
 * @author Julia.Flores
 */
public class Broccoli extends Flower{
    
    public Broccoli(){
        super();
        this.ImageFile="broccoli.jpg";
        pricePerItem=3.5;
    }
    
    public Broccoli(Size s){
        this();
        size=s;
    }
    
    @Override
    public double getPrice(){
        computePrice();
        return price;
    }
    
}

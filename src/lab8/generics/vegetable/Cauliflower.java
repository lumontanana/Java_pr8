package lab8.generics.vegetable;

/**
 *
 * @author Julia.Flores
 */
public class Cauliflower extends Flower{
    
            
    public Cauliflower(){
        super();
        this.ImageFile="cauliflower.jpg";
        pricePerItem=2.5; 
    }
    
    public Cauliflower(Size s){
        this();
        size=s;
    }
    
    
    @Override
    public double getPrice(){
        computePrice();
        return price;
    }
    
}

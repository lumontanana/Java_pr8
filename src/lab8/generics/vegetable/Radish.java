package lab8.generics.vegetable;


/**
 *
 * @author Julia.Flores
 */
public class Radish extends Root{
    public enum Type {
        ROUND, LONG
    }    
    
    Type type;
    
    public Radish(){
        super();
        this.ImageFile="radish.jpg";
        pricePerBunch=2.20;
        type=Type.ROUND;
    }            
   
     public Radish(Type type){
        this();
        this.type = type;
    }
     
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
    @Override
     public double getPrice(){
        computePrice();
        return price;
    }
     
}

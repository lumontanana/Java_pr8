package lab8.generics.vegetable;

/**
 *
 * @author Julia.Flores
 */
public abstract class Flower extends Vegetable{


    //coliflor, brócoli, alcachofa
    public enum Size {
        LARGE, MEDIUM, SMALL
    }
    
    double pricePerItem;
    Size size;
    
    public Flower(){
        super();
        size=Size.MEDIUM;
        this.ImageFile="flower.jpeg";
        pricePerItem=3;        
    }
    
    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double precioPorUnidad) {
        this.pricePerItem = precioPorUnidad;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
    
    
    public void computePrice(){
        //If it is big, it will have 15% discount
        price= pricePerItem;
        if (size==Size.LARGE)
            price = price- (price * 0.15);            
                
    }
    
    
    
    
    
}

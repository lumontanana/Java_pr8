package lab8.generics.vegetable;

/**
 *
 * @author Julia.Flores
 */
public abstract class Root extends Vegetable{

    /**
     * @return the pricePerBunch
     */
    public double getPricePerBunch() {
        return pricePerBunch;
    }

    /**
     * @param pricePerBunch the pricePerBunch to set
     */
    public void setPricePerBunch(double pricePerBunch) {
        this.pricePerBunch = pricePerBunch;
    }
    //carrots, radish, turnip
    protected double pricePerBunch;
        
    public Root(){
        super();
        this.ImageFile="root.jpg";      
        
    }
    
    @Override
    public void computePrice(){
        price = getPricePerBunch();
        
    }
    
    @Override
    public double getPrice() {
        this.computePrice();
        return price;
    }
    
}

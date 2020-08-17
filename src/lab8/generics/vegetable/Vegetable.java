package lab8.generics.vegetable;

import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author Julia.Flores
 */
public abstract class Vegetable implements Comparable{

    public enum Status {

        GREEN, MATURE, ROTTEN
    }

    Status status;
    protected double price;
    private String origin;
    protected String ImageFile = "vegetable.jpg";
    private int rating;
    static final AtomicLong BAR_CODER = new AtomicLong(0);
    final long barCodeNum = BAR_CODER.getAndIncrement();
    final String barCode = "J" + lab8.util.Util.getCurrentData() + "-" + barCodeNum;

    public Vegetable() {
        //default rating is 5
        this.setRating(5);
    }

    public Vegetable(int r) {
        this.setRating(r);
    }
    /**
     * @return the barCode (automatically generated for everry object)
     */
    public String getBarCode() {
        return barCode;
    }

    /**
     * @return the origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * @return the price
     */
    public abstract double getPrice();

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * To put the right price in price
     */
    public abstract void computePrice();

    /**
     * @return the ImageFile
     */
    public String getImageFile() {
        return ImageFile;
    }
    
    /*
     * A Vegetable goes previously than other based on the price.
     */
    @Override
    public int compareTo(Object o) {
        if (o instanceof Vegetable) {
            Double d1 = this.getPrice();
            Double d2 = ((Vegetable) o).getPrice();
            return d1.compareTo(d2);
        } else {
            return -1;
        }
    }
    


    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        if (rating < 0) {
            rating = 0;
        }
        if (rating > 10) {
            rating = 10;
        }
        this.rating = rating;        
        
    }
    
    @Override
    public String toString() {
        return barCode + " ==> price=" + String.format(Locale.ENGLISH, "%1$,.4f",this.getPrice()) + "e --> I'm a vegetable [" + this.getClass().getSimpleName() + "]";
    }
    
    @Override
    public boolean equals(Object o) {
        return (o instanceof Vegetable) && this.barCode.equals(((Vegetable) o).barCode);
    }    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.barCode);
        return hash;
    }

}

package lab8.generics.vegetable;

/**
 *
 * @author Julia.Flores
 */
public abstract class Tomato extends Fruit {

    protected double pricePerWeight;
    protected double weight;

    public enum Ripeness {
        GREEN, RIPEN, SOFT
    }

    protected Ripeness ripeness;

    /**
     * @return the pricePerWeight
     */
    public double getPricePerWeight() {
        return pricePerWeight;
    }

    /**
     * @param pricePerWeight the pricePerWeight to set
     */
    public void setPricePerWeight(double pricePerWeight) {
        this.pricePerWeight = pricePerWeight;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Tomato() {
        super();
        this.ImageFile = "tomato.jpg";
        ripeness = Ripeness.RIPEN;
    }

    public Tomato(double w, double ppw, Ripeness r) {
        this();
        this.weight = w;
        this.pricePerWeight = ppw;
        this.ripeness = r;
    }

    @Override
    public void computePrice() {
        //if it is soft, the price will be discounted in 0.15 eur
        price = this.getPricePerWeight() * this.getWeight();
        if (getRipeness() == Ripeness.SOFT) {
            price = price - 0.15;
        }
    }

    /**
     * @return the ripeness
     */
    public Ripeness getRipeness() {
        return ripeness;
    }

    /**
     * @param ripeness the ripeness to set
     */
    public void setRipeness(Ripeness ripeness) {
        this.ripeness = ripeness;
    }

}

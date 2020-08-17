package lab8.generics.vegetable;

/**
 *
 * @author Julia.Flores
 */
public class Pear extends Tomato{

    public Pear() {
        super();
        this.ImageFile = "pear.jpg";
        price = 0.3;
    }

    @Override
    public double getPrice() {
        super.computePrice();
        return price;
    }

}

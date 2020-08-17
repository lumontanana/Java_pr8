package lab8.generics.vegetable;

/**
 *
 * @author Julia.Flores
 */
public class Carrot extends Root{

    public enum Color {
        ORANGE, WHITE, PURPLE
    }
    Color color;

    public Carrot() {
        super();
        this.ImageFile = "carrot.jpg";
        pricePerBunch = 1.10;
        this.color = color.ORANGE;
    }

    public Carrot(Color color) {
        this();
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double tellMePrice() {
        //If they're orange the price is the one indicated by priceperBunch
        //If they're white the price is the one indicated by priceperBunch PLUS 0.20
        //If they're purple the price is the one indicated by priceperBunch PLUS 0.35
        
        computePrice();
        switch (color) {
            case WHITE:
                price = price + 0.20;
            case PURPLE:
                price = price + 0.35;
        }
        return price;
    }
}

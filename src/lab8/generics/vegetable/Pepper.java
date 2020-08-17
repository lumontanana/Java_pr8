package lab8.generics.vegetable;

/**
 *
 * @author Julia.Flores
 */
public class Pepper extends Fruit {

    public enum Color {
        GREEN, RED, YELLOW
    }
    Color color;

    @Override
    public void computePrice() {
        switch (color) {
            case GREEN:
                price = 0.2;
                break;
            case RED:
                price = 0.3;
                break;
            case YELLOW:
                price = 0.4;
                break;
        }
    }

 

    public Pepper(Color color) {
        super();
	this.color = color;
        this.ImageFile = "pepper.jpg";

    }

    public Pepper() {
        this(Color.GREEN);

    }

    public void setColor(Color c) {
        color = c;
    }

    public Color putColor() {
        return color;
    }

    @Override
    public double getPrice() {
        computePrice();
        return price;
    }

}

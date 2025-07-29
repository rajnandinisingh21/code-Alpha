
import java.util.Random;

public class Stock {

    private final String symbol;
    private double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public void updatePrice() {
        Random rand = new Random();
        double change = (rand.nextDouble() * 10) - 5;
        price = Math.max(1, price + change);
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return Math.round(price * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return symbol + ": $" + getPrice();
    }
}

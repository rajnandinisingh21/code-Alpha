
import java.util.*;

public class TradingPlatform {

    public static void main(String[] args) {
        // Initialize scanner
        Scanner sc = new Scanner(System.in);

        // Initialize stocks
        Map<String, Stock> stocks = new HashMap<>();
        stocks.put("AAPL", new Stock("AAPL", 150));
        stocks.put("GOOG", new Stock("GOOG", 2700));
        stocks.put("TSLA", new Stock("TSLA", 700));

        // Load user data
        User user = new User("Alice");
        user.loadFromFile("portfolio.txt");

        while (true) {
            // Update and display stock prices
            System.out.println("\n📈 Market Prices:");
            for (Stock stock : stocks.values()) {
                stock.updatePrice();
                System.out.println(stock);
            }

            // Show menu
            System.out.println("\n1. Buy Stock");
            System.out.println("2. Sell Stock");
            System.out.println("3. Show Portfolio");
            System.out.println("4. Save & Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter stock symbol: ");
                    String buySymbol = sc.next().toUpperCase();
                    System.out.print("Enter quantity: ");
                    int buyQty = sc.nextInt();
                    if (stocks.containsKey(buySymbol)) {
                        user.buy(stocks.get(buySymbol), buyQty);
                    } else {
                        System.out.println("❌ Invalid symbol.");
                    }
                }

                case 2 -> {
                    System.out.print("Enter stock symbol: ");
                    String sellSymbol = sc.next().toUpperCase();
                    System.out.print("Enter quantity: ");
                    int sellQty = sc.nextInt();
                    if (stocks.containsKey(sellSymbol)) {
                        user.sell(stocks.get(sellSymbol), sellQty);
                    } else {
                        System.out.println("❌ Invalid symbol.");
                    }
                }

                case 3 ->
                    user.showPortfolio();

                case 4 -> {
                    user.saveToFile("portfolio.txt");
                    System.out.println("👋 Goodbye!");
                    sc.close();
                    return;
                }

                default ->
                    System.out.println("❌ Invalid choice.");
            }
        }
    }
}

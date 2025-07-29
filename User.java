
import java.io.*;
import java.util.*;

public class User {

    private String name;
    private double balance;
    private Map<String, Integer> portfolio;

    public User(String name) {
        this.name = name;
        this.balance = 10000.0;
        this.portfolio = new HashMap<>();
    }

    public void buy(Stock stock, int quantity) {
        double cost = stock.getPrice() * quantity;
        if (balance >= cost) {
            balance -= cost;
            portfolio.put(stock.getSymbol(), portfolio.getOrDefault(stock.getSymbol(), 0) + quantity);
            System.out.println("✅ Bought " + quantity + " shares of " + stock.getSymbol());
        } else {
            System.out.println("❌ Not enough balance.");
        }
    }

    public void sell(Stock stock, int quantity) {
        int owned = portfolio.getOrDefault(stock.getSymbol(), 0);
        if (owned >= quantity) {
            balance += stock.getPrice() * quantity;
            portfolio.put(stock.getSymbol(), owned - quantity);
            System.out.println("✅ Sold " + quantity + " shares of " + stock.getSymbol());
        } else {
            System.out.println("❌ Not enough shares.");
        }
    }

    public void showPortfolio() {
        System.out.println("\n📊 Portfolio of " + name);
        System.out.println("Balance: $" + Math.round(balance * 100.0) / 100.0);
        if (portfolio.isEmpty()) {
            System.out.println("No stocks owned.");
        } else {
            for (String s : portfolio.keySet()) {
                System.out.println(s + " : " + portfolio.get(s) + " shares");
            }
        }
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(name);
            writer.println(balance);
            for (String key : portfolio.keySet()) {
                writer.println(key + "," + portfolio.get(key));
            }
        } catch (IOException e) {
            System.out.println("❌ Failed to save file.");
        }
    }

    @SuppressWarnings("UnnecessaryTemporaryOnConversionFromString")
    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            name = reader.readLine();
            balance = Double.parseDouble(reader.readLine());
            portfolio = new HashMap<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                portfolio.put(parts[0], Integer.parseInt(parts[1]));
            }
        } catch (IOException e) {
            System.out.println("📂 No previous data found.");
        }
    }
}

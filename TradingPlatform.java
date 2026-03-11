import java.io.*;
import java.util.*;

public class TradingPlatform {

    static List<Stock> marketStocks = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        marketStocks.add(new Stock("AAPL", "Apple", 180));
        marketStocks.add(new Stock("GOOG", "Google", 140));
        marketStocks.add(new Stock("TSLA", "Tesla", 220));

        User user = new User("Trader", 10000);

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {

                System.out.println("\n1 View Market");
                System.out.println("2 Buy Stock");
                System.out.println("3 Sell Stock");
                System.out.println("4 View Portfolio");
                System.out.println("5 Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        for (Stock s : marketStocks)
                            s.displayStock();
                    }
                    case 2 -> {
                        System.out.print("Enter Stock Symbol: ");
                        String symbol = sc.next();
                        System.out.print("Quantity: ");
                        int qty = sc.nextInt();
                        for (Stock s : marketStocks)
                            if (s.getSymbol().equals(symbol))
                                user.buyStock(s, qty);
                    }
                    case 3 -> {
                        System.out.print("Enter Stock Symbol: ");
                        String symbol = sc.next();
                        System.out.print("Quantity: ");
                        int qty = sc.nextInt();
                        for (Stock s : marketStocks)
                            if (s.getSymbol().equals(symbol))
                                user.sellStock(s, qty);
                    }
                    case 4 -> {
                        user.getPortfolio().showPortfolio();
                        System.out.println("Balance: $" + user.getBalance());
                    }
                    case 5 -> {
                        savePortfolio(user);
                        System.exit(0);
                    }
                }
            }
        }
    }

    static void savePortfolio(User user) throws Exception {

        try (FileWriter fw = new FileWriter("portfolio.txt")) {
            for (Map.Entry<String, Integer> entry :
                    user.getPortfolio().getHoldings().entrySet()) {

                fw.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
        }
    }
}
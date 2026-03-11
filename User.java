public class User {

    private final String name;
    private double balance;
    private final Portfolio portfolio;

    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
        portfolio = new Portfolio();
    }

    public String getName() {
        return name;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public double getBalance() {
        return balance;
    }

    public void buyStock(Stock stock, int qty) {

        double cost = stock.getPrice() * qty;

        if (cost <= balance) {

            balance -= cost;
            portfolio.buyStock(stock.getSymbol(), qty);

            System.out.println("Stock Purchased Successfully");
        } 
        else {
            System.out.println("Insufficient Balance");
        }
    }

    public void sellStock(Stock stock, int qty) {

        portfolio.sellStock(stock.getSymbol(), qty);

        double value = stock.getPrice() * qty;
        balance += value;

        System.out.println("Stock Sold Successfully");
    }
}
import java.time.LocalDateTime;

public class Transaction {

    private final String symbol;
    private final int quantity;
    private final double price;
    private final String type;
    private  final LocalDateTime time;

    public Transaction(String symbol, int quantity, double price, String type) {

        this.symbol = symbol;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
        this.time = LocalDateTime.now();
    }

    public void showTransaction() {

        System.out.println(type + " | " + symbol + " | " + quantity +
                " | $" + price + " | " + time);
    }
}
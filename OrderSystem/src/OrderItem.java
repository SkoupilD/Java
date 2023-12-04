import java.math.BigDecimal;

public class OrderItem {
    private String title;
    private BigDecimal price;
    private int quantity;

    public OrderItem(String title, BigDecimal price, int quantity) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderItem(String title, int price, int quantity) {
        this(title, BigDecimal.valueOf(price), quantity);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

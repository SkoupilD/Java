import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private static int nextId = 0;

    private int id = nextId++;
    private int tableNo;
    private LocalDate date;
    private PaymentType paymentType;
    private ArrayList<OrderItem> items = new ArrayList<>();

    public Order(int tableNo, LocalDate date, PaymentType paymentType) throws OrdersException {
        this.setTableNo(tableNo);
        this.date = date;
        this.paymentType = paymentType;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Order.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) throws OrdersException {
        final int numberOfTables = Settings.numberOfTables();
        if (tableNo > numberOfTables) throw new OrdersException("Zadané číslo stolu: "+tableNo+" je vyšší než počet stolů v restauraci: "+numberOfTables);
        this.tableNo = tableNo;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public ArrayList<OrderItem> getItems() {
        return (ArrayList<OrderItem>) items.clone();
    }

    public void addItem(OrderItem item) {
        this.items.add(item);
    }

    public BigDecimal totalPrice() {
        BigDecimal result = BigDecimal.valueOf(0);
        for (OrderItem item : items) {
            result = result.add(
                    item.getPrice().multiply(
                            BigDecimal.valueOf(item.getQuantity())
                    ));
        }
        return result;
    }

}

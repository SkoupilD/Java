import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Orders {
    ArrayList<Order> orders = new ArrayList<>();

    public void add(Order order) {
        orders.add(order);
    }

    public int getNumberOfOrders() {
        return orders.size();
    }

    public Map<String, Integer> itemsNumOfPieces() {
        HashMap<String, Integer> result = new HashMap<>();
        for (Order order : orders) {
            for (OrderItem item : order.getItems()) {
                String key = item.getTitle();
                int currentValue = 0;
                if (result.containsKey(key)) {
                    currentValue = result.get(key);
                }
                result.put(key, currentValue+item.getQuantity());
            }
        }
        return result;
    }

    public HashMap<LocalDate, BigDecimal> turnoverTotalPerDay() {
        HashMap<LocalDate, BigDecimal> result = new HashMap<>();
        for (Order order : orders) {
            LocalDate orderDate = order.getDate();
            BigDecimal previousSum = BigDecimal.ZERO;
            if (result.containsKey(orderDate)) {
                previousSum = result.get(orderDate);
            }
            result.put(orderDate, previousSum.add(order.totalPrice()));
        }
        return result;
    }


    public SortedSet<String> itemsSoldAlphabetically() {
        TreeSet<String> items = new TreeSet<>();
        for (Order order : orders) {
            for (OrderItem item : order.getItems()) {
                String title = item.getTitle();
                items.add(title);
            }
        }
        return items;
    }

    public int[] ordersPerTable() {
        int[] result = new int[Settings.numberOfTables()];
        orders.forEach( o -> result[o.getTableNo()]++);
        return result;
    }

}

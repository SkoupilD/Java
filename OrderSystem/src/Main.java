import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;

public class Main {

    private static Orders orders = new Orders();

    public static void prepareData() {
        try {
            Order order;
            order = new Order(1, LocalDate.of(2021, 05, 20), PaymentType.CASH);
            order.addItem(new OrderItem("Caesar salát", 150, 2));
            order.addItem(new OrderItem("Big Burger", 350, 1));
            order.addItem(new OrderItem("Mattoni", 30, 3));
            orders.add(order);
            order = new Order(5, LocalDate.of(2021, 05, 18), PaymentType.CARD);
            order.addItem(new OrderItem("Big Burger", 350, 2));
            order.addItem(new OrderItem("Kofola velká", 30, 2));
            orders.add(order);
            order = new Order(1, LocalDate.of(2021, 05, 20), PaymentType.CARD);
            order.addItem(new OrderItem("Svíčková na smetaně", 220, 1));
            order.addItem(new OrderItem("Big Burger", 350, 1));
            order.addItem(new OrderItem("Smažený hermelín", 135, 1));
            order.addItem(new OrderItem("Palačinky s jahodami", 160, 1));
            order.addItem(new OrderItem("Mattoni", 30, 2));
            order.addItem(new OrderItem("Malinovka domácí", 45, 2));
            orders.add(order);
            order = new Order(2, LocalDate.of(2021, 05, 18), PaymentType.CARD);
            order.addItem(new OrderItem("Smažený hermelín", 135, 3));
            order.addItem(new OrderItem("Malinovka domácí", 45, 3));
            orders.add(order);
        } catch (OrdersException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        prepareData();

        System.out.println(orders.itemsNumOfPieces());

        System.out.println(orders.turnoverTotalPerDay());

        SortedSet<String> items = orders.itemsSoldAlphabetically();
        System.out.println(items);

        int[] ordersPerTable = orders.ordersPerTable();
        System.out.println("Number of orders each table:");
        for (int i = 0; i < ordersPerTable.length; i++) {
            int numberOfOrdersOnThisTable = ordersPerTable[i];
            if (numberOfOrdersOnThisTable > 0) {
                System.out.println("Table n. "  + i + ": \t" + numberOfOrdersOnThisTable);
            }
        }
    }
}

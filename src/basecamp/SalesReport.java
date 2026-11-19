package basecamp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * End-of-day summary: number of orders, revenue, and best-selling items.
 */
public class SalesReport {

    public static void print(List<Order> orders) {
        System.out.println("\n=========== END OF DAY REPORT ===========");
        if (orders.isEmpty()) {
            System.out.println("No orders today.");
            System.out.println("=========================================");
            return;
        }

        double revenue = 0;
        Map<String, Integer> unitsSold = new HashMap<>();

        for (Order order : orders) {
            revenue += order.getGrandTotal();
            for (OrderLine line : order.getLines()) {
                String name = line.getItem().getName();
                unitsSold.put(name, unitsSold.getOrDefault(name, 0) + line.getQuantity());
            }
        }

        System.out.printf("Orders completed:     %d%n", orders.size());
        System.out.printf("Total revenue:        Rs %.2f%n", revenue);
        System.out.printf("Average order value:  Rs %.2f%n", revenue / orders.size());

        System.out.println("\nTop sellers:");
        unitsSold.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(3)
                .forEach(e -> System.out.printf("  %-28s %d sold%n", e.getKey(), e.getValue()));
        System.out.println("=========================================");
    }
}

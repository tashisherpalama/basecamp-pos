package basecamp;

import java.util.ArrayList;
import java.util.List;

/**
 * A table's order. Calculates the bill with service charge and VAT.
 */
public class Order {
    public static final double SERVICE_CHARGE_RATE = 0.10; // 10%
    public static final double VAT_RATE = 0.13;            // 13% (Nepal)

    private final int orderNumber;
    private final int tableNumber;
    private final List<OrderLine> lines = new ArrayList<>();

    public Order(int orderNumber, int tableNumber) {
        this.orderNumber = orderNumber;
        this.tableNumber = tableNumber;
    }

    /** Adds an item. If it's already on the order, increases the quantity instead. */
    public void addItem(MenuItem item, int quantity) {
        for (OrderLine line : lines) {
            if (line.getItem().getId() == item.getId()) {
                line.addQuantity(quantity);
                return;
            }
        }
        lines.add(new OrderLine(item, quantity));
    }

    public boolean isEmpty() { return lines.isEmpty(); }
    public List<OrderLine> getLines() { return lines; }

    public double getSubtotal() {
        double total = 0;
        for (OrderLine line : lines) {
            total += line.getLineTotal();
        }
        return total;
    }

    public double getServiceCharge() {
        return getSubtotal() * SERVICE_CHARGE_RATE;
    }

    /** VAT is charged on the subtotal plus service charge. */
    public double getVat() {
        return (getSubtotal() + getServiceCharge()) * VAT_RATE;
    }

    public double getGrandTotal() {
        return getSubtotal() + getServiceCharge() + getVat();
    }

    public void printBill() {
        System.out.println("\n----------------------------------------------");
        System.out.println("              BASE CAMP 1975");
        System.out.println("        Thali, Kageshwori Manohara");
        System.out.printf("  Order #%d                      Table %d%n", orderNumber, tableNumber);
        System.out.println("----------------------------------------------");
        for (OrderLine line : lines) {
            System.out.printf("  %-26s x%-3d Rs %8.2f%n",
                    line.getItem().getName(), line.getQuantity(), line.getLineTotal());
        }
        System.out.println("----------------------------------------------");
        System.out.printf("  %-31s Rs %8.2f%n", "Subtotal", getSubtotal());
        System.out.printf("  %-31s Rs %8.2f%n", "Service charge (10%)", getServiceCharge());
        System.out.printf("  %-31s Rs %8.2f%n", "VAT (13%)", getVat());
        System.out.printf("  %-31s Rs %8.2f%n", "TOTAL", getGrandTotal());
        System.out.println("----------------------------------------------");
        System.out.println("        Thank you! Please visit again.");
        System.out.println("----------------------------------------------");
    }
}

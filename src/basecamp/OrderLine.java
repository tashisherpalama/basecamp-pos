package basecamp;

/**
 * One line on a bill: a menu item and how many were ordered.
 */
public class OrderLine {
    private final MenuItem item;
    private int quantity;

    public OrderLine(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public MenuItem getItem() { return item; }
    public int getQuantity() { return quantity; }

    public void addQuantity(int extra) {
        quantity += extra;
    }

    public double getLineTotal() {
        return item.getPrice() * quantity;
    }
}

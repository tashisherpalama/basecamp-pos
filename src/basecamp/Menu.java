package basecamp;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds every item the restaurant sells and prints it grouped by category.
 */
public class Menu {
    private final List<MenuItem> items = new ArrayList<>();

    public Menu() {
        // TODO: replace these with Base Camp 1975's real menu and prices
        add("Chicken Momo (10 pcs)", "Momos", 350);
        add("Buff Momo (10 pcs)", "Momos", 320);
        add("Veg Momo (10 pcs)", "Momos", 280);
        add("Jhol Momo", "Momos", 380);
        add("Chicken Thukpa", "Mains", 400);
        add("Dal Bhat Set", "Mains", 450);
        add("Chicken Chowmein", "Mains", 330);
        add("Sekuwa Platter", "Mains", 550);
        add("Masala Tea", "Drinks", 80);
        add("Lemon Soda", "Drinks", 120);
        add("Lassi", "Drinks", 180);
    }

    private void add(String name, String category, double price) {
        items.add(new MenuItem(items.size() + 1, name, category, price));
    }

    /** Returns the item with this id, or null if it doesn't exist. */
    public MenuItem findById(int id) {
        for (MenuItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void print() {
        System.out.println("\n========== BASE CAMP 1975 MENU ==========");
        String currentCategory = "";
        for (MenuItem item : items) {
            if (!item.getCategory().equals(currentCategory)) {
                currentCategory = item.getCategory();
                System.out.println("\n-- " + currentCategory + " --");
            }
            System.out.println(item);
        }
        System.out.println("=========================================");
    }
}

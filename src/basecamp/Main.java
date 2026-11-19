package basecamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Base Camp 1975 point-of-sale system.
 * Run this file to start taking orders.
 */
public class Main {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Menu menu = new Menu();
        List<Order> completedOrders = new ArrayList<>();
        int nextOrderNumber = 1;

        System.out.println("Welcome to the Base Camp 1975 ordering system!");

        while (true) {
            System.out.println("\n1. New order");
            System.out.println("2. View menu");
            System.out.println("3. End of day report");
            System.out.println("4. Exit");
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1:
                    Order order = takeOrder(menu, nextOrderNumber);
                    if (order != null) {
                        order.printBill();
                        completedOrders.add(order);
                        nextOrderNumber++;
                    }
                    break;
                case 2:
                    menu.print();
                    break;
                case 3:
                    SalesReport.print(completedOrders);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Please choose 1-4.");
            }
        }
    }

    private static Order takeOrder(Menu menu, int orderNumber) {
        int table = readInt("Table number: ");
        Order order = new Order(orderNumber, table);
        menu.print();

        while (true) {
            int id = readInt("\nItem number (0 to finish): ");
            if (id == 0) {
                break;
            }
            MenuItem item = menu.findById(id);
            if (item == null) {
                System.out.println("That item doesn't exist. Try again.");
                continue;
            }
            int qty = readInt("Quantity: ");
            if (qty <= 0) {
                System.out.println("Quantity must be at least 1.");
                continue;
            }
            order.addItem(item, qty);
            System.out.printf("Added %d x %s%n", qty, item.getName());
        }

        if (order.isEmpty()) {
            System.out.println("Order cancelled (no items).");
            return null;
        }
        return order;
    }

    /** Keeps asking until the user types a whole number. */
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }
}

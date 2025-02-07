package M165_controllers;

import M165_models.OrderItem;
import M165_services.Customer;
import M165_services.Smartphone;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Order {
    private final M165_services.Order order;
    private final Customer customer;
    private final Smartphone smartphone;

    public Order() {
        this.order = new M165_services.Order();
        this.customer = new Customer();
        this.smartphone = new Smartphone();
    }

    public void manageOrders() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Bestellverwaltung ---");
            System.out.println("1. Bestellung hinzufügen");
            System.out.println("2. Alle Bestellungen anzeigen");
            System.out.println("3. Bestellung löschen");
            System.out.println("0. Zurück");
            System.out.print("Wähle eine Option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Zeilenumbruch einlesen

            switch (choice) {
                case 1 -> addOrder();
                case 2 -> showAllOrders();
                case 3 -> deleteOrder();
                case 0 -> System.out.println("Zurück zum Hauptmenü.");
                default -> System.out.println("Ungültige Eingabe. Bitte versuche es erneut.");
            }
        } while (choice != 0);
    }

    private void addOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kunden-ID eingeben: ");
        String customerId = scanner.nextLine();
        M165_models.Customer customer = this.customer.getCustomerById(customerId);

        if (customer == null) {
            System.out.println("Kunde nicht gefunden!");
            return;
        }

        List<OrderItem> items = new ArrayList<>();
        double total = 0.0;
        String continueAdding = "ja"; // Initialisiere mit "ja"

        do {
            System.out.print("Smartphone-ID eingeben: ");
            String smartphoneId = scanner.nextLine();
            M165_models.Smartphone smartphone = this.smartphone.getSmartphoneById(smartphoneId);

            if (smartphone == null) {
                System.out.println("Smartphone nicht gefunden!");
                continue;
            }

            System.out.print("Menge: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Zeilenumbruch einlesen

            double itemTotal = smartphone.getPrice() * quantity;
            total += itemTotal;

            items.add(new OrderItem(smartphone, smartphone.getPrice(), quantity));

            System.out.print("Weiteres Smartphone hinzufügen? (ja/nein): ");
            continueAdding = scanner.nextLine();
        } while (continueAdding.equalsIgnoreCase("ja"));

        System.out.print("Bestellnummer eingeben: ");
        String orderNumber = scanner.nextLine();

        M165_models.Order order = new M165_models.Order(orderNumber, new Date(), customer, items, total);
        this.order.addOrder(order);
    }

    private void showAllOrders() {
        List<M165_models.Order> orders = order.getAllOrders();
        if (orders.isEmpty()) {
            System.out.println("Keine Bestellungen in der Datenbank gefunden.");
        } else {
            System.out.println("\n--- Liste der Bestellungen ---");
            for (M165_models.Order order : orders) {
                System.out.println(order);
            }
        }
    }

    private void deleteOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Gib die ID der Bestellung ein, die gelöscht werden soll: ");
        String id = scanner.nextLine();
        order.deleteOrder(id);
    }
}

package M165_controllers;

import java.util.List;
import java.util.Scanner;

public class Customer {
    private final M165_services.Customer customer;

    public Customer() {
        this.customer = new M165_services.Customer();
    }

    public void manageCustomers() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Kundenverwaltung ---");
            System.out.println("1. Kunde hinzufügen");
            System.out.println("2. Alle Kunden anzeigen");
            System.out.println("3. Kunde löschen");
            System.out.println("0. Zurück");
            System.out.print("Wähle eine Option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addCustomer();
                case 2 -> showAllCustomers();
                case 3 -> deleteCustomer();
                case 0 -> System.out.println("Zurück zum Hauptmenü.");
                default -> System.out.println("Ungültige Eingabe. Bitte versuche es erneut.");
            }
        } while (choice != 0);
    }

    private void addCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Anrede: ");
        String title = scanner.nextLine();

        System.out.print("Vorname: ");
        String firstName = scanner.nextLine();

        System.out.print("Nachname: ");
        String lastName = scanner.nextLine();

        System.out.print("Adresse: ");
        String address = scanner.nextLine();

        System.out.print("Postleitzahl: ");
        String postalCode = scanner.nextLine();

        System.out.print("Ort: ");
        String city = scanner.nextLine();

        System.out.print("Telefon (privat): ");
        String phonePrivate = scanner.nextLine();

        System.out.print("Telefon (mobil): ");
        String phoneMobile = scanner.nextLine();

        System.out.print("E-Mail: ");
        String email = scanner.nextLine();

        System.out.print("Geburtsdatum (z. B. 1990-05-15): ");
        String birthDate = scanner.nextLine();

        System.out.print("Benutzername: ");
        String username = scanner.nextLine();

        System.out.print("Passwort: ");
        String password = scanner.nextLine();

        M165_models.Customer customer = new M165_models.Customer(title, firstName, lastName, address, postalCode, city,
                phonePrivate, phoneMobile, email, birthDate, username, password);

        this.customer.addCustomer(customer);
    }

    private void showAllCustomers() {
        List<M165_models.Customer> customers = customer.getAllCustomers();
        if (customers.isEmpty()) {
            System.out.println("Keine Kunden verfügbar.");
        } else {
            customers.forEach(System.out::println);
        }
    }

    private void deleteCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Gib die ID des Kunden ein, der gelöscht werden soll: ");
        String id = scanner.nextLine();
        customer.deleteCustomer(id);
    }
}

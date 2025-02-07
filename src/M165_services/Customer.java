package M165_services;

import java.util.List;

public class Customer {
    private final M165_repo.Customer customer;

    public Customer() {
        this.customer = new M165_repo.Customer();
    }

    // Kunde hinzufügen
    public void addCustomer(M165_models.Customer customer) {
        this.customer.insertCustomer(customer);
        System.out.println("Kunde erfolgreich hinzugefügt: " + customer.getFirstName() + " " + customer.getLastName());
    }

    // Alle Kunden abrufen
    public List<M165_models.Customer> getAllCustomers() {
        List<M165_models.Customer> customers = customer.findAllCustomers();
        if (customers.isEmpty()) {
            System.out.println("Keine Kunden in der Datenbank gefunden.");
        }
        return customers;
    }

    // Kunde anhand der ID finden
    public M165_models.Customer getCustomerById(String id) {
        M165_models.Customer customer = this.customer.findCustomerById(id);
        if (customer == null) {
            System.out.println("Kein Kunde mit der ID gefunden: " + id);
        }
        return customer;
    }

    // Kunde aktualisieren
    public void updateCustomer(M165_models.Customer customer) {
        boolean updated = this.customer.updateCustomer(customer);
        if (updated) {
            System.out.println("Kunde erfolgreich aktualisiert: " + customer.getFirstName() + " " + customer.getLastName());
        } else {
            System.out.println("Kunde konnte nicht aktualisiert werden.");
        }
    }

    // Kunde löschen
    public void deleteCustomer(String id) {
        boolean deleted = customer.deleteCustomer(id);
        if (deleted) {
            System.out.println("Kunde erfolgreich gelöscht.");
        } else {
            System.out.println("Kunde konnte nicht gelöscht werden.");
        }
    }
}

package M165_services;

import java.util.List;

public class Order {
    private final M165_repo.Order order;

    public Order() {
        this.order = new M165_repo.Order();
    }

    // Bestellung hinzufügen
    public void addOrder(M165_models.Order order) {
        this.order.insertOrder(order);
        System.out.println("Bestellung erfolgreich hinzugefügt: " + order.getOrderNumber());
    }

    // Alle Bestellungen abrufen
    public List<M165_models.Order> getAllOrders() {
        List<M165_models.Order> orders = order.findAllOrders();
        if (orders.isEmpty()) {
            System.out.println("Keine Bestellungen in der Datenbank gefunden.");
        }
        return orders;
    }

    // Bestellung anhand der ID finden
    public M165_models.Order getOrderById(String id) {
        M165_models.Order order = this.order.findOrderById(id);
        if (order == null) {
            System.out.println("Keine Bestellung mit der ID gefunden: " + id);
        }
        return order;
    }

    // Bestellung aktualisieren
    public void updateOrder(M165_models.Order order) {
        boolean updated = this.order.updateOrder(order);
        if (updated) {
            System.out.println("Bestellung erfolgreich aktualisiert: " + order.getOrderNumber());
        } else {
            System.out.println("Bestellung konnte nicht aktualisiert werden.");
        }
    }

    // Bestellung löschen
    public void deleteOrder(String id) {
        boolean deleted = order.deleteOrder(id);
        if (deleted) {
            System.out.println("Bestellung erfolgreich gelöscht.");
        } else {
            System.out.println("Bestellung konnte nicht gelöscht werden.");
        }
    }
}

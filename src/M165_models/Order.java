package M165_models;

import java.util.Date;
import java.util.List;

public class Order {
    private String id; // MongoDB ObjectId
    private String orderNumber; // Bestellnummer
    private Date orderDate; // Datum der Bestellung
    private Customer customer; // Referenz auf den Kunden
    private List<OrderItem> items; // Liste der Bestellpositionen
    private double total; // Gesamtkosten der Bestellung

    // Konstruktor
    public Order(String orderNumber, Date orderDate, Customer customer, List<OrderItem> items, double total) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.customer = customer;
        this.items = items;
        this.total = total;
    }

    // Getter und Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", orderDate=" + orderDate +
                ", customer=" + customer +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}

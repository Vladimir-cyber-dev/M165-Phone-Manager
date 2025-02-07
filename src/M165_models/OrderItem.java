package M165_models;

public class OrderItem {
    private Smartphone smartphone; // Referenz auf das Smartphone
    private double price; // Preis pro Stück
    private int quantity; // Anzahl der bestellten Einheiten

    // Konstruktor
    public OrderItem(Smartphone smartphone, double price, int quantity) {
        this.smartphone = smartphone;
        this.price = price;
        this.quantity = quantity;
    }

    // Getter und Setter
    public Smartphone getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(Smartphone smartphone) {
        this.smartphone = smartphone;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "smartphone=" + smartphone +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

package M165_repo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import M165_models.OrderItem;
import M165_models.Customer;
import M165_models.Smartphone;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final MongoCollection<Document> orderCollection;

    public Order() {
        MongoDatabase database = MongoSettings.getDatabase();
        this.orderCollection = database.getCollection("orders");
    }

    // Bestellung hinzufügen
    public void insertOrder(M165_models.Order order) {
        List<Document> items = new ArrayList<>();
        for (OrderItem item : order.getItems()) {
            items.add(new Document("smartphoneId", new ObjectId(item.getSmartphone().getId()))
                    .append("model", item.getSmartphone().getModel())
                    .append("price", item.getPrice())
                    .append("quantity", item.getQuantity()));
        }

        Document document = new Document("orderNumber", order.getOrderNumber())
                .append("orderDate", order.getOrderDate())
                .append("customerId", new ObjectId(order.getCustomer().getId()))
                .append("customerName", order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName())
                .append("items", items)
                .append("total", order.getTotal());

        orderCollection.insertOne(document);
    }

    // Alle Bestellungen abrufen
    public List<M165_models.Order> findAllOrders() {
        List<M165_models.Order> orders = new ArrayList<>();
        for (Document doc : orderCollection.find()) {
            orders.add(documentToOrder(doc));
        }
        return orders;
    }

    // Bestellung anhand der ID finden
    public M165_models.Order findOrderById(String id) {
        Document doc = orderCollection.find(Filters.eq("_id", new ObjectId(id))).first();
        return doc != null ? documentToOrder(doc) : null;
    }

    // Bestellung aktualisieren
    public boolean updateOrder(M165_models.Order order) {
        List<Document> items = new ArrayList<>();
        for (OrderItem item : order.getItems()) {
            items.add(new Document("smartphoneId", new ObjectId(item.getSmartphone().getId()))
                    .append("model", item.getSmartphone().getModel())
                    .append("price", item.getPrice())
                    .append("quantity", item.getQuantity()));
        }

        Document update = new Document("$set", new Document("orderNumber", order.getOrderNumber())
                .append("orderDate", order.getOrderDate())
                .append("customerId", new ObjectId(order.getCustomer().getId()))
                .append("customerName", order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName())
                .append("items", items)
                .append("total", order.getTotal()));

        return orderCollection.updateOne(Filters.eq("_id", new ObjectId(order.getId())), update).getMatchedCount() > 0;
    }

    // Bestellung löschen
    public boolean deleteOrder(String id) {
        return orderCollection.deleteOne(Filters.eq("_id", new ObjectId(id))).getDeletedCount() > 0;
    }

    // Hilfsmethode: Konvertiert ein MongoDB-Dokument in ein Order-Objekt
    private M165_models.Order documentToOrder(Document doc) {
        Customer customer = new Customer(
                "", // Placeholder für vollständige Kunden-Daten
                "", "", "", "", "", "", "", "", "", "", ""
        );
        customer.setId(doc.getObjectId("customerId").toHexString());

        List<OrderItem> items = new ArrayList<>();
        List<Document> itemsDocs = (List<Document>) doc.get("items");
        for (Document itemDoc : itemsDocs) {
            Smartphone smartphone = new Smartphone(
                    "", "", 0, 0, "", 0, "", "", "", 0, 0, new ArrayList<>(), ""
            );
            smartphone.setId(itemDoc.getObjectId("smartphoneId").toHexString());

            OrderItem item = new OrderItem(
                    smartphone,
                    itemDoc.getDouble("price"),
                    itemDoc.getInteger("quantity")
            );
            items.add(item);
        }

        return new M165_models.Order(
                doc.getString("orderNumber"),
                doc.getDate("orderDate"),
                customer,
                items,
                doc.getDouble("total")
        );
    }
}

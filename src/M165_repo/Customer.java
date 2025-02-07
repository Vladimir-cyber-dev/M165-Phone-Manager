package M165_repo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final MongoCollection<Document> customerCollection;

    public Customer() {
        MongoDatabase database = MongoSettings.getDatabase();
        this.customerCollection = database.getCollection("customers");
    }

    // Kunde hinzufügen
    public void insertCustomer(M165_models.Customer customer) {
        Document document = new Document("title", customer.getTitle())
                .append("firstName", customer.getFirstName())
                .append("lastName", customer.getLastName())
                .append("address", customer.getAddress())
                .append("postalCode", customer.getPostalCode())
                .append("city", customer.getCity())
                .append("phonePrivate", customer.getPhonePrivate())
                .append("phoneMobile", customer.getPhoneMobile())
                .append("email", customer.getEmail())
                .append("birthDate", customer.getBirthDate())
                .append("username", customer.getUsername())
                .append("password", customer.getPassword());
        customerCollection.insertOne(document);
    }

    // Alle Kunden abrufen
    public List<M165_models.Customer> findAllCustomers() {
        List<M165_models.Customer> customers = new ArrayList<>();
        for (Document doc : customerCollection.find()) {
            customers.add(documentToCustomer(doc));
        }
        return customers;
    }

    // Kunde anhand der ID finden
    public M165_models.Customer findCustomerById(String id) {
        Document doc = customerCollection.find(Filters.eq("_id", new ObjectId(id))).first();
        return doc != null ? documentToCustomer(doc) : null;
    }

    // Kunde aktualisieren
    public boolean updateCustomer(M165_models.Customer customer) {
        Document update = new Document("$set", new Document("title", customer.getTitle())
                .append("firstName", customer.getFirstName())
                .append("lastName", customer.getLastName())
                .append("address", customer.getAddress())
                .append("postalCode", customer.getPostalCode())
                .append("city", customer.getCity())
                .append("phonePrivate", customer.getPhonePrivate())
                .append("phoneMobile", customer.getPhoneMobile())
                .append("email", customer.getEmail())
                .append("birthDate", customer.getBirthDate())
                .append("username", customer.getUsername())
                .append("password", customer.getPassword()));
        return customerCollection.updateOne(Filters.eq("_id", new ObjectId(customer.getId())), update).getMatchedCount() > 0;
    }

    // Kunde löschen
    public boolean deleteCustomer(String id) {
        return customerCollection.deleteOne(Filters.eq("_id", new ObjectId(id))).getDeletedCount() > 0;
    }

    // Hilfsmethode: Konvertiert ein MongoDB-Dokument in ein Customer-Objekt
    private M165_models.Customer documentToCustomer(Document doc) {
        return new M165_models.Customer(
                doc.getString("title"),
                doc.getString("firstName"),
                doc.getString("lastName"),
                doc.getString("address"),
                doc.getString("postalCode"),
                doc.getString("city"),
                doc.getString("phonePrivate"),
                doc.getString("phoneMobile"),
                doc.getString("email"),
                doc.getString("birthDate"),
                doc.getString("username"),
                doc.getString("password")
        );
    }
}

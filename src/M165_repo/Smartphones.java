package M165_repo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import M165_models.Smartphone;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Smartphones {
    private final MongoCollection<Document> smartphoneCollection;

    public Smartphones() {
        MongoDatabase database = MongoSettings.getDatabase();
        this.smartphoneCollection = database.getCollection("smartphones");
    }

    // 🟢 CREATE: Add a new smartphone to MongoDB
    public void insertSmartphone(Smartphone smartphone) {
        Document document = new Document("brand", smartphone.getBrand())
                .append("model", smartphone.getModel())
                .append("price", smartphone.getPrice())
                .append("ram", smartphone.getRam())
                .append("screenSize", smartphone.getScreenSize())
                .append("storage", smartphone.getStorage())
                .append("os", smartphone.getOs())
                .append("osVersion", smartphone.getOsVersion())
                .append("resolution", smartphone.getResolution())
                .append("cores", smartphone.getCores())
                .append("batteryCapacity", smartphone.getBatteryCapacity())
                .append("connectivity", smartphone.getConnectivity())
                .append("networkStandard", smartphone.getNetworkStandard());
        smartphoneCollection.insertOne(document);
    }

    // 🟢 READ: Fetch all smartphones from MongoDB
    public List<Smartphone> findAllSmartphones() {
        List<Smartphone> smartphones = new ArrayList<>();
        for (Document doc : smartphoneCollection.find()) {
            smartphones.add(documentToSmartphone(doc));
        }
        return smartphones;
    }

    // 🟢 READ: Find a smartphone by ID
    public Smartphone findSmartphoneById(String id) {
        try {
            Document doc = smartphoneCollection.find(Filters.eq("_id", new ObjectId(id))).first();
            if (doc != null) {
                return documentToSmartphone(doc);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid ID: " + id);
        }
        return null;
    }

    // 🟢 UPDATE: Update an existing smartphone
    public void updateSmartphone(String id, Smartphone updatedSmartphone) {
        Document updatedDocument = new Document("brand", updatedSmartphone.getBrand())
                .append("model", updatedSmartphone.getModel())
                .append("price", updatedSmartphone.getPrice())
                .append("ram", updatedSmartphone.getRam())
                .append("screenSize", updatedSmartphone.getScreenSize())
                .append("storage", updatedSmartphone.getStorage())
                .append("os", updatedSmartphone.getOs())
                .append("osVersion", updatedSmartphone.getOsVersion())
                .append("resolution", updatedSmartphone.getResolution())
                .append("cores", updatedSmartphone.getCores())
                .append("batteryCapacity", updatedSmartphone.getBatteryCapacity())
                .append("connectivity", updatedSmartphone.getConnectivity())
                .append("networkStandard", updatedSmartphone.getNetworkStandard());

        smartphoneCollection.replaceOne(Filters.eq("_id", new ObjectId(id)), updatedDocument);
    }

    // 🟢 DELETE: Remove a smartphone from MongoDB
    public void deleteSmartphone(String id) {
        try {
            smartphoneCollection.deleteOne(Filters.eq("_id", new ObjectId(id)));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid ID: " + id);
        }
    }

    // Helper method to convert MongoDB Document into Smartphone object
    private Smartphone documentToSmartphone(Document doc) {
        return new Smartphone(
                doc.getObjectId("_id").toHexString(),
                doc.getString("brand"),
                doc.getString("model"),
                doc.getDouble("price"),
                doc.getInteger("ram"),
                doc.getString("screenSize"),
                doc.getInteger("storage"),
                doc.getString("os"),
                doc.getString("osVersion"),
                doc.getString("resolution"),
                doc.getInteger("cores"),
                doc.getInteger("batteryCapacity"),
                (List<String>) doc.get("connectivity"),
                doc.getString("networkStandard")
        );
    }
}

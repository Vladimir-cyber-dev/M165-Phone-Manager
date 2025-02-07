package M165_repo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoSettings {
    private static final String CONNECTION_STRING = "mongodb://localhost:27017"; // Standard-Host und Port
    private static final String DATABASE_NAME = "M165"; // Datenbankname

    private static MongoDatabase database;

    public static MongoDatabase getDatabase() {
        if (database == null) {
            MongoClient mongoClient = MongoClients.create(CONNECTION_STRING);
            database = mongoClient.getDatabase(DATABASE_NAME);
        }
        return database;
    }
}

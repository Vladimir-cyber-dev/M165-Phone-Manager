package M165_main;

import com.mongodb.client.MongoDatabase;
import M165_repo.MongoSettings;

public class Test {
    public static void main(String[] args) {
        try {
            MongoDatabase database = MongoSettings.getDatabase();
            System.out.println("Erfolgreich mit der Datenbank verbunden: " + database.getName());
        } catch (Exception e) {
            System.err.println("Fehler bei der Verbindung: " + e.getMessage());
        }
    }
}

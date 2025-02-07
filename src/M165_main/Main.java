package M165_main;

import M165_controllers.SecondMain;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        // Deaktiviere MongoDB-Treiber-Logs (nur Warnungen und Fehler anzeigen)
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.WARNING);

        // Starte das Hauptmenü
        SecondMain controller = new SecondMain();
        controller.start();

    }
}

package M165_controllers;

import java.util.List;
import java.util.Scanner;

public class Smartphone {
    private final M165_services.Smartphone smartphone;

    public Smartphone() {
        this.smartphone = new M165_services.Smartphone();
    }

    public void manageSmartphones() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {

            System.out.println("1. Hinzufügen");
            System.out.println("2. Alle anzeigen");
            System.out.println("3. Löschen");
            System.out.println("0. Beenden");
            System.out.print("Option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Zeilenumbruch einlesen

            switch (choice) {
                case 1 -> addSmartphone();
                case 2 -> showAllSmartphones();
                case 3 -> deleteSmartphone();
                case 0 -> System.out.println("Programm beendet.");
                default -> System.out.println("Ungültige Eingabe. Bitte versuche es erneut.");
            }
        } while (choice != 0);
    }

    private void addSmartphone() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Marke: ");
        String brand = scanner.nextLine();

        System.out.print("Modell: ");
        String model = scanner.nextLine();

        System.out.print("Preis: ");
        double price = scanner.nextDouble();

        System.out.print("RAM (GB): ");
        int ram = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Bildschirmgröße: ");
        String screenSize = scanner.nextLine();

        System.out.print("Speicherkapazität (GB): ");
        int storage = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Betriebssystem: ");
        String os = scanner.nextLine();

        System.out.print("Betriebssystem-Version: ");
        String osVersion = scanner.nextLine();

        System.out.print("Pixelauflösung: ");
        String resolution = scanner.nextLine();

        System.out.print("Prozessorkerne: ");
        int cores = scanner.nextInt();

        System.out.print("Akkukapazität (mAh): ");
        int batteryCapacity = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Konnektivität (Bluetooth, NFC, USB, WLAN - getrennt durch Komma): ");
        String connectivityInput = scanner.nextLine();
        List<String> connectivity = List.of(connectivityInput.split(", "));

        System.out.print("Mobilfunkstandard: ");
        String networkStandard = scanner.nextLine();

        M165_models.Smartphone smartphone = new M165_models.Smartphone(brand, model, price, ram, screenSize, storage, os, osVersion,
                resolution, cores, batteryCapacity, connectivity, networkStandard);

        this.smartphone.addSmartphone(smartphone);
        System.out.println("Smartphone erfolgreich hinzugefügt.");
    }

    private void showAllSmartphones() {
        List<M165_models.Smartphone> smartphones = smartphone.getAllSmartphones();
        if (smartphones.isEmpty()) {
            System.out.println("Keine Smartphones in der Datenbank gefunden.");
        } else {
            for (M165_models.Smartphone smartphone : smartphones) {
                System.out.println(smartphone);
            }
        }
    }

    private void updateSmartphone() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Gib die ID des zu aktualisierenden Smartphones ein: ");
        String id = scanner.nextLine();

        M165_models.Smartphone smartphone = this.smartphone.getSmartphoneById(id);
        if (smartphone == null) {
            System.out.println("Smartphone nicht gefunden.");
            return;
        }

        System.out.println("Gib die neuen Werte ein (leer lassen, um den aktuellen Wert zu behalten):");

        System.out.print("Marke (aktuell: " + smartphone.getBrand() + "): ");
        String brand = scanner.nextLine();
        if (!brand.isBlank()) smartphone.setBrand(brand);

        System.out.print("Modell (aktuell: " + smartphone.getModel() + "): ");
        String model = scanner.nextLine();
        if (!model.isBlank()) smartphone.setModel(model);

        System.out.print("Preis (aktuell: " + smartphone.getPrice() + "): ");
        String priceInput = scanner.nextLine();
        if (!priceInput.isBlank()) smartphone.setPrice(Double.parseDouble(priceInput));

        System.out.print("RAM (aktuell: " + smartphone.getRam() + " GB): ");
        String ramInput = scanner.nextLine();
        if (!ramInput.isBlank()) smartphone.setRam(Integer.parseInt(ramInput));

        System.out.print("Bildschirmgröße (aktuell: " + smartphone.getScreenSize() + "): ");
        String screenSize = scanner.nextLine();
        if (!screenSize.isBlank()) smartphone.setScreenSize(screenSize);

        System.out.print("Speicherkapazität (aktuell: " + smartphone.getStorage() + " GB): ");
        String storageInput = scanner.nextLine();
        if (!storageInput.isBlank()) smartphone.setStorage(Integer.parseInt(storageInput));

        System.out.print("Betriebssystem (aktuell: " + smartphone.getOs() + "): ");
        String os = scanner.nextLine();
        if (!os.isBlank()) smartphone.setOs(os);

        System.out.print("Betriebssystem-Version (aktuell: " + smartphone.getOsVersion() + "): ");
        String osVersion = scanner.nextLine();
        if (!osVersion.isBlank()) smartphone.setOsVersion(osVersion);

        System.out.print("Pixelauflösung (aktuell: " + smartphone.getResolution() + "): ");
        String resolution = scanner.nextLine();
        if (!resolution.isBlank()) smartphone.setResolution(resolution);

        System.out.print("Prozessorkerne (aktuell: " + smartphone.getCores() + "): ");
        String coresInput = scanner.nextLine();
        if (!coresInput.isBlank()) smartphone.setCores(Integer.parseInt(coresInput));

        System.out.print("Akkukapazität (aktuell: " + smartphone.getBatteryCapacity() + " mAh): ");
        String batteryCapacityInput = scanner.nextLine();
        if (!batteryCapacityInput.isBlank()) smartphone.setBatteryCapacity(Integer.parseInt(batteryCapacityInput));

        System.out.print("Konnektivität (aktuell: " + smartphone.getConnectivity() + "): ");
        String connectivityInput = scanner.nextLine();
        if (!connectivityInput.isBlank()) smartphone.setConnectivity(List.of(connectivityInput.split(", ")));

        System.out.print("Mobilfunkstandard (aktuell: " + smartphone.getNetworkStandard() + "): ");
        String networkStandard = scanner.nextLine();
        if (!networkStandard.isBlank()) smartphone.setNetworkStandard(networkStandard);

        this.smartphone.updateSmartphone(id, smartphone);
        System.out.println("Smartphone erfolgreich aktualisiert.");
    }

    private void deleteSmartphone() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Gib die ID des zu löschenden Smartphones ein: ");
        String id = scanner.nextLine();

        smartphone.deleteSmartphone(id);
        System.out.println("Smartphone erfolgreich gelöscht.");
    }
}

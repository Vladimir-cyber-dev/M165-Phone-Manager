package M165_models;

import java.util.List;

public class Smartphone {
    private String id; // MongoDB ObjectId als String speichern
    private String brand;
    private String model;
    private double price;
    private int ram;
    private String screenSize;
    private int storage;
    private String os;
    private String osVersion;
    private String resolution;
    private int cores;
    private int batteryCapacity;
    private List<String> connectivity;
    private String networkStandard;

    // 🟢 Leerer Konstruktor für MongoDB-Kompatibilität
    public Smartphone() {
    }

    // 🟢 Konstruktor für neue Smartphones
    public Smartphone(String brand, String model, double price, int ram, String screenSize, int storage, String os, String osVersion,
                      String resolution, int cores, int batteryCapacity, List<String> connectivity, String networkStandard) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.ram = ram;
        this.screenSize = screenSize;
        this.storage = storage;
        this.os = os;
        this.osVersion = osVersion;
        this.resolution = resolution;
        this.cores = cores;
        this.batteryCapacity = batteryCapacity;
        this.connectivity = connectivity;
        this.networkStandard = networkStandard;
    }

    // 🟢 Konstruktor mit ID für MongoDB
    public Smartphone(String id, String brand, String model, double price, int ram, String screenSize, int storage, String os, String osVersion,
                      String resolution, int cores, int batteryCapacity, List<String> connectivity, String networkStandard) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.ram = ram;
        this.screenSize = screenSize;
        this.storage = storage;
        this.os = os;
        this.osVersion = osVersion;
        this.resolution = resolution;
        this.cores = cores;
        this.batteryCapacity = batteryCapacity;
        this.connectivity = connectivity;
        this.networkStandard = networkStandard;
    }

    // 🟢 Getter & Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public List<String> getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(List<String> connectivity) {
        this.connectivity = connectivity;
    }

    public String getNetworkStandard() {
        return networkStandard;
    }

    public void setNetworkStandard(String networkStandard) {
        this.networkStandard = networkStandard;
    }

    // 🟢 Methode für die Konsolenausgabe
    @Override
    public String toString() {
        return "Smartphone{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", ram=" + ram + "GB" +
                ", screenSize='" + screenSize + '\'' +
                ", storage=" + storage + "GB" +
                ", os='" + os + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", resolution='" + resolution + '\'' +
                ", cores=" + cores +
                ", batteryCapacity=" + batteryCapacity + "mAh" +
                ", connectivity=" + connectivity +
                ", networkStandard='" + networkStandard + '\'' +
                '}';
    }
}

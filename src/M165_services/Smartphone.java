package M165_services;

import M165_repo.Smartphones;

import java.util.List;

public class Smartphone {
    private final Smartphones smartphones;

    public Smartphone() {
        this.smartphones = new Smartphones();
    }

    // Create
    public void addSmartphone(M165_models.Smartphone smartphone) {
        smartphones.insertSmartphone(smartphone);
    }

    // Read: Alle Smartphones
    public List<M165_models.Smartphone> getAllSmartphones() {
        return smartphones.findAllSmartphones();
    }

    // Read: Smartphone nach ID
    public M165_models.Smartphone getSmartphoneById(String id) {
        return smartphones.findSmartphoneById(id);
    }

    // Update
    public void updateSmartphone(String id, M165_models.Smartphone updatedSmartphone) {
        smartphones.updateSmartphone(id, updatedSmartphone);
    }

    // Delete
    public void deleteSmartphone(String id) {
        smartphones.deleteSmartphone(id);
    }
}

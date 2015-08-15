package com.marcelo.unittesting.testexamples;

import java.util.List;

public class PaymentService {

    private StorageService storageService;

    public PaymentService() {
        storageService = StorageServiceFactory.getStorageService();
    }

    public PaymentService(StorageService storageService) {
        this.storageService = storageService;
    }

    public void registerPayment(Payment payment) {
        storageService.saveObject(payment);
    }

    public List<Payment> getPayments() {
        return storageService.loadObjects();
    }

    public void dispose() {
        storageService = null;
    }
}

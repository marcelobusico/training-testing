package com.example.training.androidtestproject.payments;

import com.example.training.androidtestproject.storage.StorageService;
import com.example.training.androidtestproject.storage.StorageServiceFactory;

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

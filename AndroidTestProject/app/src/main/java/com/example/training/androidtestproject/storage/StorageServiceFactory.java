package com.example.training.androidtestproject.storage;

public class StorageServiceFactory {

    private static StorageService storageService;

    public static StorageService getStorageService() {
        return storageService;
    }

    public static void setStorageService(StorageService storageService) {
        StorageServiceFactory.storageService = storageService;
    }

    public static void useDefaultStorageService() {
        //TODO: To be implemented
    }
}

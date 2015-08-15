package com.marcelo.unittesting.testexamples;

public class StorageServiceFactory {

    private static StorageService storageService;

    public static StorageService getStorageService() {
        return storageService;
    }

    public static void setStorageService(StorageService storageService) {
        StorageServiceFactory.storageService = storageService;
    }

    public static void useDefaultStorageService() {

    }

}

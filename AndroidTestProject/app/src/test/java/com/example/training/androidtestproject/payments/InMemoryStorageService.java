package com.example.training.androidtestproject.payments;

import com.example.training.androidtestproject.storage.StorageService;

import java.util.LinkedList;
import java.util.List;

public class InMemoryStorageService implements StorageService {

    private final List objectsStore = new LinkedList();
            
    @Override
    public void saveObject(Object instance) {
        objectsStore.add(instance);
    }

    @Override
    public List loadObjects() {
        return objectsStore;
    }

}

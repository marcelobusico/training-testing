package com.marcelo.unittesting.testexamples;

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

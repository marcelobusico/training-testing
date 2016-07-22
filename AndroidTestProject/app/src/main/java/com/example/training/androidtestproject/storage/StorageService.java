package com.example.training.androidtestproject.storage;

import java.util.List;

public interface StorageService {

    void saveObject(Object instance);

    List loadObjects();
}

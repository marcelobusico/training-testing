package com.marcelo.unittesting.testexamples;

import java.util.List;

public interface StorageService {

    void saveObject(Object instance);

    List loadObjects();
}

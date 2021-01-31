package com.app.demo.csvuploader.fakedatastore;

import com.app.demo.csvuploader.ModelPojo.EcommerceModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeDataStoreService {
    private List<EcommerceModel> storedModels;

    public List<EcommerceModel> getStoredModels() {
        return storedModels;
    }

    public void setStoredModels(List<EcommerceModel> storedModels) {
        this.storedModels = storedModels;
    }
}

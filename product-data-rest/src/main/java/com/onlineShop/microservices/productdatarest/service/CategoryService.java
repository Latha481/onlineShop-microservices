package com.onlineShop.microservices.productdatarest.service;

import com.onlineShop.microservices.productdatarest.model.Product;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class CategoryService {

    public Product checkAndUpdatePatch(Product patchProduct, Product existingProduct) throws IllegalAccessException {

        for(Field field : Product.class.getDeclaredFields()){
            field.setAccessible(true);
            Object value=field.get(patchProduct);
            if(value!=null){
                field.set(existingProduct,value);
            }
            field.setAccessible(false);
        }
        return existingProduct;
    }

    public Boolean checkIfProductToBeAdded(Double value , Double productValue){
        return (value == null) || productValue.compareTo(value) >= 0;
    }

    public Boolean checkIfProductToBeAdded(Integer value , Integer productValue){
        return (value == null) || value < productValue || value.equals(productValue);
    }

}

package com.eleiatech.stockmanagement.productcacheservice.service;

import com.eleiatech.stockmanagement.productcacheservice.enums.Language;
import com.eleiatech.stockmanagement.productcacheservice.repository.entity.Product;

public interface ProductRepositoryService {
    Product getProduct(Language language, Long productId);
    void deleteProducts(Language language);
}

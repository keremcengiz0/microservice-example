package com.eleiatech.stockmanagement.productservice.converter;

import com.eleiatech.stockmanagement.productservice.repository.entity.Product;
import com.eleiatech.stockmanagement.productservice.response.ProductResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConverter {
    public ProductResponse productToProductResponse(Product product) {
        return ProductResponse.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .productCreatedDate(product.getProductCreatedDate().getTime())
                .productUpdatedDate(product.getProductUpdatedDate().getTime())
                .build();
    }


    public List<ProductResponse> productListToProductResponseList(List<Product> products) {
        return products.stream()
                .map(this::productToProductResponse)
                .collect(Collectors.toList());
    }

/*
    public List<ProductResponse> productListToProductResponseList(List<Product> products) {
        return products.stream()
                .map(product -> ProductResponse.builder()
                        .productId(product.getProductId())
                        .productName(product.getProductName())
                        .quantity(product.getQuantity())
                        .price(product.getPrice())
                        .productCreatedDate(product.getProductCreatedDate().getTime())
                        .productUpdatedDate(product.getProductUpdatedDate().getTime())
                        .build()).collect(Collectors.toList());
    }
*/
}

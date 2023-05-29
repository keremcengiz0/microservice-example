package com.eleiatech.stockmanagement.productcacheservice.feign.product;

import com.eleiatech.stockmanagement.productcacheservice.enums.Language;
import com.eleiatech.stockmanagement.productcacheservice.response.InternalApiResponse;
import com.eleiatech.stockmanagement.productcacheservice.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "${feign.product.name}")
public interface ProductServiceFeignClient {
    @GetMapping("/api/1.0/product/{language}/get/{productId}")
    InternalApiResponse<ProductResponse> getProduct(@PathVariable("language")Language language,
                                                    @PathVariable("productId") Long productId);
}

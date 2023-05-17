package com.eleiatech.stockmanagement.productservice.controller;

import com.eleiatech.stockmanagement.productservice.converter.ProductConverter;
import com.eleiatech.stockmanagement.productservice.enums.Language;
import com.eleiatech.stockmanagement.productservice.exception.enums.FriendlyMessageCodes;
import com.eleiatech.stockmanagement.productservice.exception.utils.FriendlyMessageUtils;
import com.eleiatech.stockmanagement.productservice.repository.entity.Product;
import com.eleiatech.stockmanagement.productservice.request.ProductCreateRequest;
import com.eleiatech.stockmanagement.productservice.response.FriendlyMessage;
import com.eleiatech.stockmanagement.productservice.response.InternalApiResponse;
import com.eleiatech.stockmanagement.productservice.response.ProductResponse;
import com.eleiatech.stockmanagement.productservice.service.IProductRepositoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/1.0/product")
public class ProductController {
    private final IProductRepositoryService productRepositoryService;
    private final ProductConverter productConverter;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/{language}/create")
    public InternalApiResponse<ProductResponse> createProduct(@PathVariable("language") Language language,
                                                              @RequestBody ProductCreateRequest productCreateRequest) {

        log.debug("[{}][createProduct] -> request: {}", this.getClass().getSimpleName(), productCreateRequest);

        Product product = productRepositoryService.createProduct(language, productCreateRequest);
        ProductResponse productResponse = productConverter.productToProductResponse(product);

        log.debug("[{}][createProduct] -> response: {}", this.getClass().getSimpleName(), productResponse);

        return InternalApiResponse.<ProductResponse>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(language, FriendlyMessageCodes.SUCCESS))
                        .description(FriendlyMessageUtils.getFriendlyMessage(language, FriendlyMessageCodes.PRODUCT_SUCCESSFULLY_CREATED)).build())
                .httpStatus(HttpStatus.CREATED)
                .hasError(false)
                .payload(productResponse)
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{language}/get/{productId}")
    public InternalApiResponse<ProductResponse> getProduct(@PathVariable("language") Language language,
                                                           @PathVariable("productId") Long productId) {

        log.debug("[{}][getProduct] -> request productId: {}", this.getClass().getSimpleName(), productId);

        Product product = productRepositoryService.getProduct(language, productId);
        ProductResponse productResponse = productConverter.productToProductResponse(product);

        log.debug("[{}][getProduct] -> response: {}", this.getClass().getSimpleName(), productResponse);

        return InternalApiResponse.<ProductResponse>builder()
                .httpStatus(HttpStatus.OK)
                .hasError(false)
                .payload(productResponse).build();
    }

}

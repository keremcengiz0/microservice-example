package com.eleiatech.stockmanagement.productcacheservice.repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("Product")
public class Product implements Serializable {
    @Id
    private Long productId;
    private String productName;
    private Integer quantity;
    private Double price;
    private Long productUpdatedDate;
    private Long productCreatedDate;
    private boolean deleted;

}

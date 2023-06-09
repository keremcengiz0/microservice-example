package com.eleiatech.stockmanagement.productcacheservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@PropertySource(value = "classpath:application.properties")
public class ProductCacheServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCacheServiceApplication.class, args);
	}

}

package com.jkaru.microservice.productservice.service;

import com.jkaru.microservice.productservice.dto.ProductRequest;
import com.jkaru.microservice.productservice.dto.ProductResponse;
import com.jkaru.microservice.productservice.model.Product;
import com.jkaru.microservice.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    /**constructor injection**/
    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){

        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);

        log.info("Product {} saved", product.getId());
    }


    public List<ProductResponse> getAllProducts() {
        List<Product> products =productRepository.findAll();

//        return products.stream().map(product -> mapToProductResponse(product)).toList();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    public ProductResponse getProductById(String id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id " +id+ " not found"));

        return mapToProductResponse(product);
    }

    private ProductResponse mapToProductResponse(Product product) {

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}

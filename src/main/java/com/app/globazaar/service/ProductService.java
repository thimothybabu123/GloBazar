package com.app.globazaar.service;

import com.app.globazaar.dto.ProductDto;
public interface ProductService {
    // It is responsible for adding a product to the database.
    ProductDto addProduct(ProductDto productDTO, Long userId);
    /*
        * It is responsible for getting the product
        * from the database using the productId.
     */
    ProductDto getProductById(Long userId, Long productId);
}

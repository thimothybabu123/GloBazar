package com.app.globazaar.controller;

import com.app.globazaar.dto.ProductDto;
import com.app.globazaar.dto.UserDto;
import com.app.globazaar.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/*
    Add the required annotations to make this class a REST Controller
    for handling the product related requests.
 */
@RestController
@RequestMapping("/api")
@Validated
public class ProductController {

    @Autowired
    private ProductService productService;
    // create a REST API for adding a product for a valid user
    @PostMapping("/users/{id}/products")
    public ResponseEntity<ProductDto> createUser(@PathVariable @NotNull(message = "Id should not be null") Long id, @RequestBody @Valid ProductDto productDto) throws  RuntimeException{

        ProductDto productDto1 = productService.addProduct(productDto,id);

        return new ResponseEntity<>(productDto1, HttpStatus.CREATED);

    }

    // create a REST API for getting the product using the valid user using productId
    @GetMapping("/users/{userid}/products/{id}")
        public ResponseEntity<ProductDto> getUser(@PathVariable @NotNull(message = "userId can not be null") Long userid, @PathVariable @NotNull(message = "product id should not be null") Long id) throws  RuntimeException{

        ProductDto productDto = productService.getProductById(userid, id);

        return new ResponseEntity<>(productDto, HttpStatus.OK);

    }


}
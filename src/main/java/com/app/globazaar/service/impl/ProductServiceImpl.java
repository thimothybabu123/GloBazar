package com.app.globazaar.service.impl;

import com.app.globazaar.entity.User;
import com.app.globazaar.exception.ResourceNotFoundException;
import com.app.globazaar.repository.UserRepository;
import org.springframework.stereotype.Service;


import com.app.globazaar.dto.ProductDto;
import com.app.globazaar.entity.Product;
import com.app.globazaar.repository.ProductRepository;
import com.app.globazaar.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
/*
    make this into a service layer for User entity
    and implement the methods from UserService interface.
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public ProductDto addProduct(ProductDto productDTO, Long userId) {
        User user=userRepository.findById(userId).
                orElseThrow(()->new RuntimeException("User not found"));
        Product product = productRepository.findByName(productDTO.getName());
        if(product!=null){
            throw new RuntimeException("product Already Exists");
        }

        product = new Product();
        product.setName(productDTO.getName());
        product.setCategory(productDTO.getCategory());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
//        User user=userRepository.findById(userId)
//                .orElseThrow(()-> new RuntimeException("User does not exists"));

        product.setUser(user);
        user.getProducts().add(product);
        userRepository.save(user);
        productRepository.save(product);
        ProductDto productDto=new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setCategory(product.getCategory());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        productDto.setId(user.getId());
        return productDto;

    }

    @Override
    public ProductDto getProductById(Long userId, Long productId) {
//        User user=userRepository.findById(userId).
//                orElseThrow(()->new RuntimeException("User not found"));
        Product product=productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product", "productId",productId));

        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent())throw new ResourceNotFoundException("User not found with id", "id", userId);

        if (!product.getUser().getId().equals(userId)) {
            throw new ResourceNotFoundException("Product does not belong to the user", "userId", userId);
        }
        ProductDto productDto=new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setCategory(product.getCategory());
        productDto.setDescription(product.getDescription());
        productDto.setId(userId);
        return productDto;

    }
}

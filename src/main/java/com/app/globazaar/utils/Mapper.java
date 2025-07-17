package com.app.globazaar.utils;

import com.app.globazaar.GloBazaarApplication;
import com.app.globazaar.dto.ProductDto;
import com.app.globazaar.dto.UserDto;
import com.app.globazaar.entity.Product;
import com.app.globazaar.entity.User;

/*
    This class is used to map the entity to dto and vice versa
    for the user and product entity
 */
public class Mapper {
    // map the product entity to product dto
    public static ProductDto mapToProductDto(Product product) {
        return GloBazaarApplication.modelMapper().map(product, ProductDto.class);

    }

    // map the user entity to user dto
    public static Product mapToProductEntity(ProductDto productDto) {
        return GloBazaarApplication.modelMapper().map(productDto, Product.class);
    }

    // map the user entity to user dto
    public static UserDto mapToUserDto(User user) {
        return GloBazaarApplication.modelMapper().map(user, UserDto.class);
    }

    // map the user dto to user entity
    public static User mapToUserEntity(UserDto userDto) {
        return GloBazaarApplication.modelMapper().map(userDto, User.class);
    }
}

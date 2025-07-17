package com.app.globazaar.service.impl;

import com.app.globazaar.dto.ProductDto;
import com.app.globazaar.dto.UserDto;
import com.app.globazaar.entity.Product;
import com.app.globazaar.entity.User;
import com.app.globazaar.exception.ResourceNotFoundException;
import com.app.globazaar.repository.UserRepository;
import com.app.globazaar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/*
    make this into a service layer for User entity
    and implement the methods from UserService interface.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDto addUser(UserDto userDTO) {
        User user = userRepository.findByEmail(userDTO.getEmail());
        if(user!=null){
            throw new RuntimeException("User already exists with"+ userDTO.getEmail());
        }


        User user1 = new User();
        user1.setUsername(userDTO.getUsername());
        user1.setEmail(userDTO.getEmail());
        user1.setPassword(userDTO.getPassword());

        userRepository.save(user1);

        UserDto userDto1= new UserDto();
        userDto1.setId(user1.getId());
        userDto1.setUsername(user1.getUsername());
        userDto1.setEmail(user1.getEmail());
        userDto1.setPassword(user1.getPassword());

        List<Product> products = new ArrayList<>();


        return userDto1;
    }

    @Override
    public UserDto getUserById(Long userId) {
       User user=userRepository.findById(userId).
               orElseThrow(()->new ResourceNotFoundException("user","userId",userId));

        UserDto userDto=new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());

        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : user.getProducts()) {
            ProductDto dto = new ProductDto();
            dto.setId(product.getId());
            dto.setName(product.getName());
            dto.setPrice(product.getPrice());
            dto.setCategory(product.getCategory());
            dto.setDescription(product .getDescription());

            productDtoList.add(dto);
        }

        userDto.setProductsdto(productDtoList);
        return userDto;

    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User", "UserId",userId));
        userRepository.delete(user);

    }
}

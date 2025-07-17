package com.app.globazaar.controller;

import com.app.globazaar.dto.UserDto;
import com.app.globazaar.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
/*
    Add the required annotations to make this class a REST Controller
    for handling the user related requests.
 */

@RestController
@RequestMapping("/api")
@Validated
public class UserController {
    @Autowired
    public UserService userService;
    // create a REST API for creating the user profile
    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid  UserDto userDto) throws  RuntimeException{

        UserDto userDto1 = userService.addUser(userDto);

        return new ResponseEntity<>(userDto1, HttpStatus.CREATED);

    }


    // create a REST API for fetching the detail of the valid user using userId
    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable @NotNull(message = "id should not be null") Long id) throws  RuntimeException{

        UserDto userDto = userService.getUserById(id);

        return new ResponseEntity<>(userDto, HttpStatus.OK);

    }

    // create a REST API for deleting the user using userId
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable @NotNull(message = "id should not be null") Long id) throws  RuntimeException{

        userService.deleteUser(id);
        return ResponseEntity.ok("Deleted");

    }

}
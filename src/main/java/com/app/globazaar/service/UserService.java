package com.app.globazaar.service;

import com.app.globazaar.dto.UserDto;

public interface UserService {
    // It is responsible for adding a user to the database.
    UserDto addUser(UserDto userDTO);
    // It is responsible for getting the user from the database using the userId.
    UserDto getUserById(Long userId);
    // It is responsible for deleting the user in the database using the userId.
    void deleteUser(Long userId);
}

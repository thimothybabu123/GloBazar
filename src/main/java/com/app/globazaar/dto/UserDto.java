package com.app.globazaar.dto;

import com.app.globazaar.entity.Product;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/*
    * Add the appropriate annotation for the fields to handle the validation
      using hibernate validator.
      * username should not be null and should have a minimum of 5 characters
      * user email should not be null and should be a valid email
      * user password should not be null and should have a minimum of 8 characters
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {
    private Long id;

    @NotBlank(message = "Username cannot be Null or Blank")
    @Size(min = 5)
    private String username;

    @NotBlank(message = "Email cannot be Null or Blank")
    @Email(message = "Email should be in correct format")
    private String email;

    @NotBlank(message = "Password cannot be Null or Blank")
    @Size(min = 8)
    private String password;

    private List<ProductDto> productsdto;


}
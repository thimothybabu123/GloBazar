package com.app.globazaar.dto;

import com.app.globazaar.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/*
    * Add the appropriate annotation for the fields to handle the validation
      using hibernate validator. Requirements are:
      * product name should not be null and should have a minimum of 3 characters
      * product price should not be null
      * product description should not be null and should have a minimum of 10 characters
      * product category should not be null and should have a minimum of 3 characters
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {
    private Long id;

    @NotBlank(message = "Product name cannot be Null or Blank")
    private String name;

    @NotNull(message = "Product price cannot be Null")
    private Double price;

    @NotBlank(message = "Product description cannot be Null or Blank")
    private String description;

    @NotBlank(message = "Product category cannot be Null or Blank")
    private String category;
}


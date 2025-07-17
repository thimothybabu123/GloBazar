package com.app.globazaar.entity;

import com.app.globazaar.dto.ProductDto;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/*
    task is to add the required annotation to make this class a JPA entity
 */
@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class User {
    /*
        task is to add a new column id of type Long.
        It should support the auto-generation of the primary key.
        Use appropriate annotation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*
        task is to add a new column username of type String.
        It should not be null.
        Use appropriate annotation.
     */
    @Column(name = "username", nullable = false)
    private String username;
    /*
        task is to add a new column email of type String.
        Email must be unique and should not be null.
        Use appropriate annotation.
     */
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    /*
        task is to add a new column password of type String.
        It should not be null.
        Use appropriate annotation.
      */
    @Column(name = "password", nullable = false)
    private String password;

    /*
        task is to establish the mapping between User and Product
        it should be a appropriate mapping as per the diagram
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @Valid
    private List<Product> products;



}

package com.app.globazaar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "product")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Product {
    /*
        task is to add a new column id of type Long.
        It should support the auto-generation of the primary key.
        Use appropriate annotation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*
        task is to add a new column name of type String.
        It should not be null.
        Use appropriate annotation.
     */
    @Column(name = "name", nullable = false)
    private String name;
    /*
        task is to add a new column category of type String.
        It should not be null.
        Use appropriate annotation.
     */
    @Column(name = "category", nullable = false)
    private String category;
    /*
        task is to add a new column price of type Double.
        It should not be null.
        Use appropriate annotation.
     */
    @Column(name = "price", nullable = false)
    private Double price;
    /*
         task is to add a new column description of type String.
         It should not be null.
         Use appropriate annotation.
     */
    @Column(name = "description", nullable = false)
    private String description;

    /*
        task is to establish the mapping between User and Product
        it should be a appropriate mapping as per the diagram
     */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @Valid
    private User user;


}

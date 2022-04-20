package com.compu.mundo.facturacion.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@DynamicUpdate
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
//    @NotEmpty(message = "El ID del producto no puede estar vacio")
    private Long id;

    @Column(name = "NAME")
    @NotEmpty(message = "El nombre del producto no puede estar vacio")
    private String name;

    //    @Pattern(regexp = "[0-9]", message = "El stock solo admite numeros enteros")
    @Column(name = "STOCK")
    @NotNull(message = "El stock no puede estar vacio")
    @Min(value = 0, message="El stock mínimo es 0")
    private int stock;

    @Column(name = "PRICE")
    @NotNull(message = "El precio no puede estar vacio")
    @Min(value = 1, message="El precio mínimo es 1")
    private double price;

    @Column(name = "DETAIL")
    @NotEmpty(message = "El detalle no puede estar vacio")
    private String detail;

    @ManyToOne(optional = false)
    @JoinColumn(name = "categoryId", referencedColumnName = "id")
    @NotNull(message = "Category Id no puede estar vacio")
    private Category category;
}

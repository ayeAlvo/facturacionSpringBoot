package com.compu.mundo.facturacion.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@DynamicUpdate
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    @NotEmpty(message = "El nombre del producto no puede estar vacio")
    @Length(min=3,max=150, message = "El nombre debe tener mas de 3 caracteres y menos de 150")
    private String name;

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
    @Length(min=3,max=255, message = "El detalle debe tener mas de 3 caracteres y menos de 255")
    private String detail;

    @ManyToOne(optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "categoryId", referencedColumnName = "id")
    @NotNull(message = "Category Id no puede estar vacio")
    private Category category;
}

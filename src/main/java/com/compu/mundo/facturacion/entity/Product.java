package com.compu.mundo.facturacion.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "STOCK")
    private int stock;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "DETAIL")
    private String detail;

//    @Column(name = "CATEGORY_ID")
//    private Long categoryId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "categoryId", referencedColumnName = "id")
    private Category category;
}

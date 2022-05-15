package com.compu.mundo.facturacion.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@DynamicUpdate
@Table(name = "DETAILS")
public class Detail {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @OneToMany(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ID", referencedColumnName = "id")
    private List<Product> product;

    @Column(name = "QUANTITY")
    private int quantity;

    @JoinColumn(name = "PARCIAL_PRICE")
    private Double parcialPrice;

    @Column(name = "invoice_id")
    private Long idInvoice;

}

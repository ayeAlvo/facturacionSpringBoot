package com.compu.mundo.facturacion.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "COMPANY")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @Column(name = "NAME")
    @NotEmpty(message = "El nombre no puede estar vacio")
    @Length(min=3,max=150, message = "El nombre debe tener mas de 3 caracteres y menos de 150")
    String name;

    @Column(name = "ITEM")
    @NotEmpty(message = "El rubro no puede estar vacio")
    @Length(min=3,max=150, message = "El rubro debe tener mas de 3 caracteres y menos de 150")
    String item;
}

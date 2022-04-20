package com.compu.mundo.facturacion.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "CLIENTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    @NotEmpty(message = "El nombre no puede estar vacio")
    @Length(min=3,max=150, message = "El nombre debe tener mas de 3 caracteres y menos de 150")
    private String name;

    @Column(name = "LAST_NAME")
    @NotEmpty(message = "El apellido no puede estar vacio")
    @Length(min=3,max=150, message = "El apellido debe tener mas de 3 caracteres y menos de 150")
    private String lastName;

    @Column(name = "EMAIL")
    @Email(message = "El email debe ser un email valido")
    private String email;

    @Column(name = "PHONE")
    @NotNull(message = "El numero no puede estar vacio")
    @Min(value = 0, message="El numero mínimo permitido es 0")
    private Long phone;
}

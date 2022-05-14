package com.compu.mundo.facturacion.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@DynamicUpdate
@Table(name = "INVOICES")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATE")
    public Date date;

    @Column(name = "TOTAL")
    public Double total;

    @ManyToOne
    @JoinTable(name = "CLIENTS", joinColumns = @JoinColumn(name = "ID"))
    private Client client;

    @OneToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "DETAILS", joinColumns = @JoinColumn(name = "ID"))
    private List<Detail> detail;

    @ManyToOne
    @JoinTable(name = "COMPANY", joinColumns = @JoinColumn(name = "ID"))
    private Company company;
}

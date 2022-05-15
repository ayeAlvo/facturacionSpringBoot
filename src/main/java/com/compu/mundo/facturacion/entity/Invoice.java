package com.compu.mundo.facturacion.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "id")
    private Client client;

    @OneToMany(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ID", referencedColumnName = "id")
    private List<Detail> detail;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "id")
    private Company company;
}

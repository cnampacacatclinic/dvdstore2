package com.dvdstore.panier.repositories;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "panier")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PanierRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_panier;

    @Column(name = "id_client")
    private Integer idClient;

    @Column(name = "id_dvd")
    private Integer idDvd;

    @Column(name = "prix_unitaire")
    private float prixUnitaire;

    @Column(name="total")
    private float total;

    @CreationTimestamp
    @Column(name="date")
    private Date date;

    @Column(name = "quantity")
    private Integer quantity;

}

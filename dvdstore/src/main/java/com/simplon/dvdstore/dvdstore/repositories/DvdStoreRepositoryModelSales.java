package com.simplon.dvdstore.dvdstore.repositories;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DvdStoreRepositoryModelSales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="fk_users")
    private int FKUsers;
    @Column(name="fk_movies")
    private int FKMovies;
    @Column(name="quantity_sales")
    private int quantityOfSales;
}

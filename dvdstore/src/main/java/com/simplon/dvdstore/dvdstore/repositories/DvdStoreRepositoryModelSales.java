package com.simplon.dvdstore.dvdstore.repositories;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "sales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DvdStoreRepositoryModelSales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "fk_users", nullable=true)
    DvdStoreRepositoryModelCustomers FKUsers;

    @ManyToOne()
    @JoinColumn(name = "fk_movies",nullable=true)
    DvdStoreRepositoryModelMovies FKMovies;

    @Column(name = "quantity_sales")
    private Long quantityOfSales;

    @CreationTimestamp
    @Column(name="date")
    private Date date;

    @Column(name="total")
    private float total;

    public DvdStoreRepositoryModelSales(DvdStoreRepositoryModelCustomers FKUsers, DvdStoreRepositoryModelMovies FKMovies, Long quantityOfSales, Date date,float total) {
        this.FKUsers = FKUsers;
        this.FKMovies = FKMovies;
        this.quantityOfSales = quantityOfSales;
        this.date = date;
        this.total = total;
    }


    //private Long date;
}

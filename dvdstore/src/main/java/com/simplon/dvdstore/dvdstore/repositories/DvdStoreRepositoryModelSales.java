package com.simplon.dvdstore.dvdstore.repositories;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @JoinColumn(name = "fk_users")
    @OnDelete(action = OnDeleteAction.CASCADE)
    DvdStoreRepositoryModelCustomers FKUsers;

    @ManyToOne()
    @JoinColumn(name = "fk_movies")
    @OnDelete(action = OnDeleteAction.CASCADE)
    DvdStoreRepositoryModelMovies FKMovies;

    @Column(name = "quantity_sales")
    private Long quantityOfSales;

    @CreationTimestamp
    @Column(name="date")
    private Date date;

    //private Long date;
}

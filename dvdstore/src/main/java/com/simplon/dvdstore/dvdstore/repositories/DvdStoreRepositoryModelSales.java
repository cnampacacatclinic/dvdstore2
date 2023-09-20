package com.simplon.dvdstore.dvdstore.repositories;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "sales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DvdStoreRepositoryModelSales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_users")
    @OnDelete(action = OnDeleteAction.CASCADE)
    DvdStoreRepositoryModelCustomers FKUsers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_movies")
    @OnDelete(action = OnDeleteAction.CASCADE)
    DvdStoreRepositoryModelMovies FKMovies;

    @Column(name = "quantity_sales")
    private Long quantityOfSales;
}

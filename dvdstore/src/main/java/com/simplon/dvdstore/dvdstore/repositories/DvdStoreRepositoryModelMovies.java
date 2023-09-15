package com.simplon.dvdstore.dvdstore.repositories;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DvdStoreRepositoryModelMovies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="genre")
    private String genre;
    @Column(name="name")
    private String name;
    @Column(name="quantity")
    private int quantity;
    @Column (name="price")
    private float price;
}
package com.simplon.dvdstore.dvdstore.repositories;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DvdStoreRepositoryModelCustomers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@OneToMany
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="mail")
    private String mail;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="street_number")
    private Long streetNumber;
    @Column(name="street_name")
    private String streetName;
    @Column(name="postcode")
    private Long postcode;
    @Column(name="city")
    private String city;
    @Column(name="voie")
    private String voie;

}

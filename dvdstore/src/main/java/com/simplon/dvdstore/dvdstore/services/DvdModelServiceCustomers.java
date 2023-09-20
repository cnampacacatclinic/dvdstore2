package com.simplon.dvdstore.dvdstore.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DvdModelServiceCustomers {
    private String firstName;
    private String lastName;
    private String mail;
    private String phoneNumber;
    private Long streetNumber;
    private String streetName;
    private Long postcode;
    private String city;
    private String voie;
}

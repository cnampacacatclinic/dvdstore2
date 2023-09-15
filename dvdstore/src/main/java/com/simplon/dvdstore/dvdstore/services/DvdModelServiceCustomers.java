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
    private String streetNumber;
    private String streetName;
    private String postcode;
    private String city;
    private String country;
}

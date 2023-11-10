package com.simplon.dvdstore.dvdstore.controllers;

public record DvdStoreDtoIdCustomers(
        Long id, String firstName, String lastName, String mail, String phoneNumber, Long streetNumber, String streetName, Long postcode, String city, String voie) {
}

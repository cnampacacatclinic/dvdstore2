package com.simplon.dvdstore.dvdstore.controllers;

public record DvdStoreDtoIdCustomers(
        Long id, String firstName, String lastName, String mail, String phoneNumber, String streetNumber, String streetName, String postcode, String city, String voie) {
}

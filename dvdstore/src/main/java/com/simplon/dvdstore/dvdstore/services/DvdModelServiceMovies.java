package com.simplon.dvdstore.dvdstore.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DvdModelServiceMovies {
    //int id;
    String genre;
    String name;
    int quantity;
    float price;
}

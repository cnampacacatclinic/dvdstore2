package com.simplon.dvdstore.dvdstore.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DvdModelServiceMovies {

    String genre;
    String name;
    Long quantity;
    float price;
}

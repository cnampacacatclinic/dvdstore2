package com.simplon.dvdstore.dvdstore.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DvdModelServiceSales {
    private int FKUsers;
    private int FKMovies;
    private float quantityOfSales;
}

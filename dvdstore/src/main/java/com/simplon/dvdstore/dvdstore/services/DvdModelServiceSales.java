package com.simplon.dvdstore.dvdstore.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DvdModelServiceSales {
    private Long FKUsers;
    private Long FKMovies;
    private Long quantityOfSales;
    private Date date;
}

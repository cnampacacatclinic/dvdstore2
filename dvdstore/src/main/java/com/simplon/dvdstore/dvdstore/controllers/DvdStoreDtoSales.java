package com.simplon.dvdstore.dvdstore.controllers;

import java.util.Date;

public record DvdStoreDtoSales(Long FKUsers, Long FKMovies, Long quantityOfSales,Date date,float total) {

}

package com.simplon.dvdstore.dvdstore.controllers;

import java.util.Date;

public record DvdStoreDtoSales(Long FKUsers, Long FKMovies, float quantityOfSales,Date date) {
}

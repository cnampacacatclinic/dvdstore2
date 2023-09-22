package com.simplon.dvdstore.dvdstore.controllers;

import java.util.Date;

public record DvdStoreDtoIdSales(Long id, Long customer_id, Long movie_id, Long quantityOfSales, Date date) {
}

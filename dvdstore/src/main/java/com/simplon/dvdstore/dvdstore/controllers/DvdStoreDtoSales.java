package com.simplon.dvdstore.dvdstore.controllers;

import java.util.Date;

public record DvdStoreDtoSales(Long customer_id, Long movie_id, Long quantityOfSales,Date date,float total) {

}

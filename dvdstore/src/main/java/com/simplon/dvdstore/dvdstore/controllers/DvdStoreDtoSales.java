package com.simplon.dvdstore.dvdstore.controllers;

import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModelCustomers;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModelMovies;

import java.util.Date;

public record DvdStoreDtoSales(DvdStoreRepositoryModelCustomers FKUsers, DvdStoreRepositoryModelMovies FKMovies, Long quantityOfSales,Date date) {

}

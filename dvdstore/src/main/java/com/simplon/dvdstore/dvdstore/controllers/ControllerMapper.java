package com.simplon.dvdstore.dvdstore.controllers;

import com.simplon.dvdstore.dvdstore.services.DvdModelServiceCustomers;
import com.simplon.dvdstore.dvdstore.services.DvdModelServiceMovies;
import com.simplon.dvdstore.dvdstore.services.DvdModelServiceSales;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ControllerMapper {
    ControllerMapper INSTANCE = Mappers.getMapper( ControllerMapper.class );

    @Mapping(source = "FKUsers", target = "FKUsers")
    @Mapping(source = "FKMovies", target = "FKMovies")
    @Mapping(source = "quantityOfSales", target = "quantityOfSales")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "total", target = "total")
    DvdStoreDtoSales serviceToDtoSale(DvdModelServiceSales serviceSale);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "mail", source = "mail")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "streetNumber", source = "streetNumber")
    @Mapping(target = "streetName", source = "streetName")
    @Mapping(target = "postcode", source = "postcode")
    @Mapping(target = "city", source = "city")
    @Mapping(target = "voie", source = "voie")
    DvdStoreDtoIdCustomers serviceToDtoCustomer(DvdModelServiceCustomers serviceCustomer);

    @Mapping(target = "genre", source = "genre")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "imgPath", source = "imgPath")
    @Mapping(target = "synopsis", source = "synopsis")
    DvdStoreDtoMovies serviceToDtoMovie(DvdModelServiceMovies serviceMovie);

}

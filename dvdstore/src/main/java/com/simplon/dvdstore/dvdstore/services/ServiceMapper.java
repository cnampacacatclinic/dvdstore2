package com.simplon.dvdstore.dvdstore.services;
import com.simplon.dvdstore.dvdstore.controllers.DvdStoreDtoCustomers;
import com.simplon.dvdstore.dvdstore.controllers.DvdStoreDtoIdCustomers;
import com.simplon.dvdstore.dvdstore.controllers.DvdStoreDtoMovies;
import com.simplon.dvdstore.dvdstore.controllers.DvdStoreDtoSales;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ServiceMapper {
    ServiceMapper INSTANCE = Mappers.getMapper( ServiceMapper.class );

    @Mapping(source = "FKUsers", target = "FKUsers")
    @Mapping(source = "FKMovies", target = "FKMovies")
    @Mapping(source = "quantityOfSales", target = "quantityOfSales")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "total", target = "total")
    DvdModelServiceSales dtoToServiceSale(DvdStoreDtoSales  dtoSales);

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
    DvdModelServiceCustomers dtoToServiceCustomer(DvdStoreDtoCustomers dtoCustomer);

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
    DvdModelServiceCustomers dtoIdToServiceCustomer(DvdStoreDtoIdCustomers dtoCustomer);

    @Mapping(target = "genre", source = "genre")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "imgPath", source = "imgPath")
    @Mapping(target = "synopsis", source = "synopsis")
    DvdModelServiceMovies dtoToServiceMovie(DvdStoreDtoMovies dtoMovie);
}

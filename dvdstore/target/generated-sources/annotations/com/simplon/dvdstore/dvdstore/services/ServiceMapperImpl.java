package com.simplon.dvdstore.dvdstore.services;

import com.simplon.dvdstore.dvdstore.controllers.DvdStoreDtoIdCustomers;
import com.simplon.dvdstore.dvdstore.controllers.DvdStoreDtoMovies;
import com.simplon.dvdstore.dvdstore.controllers.DvdStoreDtoSales;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-14T11:57:31+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
public class ServiceMapperImpl implements ServiceMapper {

    @Override
    public DvdModelServiceSales dtoToServiceSale(DvdStoreDtoSales dtoSales) {
        if ( dtoSales == null ) {
            return null;
        }

        DvdModelServiceSales dvdModelServiceSales = new DvdModelServiceSales();

        dvdModelServiceSales.setFKUsers( dtoSales.FKUsers() );
        dvdModelServiceSales.setFKMovies( dtoSales.FKMovies() );
        dvdModelServiceSales.setQuantityOfSales( dtoSales.quantityOfSales() );
        dvdModelServiceSales.setDate( dtoSales.date() );
        dvdModelServiceSales.setTotal( dtoSales.total() );

        return dvdModelServiceSales;
    }

    @Override
    public DvdModelServiceCustomers dtoIdToServiceCustomer(DvdStoreDtoIdCustomers dtoCustomer) {
        if ( dtoCustomer == null ) {
            return null;
        }

        DvdModelServiceCustomers dvdModelServiceCustomers = new DvdModelServiceCustomers();

        dvdModelServiceCustomers.setId( dtoCustomer.id() );
        dvdModelServiceCustomers.setFirstName( dtoCustomer.firstName() );
        dvdModelServiceCustomers.setLastName( dtoCustomer.lastName() );
        dvdModelServiceCustomers.setMail( dtoCustomer.mail() );
        dvdModelServiceCustomers.setPhoneNumber( dtoCustomer.phoneNumber() );
        dvdModelServiceCustomers.setStreetNumber( dtoCustomer.streetNumber() );
        dvdModelServiceCustomers.setStreetName( dtoCustomer.streetName() );
        dvdModelServiceCustomers.setPostcode( dtoCustomer.postcode() );
        dvdModelServiceCustomers.setCity( dtoCustomer.city() );
        dvdModelServiceCustomers.setVoie( dtoCustomer.voie() );

        return dvdModelServiceCustomers;
    }

    @Override
    public DvdModelServiceMovies dtoToServiceMovie(DvdStoreDtoMovies dtoMovie) {
        if ( dtoMovie == null ) {
            return null;
        }

        DvdModelServiceMovies dvdModelServiceMovies = new DvdModelServiceMovies();

        dvdModelServiceMovies.setGenre( dtoMovie.genre() );
        dvdModelServiceMovies.setName( dtoMovie.name() );
        dvdModelServiceMovies.setQuantity( dtoMovie.quantity() );
        dvdModelServiceMovies.setPrice( dtoMovie.price() );
        dvdModelServiceMovies.setImgPath( dtoMovie.imgPath() );
        dvdModelServiceMovies.setSynopsis( dtoMovie.synopsis() );

        return dvdModelServiceMovies;
    }
}

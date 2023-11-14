package com.simplon.dvdstore.dvdstore.controllers;

import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModelCustomers;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModelMovies;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-14T11:57:30+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
public class ControllerMapperImpl implements ControllerMapper {

    @Override
    public DvdStoreDtoCustomers dtoToRepositoryCustomer(DvdStoreRepositoryModelCustomers repositoryCustomer) {
        if ( repositoryCustomer == null ) {
            return null;
        }

        Long id = null;
        String firstName = null;
        String lastName = null;
        String mail = null;
        String phoneNumber = null;
        Long streetNumber = null;
        String streetName = null;
        Long postcode = null;
        String city = null;
        String voie = null;

        id = repositoryCustomer.getId();
        firstName = repositoryCustomer.getFirstName();
        lastName = repositoryCustomer.getLastName();
        mail = repositoryCustomer.getMail();
        phoneNumber = repositoryCustomer.getPhoneNumber();
        streetNumber = repositoryCustomer.getStreetNumber();
        streetName = repositoryCustomer.getStreetName();
        postcode = repositoryCustomer.getPostcode();
        city = repositoryCustomer.getCity();
        voie = repositoryCustomer.getVoie();

        DvdStoreDtoCustomers dvdStoreDtoCustomers = new DvdStoreDtoCustomers( id, firstName, lastName, mail, phoneNumber, streetNumber, streetName, postcode, city, voie );

        return dvdStoreDtoCustomers;
    }

    @Override
    public DvdStoreDtoIdMovies dtoToRepositoryMovie(DvdStoreRepositoryModelMovies repositoryMovie) {
        if ( repositoryMovie == null ) {
            return null;
        }

        String genre = null;
        String name = null;
        Long quantity = null;
        float price = 0.0f;
        String imgPath = null;
        String synopsis = null;
        Long id = null;

        genre = repositoryMovie.getGenre();
        name = repositoryMovie.getName();
        quantity = repositoryMovie.getQuantity();
        price = repositoryMovie.getPrice();
        imgPath = repositoryMovie.getImgPath();
        synopsis = repositoryMovie.getSynopsis();
        id = repositoryMovie.getId();

        DvdStoreDtoIdMovies dvdStoreDtoIdMovies = new DvdStoreDtoIdMovies( id, name, genre, quantity, price, imgPath, synopsis );

        return dvdStoreDtoIdMovies;
    }
}

package com.dvdstore.panier.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PanierRepositoryInterface extends CrudRepository<PanierRepositoryModel,Long> {
    ArrayList<PanierRepositoryModel> findAll();
}

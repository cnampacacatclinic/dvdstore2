package com.simplon.dvdstore.dvdstore.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface DvdStoreRepositoryInterface extends CrudRepository<DvdStoreRepositoryModel,Long> {

//d'abord créer un 
    ArrayList<DvdStoreRepositoryModel> findAll();



}

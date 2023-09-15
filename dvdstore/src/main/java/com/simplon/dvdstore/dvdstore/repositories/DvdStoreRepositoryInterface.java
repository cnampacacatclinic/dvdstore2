package com.simplon.dvdstore.dvdstore.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface DvdStoreRepositoryInterface extends CrudRepository<DvdStoreRepositoryModel,Long> {

    //d'abbord créer une methode dans le repostitory avant de l'utiliser dans le service et le crontoller
    ArrayList<DvdStoreRepositoryModel> findAll();



}

package com.simplon.dvdstore.dvdstore.repositories;

import jakarta.persistence.ManyToMany;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface DvdStoreRepositoryInterfaceMovies extends CrudRepository<DvdStoreRepositoryModelMovies,Long> {

    //d'abbord créer une methode dans le repostitory avant de l'utiliser dans le service et le crontoller
    //@ManyToMany(mappedBy = "movies")
    ArrayList<DvdStoreRepositoryModelMovies> findAll();
}

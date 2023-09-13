package com.simplon.dvdstore.dvdstore.services;

import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepository;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DvdStoreService {
    @Autowired
    private DvdStoreRepository dvdStoreRepository;

    //je ne peux pas utiliser List donc j'ai mis Iterable car dans
    //l'interface j'utilise CrudRepository<DvdStoreRepositoryModel,Long>
    public Iterable<DvdStoreRepositoryModel> findAll() {
        return dvdStoreRepository.findAll();
    }


    //pout inserer en table
    public DvdStoreRepositoryModel save(DvdStoreRepositoryModel dvd) {
        return dvdStoreRepository.save(dvd);
    }
}

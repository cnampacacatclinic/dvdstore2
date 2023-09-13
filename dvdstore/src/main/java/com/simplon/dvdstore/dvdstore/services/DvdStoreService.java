package com.simplon.dvdstore.dvdstore.services;

import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryInterface;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DvdStoreService {
    @Autowired
    private DvdStoreRepositoryInterface dvdStoreRepository;

    //je ne peux pas utiliser List donc j'ai mis Iterable car dans
    //l'interface j'utilise CrudRepository<DvdStoreRepositoryModel,Long>
    public ArrayList<DvdStoreRepositoryModel> findAll() {
        ArrayList<DvdStoreRepositoryModel> dvdList = (ArrayList<DvdStoreRepositoryModel>) dvdStoreRepository.findAll();
        DvdStoreRepositoryModel unDvd = new DvdStoreRepositoryModel();
        for(DvdStoreRepositoryModel dvd : dvdList){
            dvdList.add(unDvd.getId(),unDvd.getName(),unDvd.getGenre());
        }
        return dvdList;
    }


    //pout inserer en table
    public DvdStoreRepositoryModel save(DvdStoreRepositoryModel dvd) {
        return dvdStoreRepository.save(dvd);
    }
}

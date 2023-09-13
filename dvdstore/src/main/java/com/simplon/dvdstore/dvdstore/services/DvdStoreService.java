package com.simplon.dvdstore.dvdstore.services;

import com.simplon.dvdstore.dvdstore.controllers.DvdStoreDto;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryInterface;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Service
public class DvdStoreService {
    @Autowired
    private DvdStoreRepositoryInterface dvdStoreRepository;

    //je ne peux pas utiliser List donc j'ai mis Iterable car dans
    //l'interface j'utilise CrudRepository<DvdStoreRepositoryModel,Long>
    public ArrayList<DvdStoreDto> findAll() {
        ArrayList<DvdStoreRepositoryModel> dvdList = dvdStoreRepository.findAll();
        ArrayList<DvdStoreDto> dvdDtoList = new ArrayList<>();

        for(DvdStoreRepositoryModel dvd : dvdList){
            DvdStoreDto dvdDto = new DvdStoreDto(dvd.getName(), dvd.getGenre());
            dvdDtoList.add(dvdDto);
        }

        return dvdDtoList;
    }


    //pout inserer en table
    public DvdStoreRepositoryModel save(DvdStoreRepositoryModel dvd) {
        return dvdStoreRepository.save(dvd);
    }

    // Supprimer un DVD par son ID
    public void delete(long id){
        dvdStoreRepository.deleteById(id);
    }

}

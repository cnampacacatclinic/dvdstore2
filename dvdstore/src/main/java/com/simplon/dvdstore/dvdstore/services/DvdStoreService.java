package com.simplon.dvdstore.dvdstore.services;

import com.simplon.dvdstore.dvdstore.controllers.DvdStoreDto;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryInterface;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DvdStoreService {
    @Autowired
    private DvdStoreRepositoryInterface dvdStoreRepository;

    DvdStoreDto Dto;

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
    public boolean delete(long id){
        dvdStoreRepository.deleteById(id);
        return true;
    }

    public boolean updateById(Long id, DvdModelService dvd) {
        //Service a reçu un DTO de la part du controller
        //Le rpository permet d'obtenir les models getters  setters etc..
        if (id != null) {
            DvdStoreRepositoryModel dvd2 = dvdStoreRepository.findById(id).orElse(null);
            if(dvd2!=null)
            {
                DvdStoreRepositoryModel dvdStoreRepositoryModel = new DvdStoreRepositoryModel(id,dvd.getGenre(),dvd.getName());
                var x = dvdStoreRepository.save(dvdStoreRepositoryModel);
                if(x!=null) {
                    return true;
                }else {
                    return false;
                }
            }
            /*dvd.setName(dvd2.getName());
            dvd.setGenre(dvd2.getGenre());
            return dvdStoreRepository.save(dvd);*/
        }else {
            return false;
        }
        return false;
    }

    // Obtenir un DVD par son ID
    public DvdStoreRepositoryModel findById(Long id) {
        //le orElse c'est parce que l'identifiant n'existe peut-être pas
        return dvdStoreRepository.findById(id).orElse(null);
    }

}

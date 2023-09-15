package com.simplon.dvdstore.dvdstore.services;

import com.simplon.dvdstore.dvdstore.controllers.DvdStoreDto;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryInterface;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModelMovies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DvdStoreService {
    @Autowired
    private DvdStoreRepositoryInterface dvdStoreRepository;

    public ArrayList<DvdStoreDto> findAll() {
        ArrayList<DvdStoreRepositoryModelMovies> dvdList = dvdStoreRepository.findAll();
        ArrayList<DvdStoreDto> dvdDtoList = new ArrayList<>();

        for(DvdStoreRepositoryModelMovies dvd : dvdList){
            DvdStoreDto dvdDto = new DvdStoreDto(dvd.getName(), dvd.getGenre(), dvd.getQuantity(),dvd.getPrice());
            dvdDtoList.add(dvdDto);
        }

        return dvdDtoList;
    }


    //pout inserer en table
    public DvdStoreRepositoryModelMovies save(DvdStoreRepositoryModelMovies dvd) {
        return dvdStoreRepository.save(dvd);
    }

    // Supprimer un DVD par son ID
    public boolean delete(long id){
        dvdStoreRepository.deleteById(id);
        //pour renvoyer true dans la console
        return true;
    }

    public boolean updateById(Long id, DvdModelServiceMovies dvd) {
        //Service a reçu un DTO de la part du controller
        //Le repository permet d'obtenir les models getters  setters etc..
        if (id != null) {
            DvdStoreRepositoryModelMovies dvd2 = dvdStoreRepository.findById(id).orElse(null);
            if(dvd2!=null)
            {
                //les parametres entre les parentheses du new DvdStoreRepositoryModel, ceux sont les mutatteurs du model de service
                DvdStoreRepositoryModelMovies dvdStoreRepositoryModel = new DvdStoreRepositoryModelMovies(id,dvd.getGenre(),dvd.getName(),dvd.getQuantity(),dvd.getPrice());
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
    public DvdStoreRepositoryModelMovies findById(Long id) {
        //le orElse c'est parce que l'identifiant n'existe peut-être pas
        return dvdStoreRepository.findById(id).orElse(null);
    }

}

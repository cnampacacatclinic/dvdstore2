package com.simplon.dvdstore.dvdstore.services;

import com.simplon.dvdstore.dvdstore.controllers.ControllerMapper;
import com.simplon.dvdstore.dvdstore.controllers.DvdStoreDtoIdMovies;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryInterfaceMovies;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModelMovies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DvdStoreServiceMovies {
    @Autowired
    private DvdStoreRepositoryInterfaceMovies dvdStoreRepository;

    public ArrayList<DvdStoreDtoIdMovies> findAll() {
        ArrayList<DvdStoreRepositoryModelMovies> dvdList = dvdStoreRepository.findAll();
        ArrayList<DvdStoreDtoIdMovies> dvdDtoList = new ArrayList<>();

        for(DvdStoreRepositoryModelMovies dvd : dvdList){

            DvdStoreDtoIdMovies dvdDto = ControllerMapper.INSTANCE.dtoToRepositoryMovie(dvd);

            //DvdStoreDtoIdMovies dvdDto = new DvdStoreDtoIdMovies(dvd.getId(),dvd.getName(), dvd.getGenre(), dvd.getQuantity(),dvd.getPrice(),dvd.getImgPath(),dvd.getSynopsis());
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
                DvdStoreRepositoryModelMovies dvdStoreRepositoryModel = new DvdStoreRepositoryModelMovies(id,dvd.getGenre(),dvd.getName(),dvd.getQuantity(),dvd.getPrice(),dvd.getImgPath(),dvd.getSynopsis());
                var x = dvdStoreRepository.save(dvdStoreRepositoryModel);
                if(x!=null) {
                    return true;
                }else {
                    return false;
                }
            }
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

package com.simplon.dvdstore.dvdstore.controllers;

import com.simplon.dvdstore.dvdstore.services.DvdModelServiceMovies;
import com.simplon.dvdstore.dvdstore.services.DvdModelServiceSales;
import com.simplon.dvdstore.dvdstore.services.ServiceMapper;
import org.springframework.web.bind.annotation.*;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModelMovies;
import com.simplon.dvdstore.dvdstore.services.DvdStoreServiceMovies;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController
//@RequestMapping("api/dvds")
@RequestMapping("dvds")
public class DvdStoreControllerMovies {
    @Autowired
    private DvdStoreServiceMovies dvdStoreService;

    //chemin http://localhost:8080/dvds/home
    @GetMapping("/")
    public ArrayList<DvdStoreDtoIdMovies> getAllDvds() {
        return dvdStoreService.findAll();
    }

    // Ajouter un nouveau DVD grace  la methode save dans DvdStoreService
    @PostMapping("/")
    public DvdStoreRepositoryModelMovies addDvd(@RequestBody DvdStoreRepositoryModelMovies dvd) {
        return dvdStoreService.save(dvd);
    }

    //Supprimer
    @DeleteMapping("/{id}")
    public boolean deleteDvd(@PathVariable Long id){
        return dvdStoreService.delete(id);
    }


    //Get by id
    //http://localhost:8080/dvds/dvd/3
    @GetMapping("/{id}")
    public DvdStoreRepositoryModelMovies getDvdById(@PathVariable Long id){
        return dvdStoreService.findById(id);
    }

    //Update
    @PutMapping("/{id}")
    public boolean updateDvd(@PathVariable Long id, @RequestBody DvdStoreDtoMovies dvd){
        DvdModelServiceMovies dvdModelService = ServiceMapper.INSTANCE.dtoToServiceMovie(dvd);
        return dvdStoreService.updateById(id,dvdModelService);
    }
}

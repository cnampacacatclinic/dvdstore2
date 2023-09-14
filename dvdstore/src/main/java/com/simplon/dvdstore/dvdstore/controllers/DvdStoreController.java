package com.simplon.dvdstore.dvdstore.controllers;

import org.springframework.web.bind.annotation.*;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModel;
import com.simplon.dvdstore.dvdstore.services.DvdStoreService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("dvds")
public class DvdStoreController {
    @Autowired
    private DvdStoreService dvdStoreService;

    //chemin http://localhost:8080/dvds/home
    @GetMapping("/home")
    public ArrayList<DvdStoreDto> getAllDvds() {
        return dvdStoreService.findAll();
    }

    // Ajouter un nouveau DVD grace  la methode save dans DvdStoreService
    @PostMapping("/add")
    public DvdStoreRepositoryModel addDvd(@RequestBody DvdStoreRepositoryModel dvd) {
        return dvdStoreService.save(dvd);
    }

    //Supprimer
    @DeleteMapping("/supp/{id}")
    public void deleteDvd(@PathVariable Long id){
        dvdStoreService.delete(id);
    }


    //Get by id
    //http://localhost:8080/dvds/dvd/3
    @GetMapping("/dvd/{id}")
    public DvdStoreRepositoryModel getDvdById(@PathVariable Long id){
        return dvdStoreService.findById(id);
    }

    //Update
    @PutMapping("/{id}")
    public DvdStoreRepositoryModel updateDvd(@PathVariable Long id, @RequestBody DvdStoreRepositoryModel dvd){
        return dvdStoreService.updateById(id,dvd);
    }


}

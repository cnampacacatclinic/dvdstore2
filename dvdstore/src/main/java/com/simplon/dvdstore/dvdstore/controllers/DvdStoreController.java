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

    //Dans le navigateur http://localhost:8080/dvds/home
    /*@GetMapping("/home")
    public ArrayList<DvdModelService> getAllDvds() {
        return dvdStoreService.findAll();
    }/**/

    @GetMapping("/home")
    public ArrayList<DvdStoreDto> getAllDvds() {
        return dvdStoreService.findAll();
    }

    // Ajouter un nouveau DVD grace  la methode save dans DvdStoreService
    @PostMapping("/add")
    public DvdStoreRepositoryModel addDvd(@RequestBody DvdStoreRepositoryModel dvd) {
        return dvdStoreService.save(dvd);
    }
    /////////////////*crud*////////////
    //@DeleteMapping


}

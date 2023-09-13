package com.simplon.dvdstore.dvdstore.controllers;

import ch.qos.logback.core.model.Model;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepository;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModel;
import com.simplon.dvdstore.dvdstore.services.DvdStoreService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController
public class DvdStoreController {
    @Autowired
    private DvdStoreService dvdStoreService;

    //Dans le navigateur http://localhost:8080/home
    @GetMapping("/home")
    public Iterable<DvdStoreRepositoryModel> getAllDvds() {
        return dvdStoreService.findAll();
    }

    // Ajouter un nouveau DVD grace  la methode save dans DvdStoreService
    @PostMapping("/add")
    public DvdStoreRepositoryModel addDvd(@RequestBody DvdStoreRepositoryModel dvd) {
        return dvdStoreService.save(dvd);
    }
    /////////////////*crud*////////////
}

package com.simplon.dvdstore.dvdstore.controllers;

import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModelCustomers;
import com.simplon.dvdstore.dvdstore.services.DvdStoreServiceCustomers;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("customer")
public class DvdStoreControllerCustomers {
    @Autowired
    private DvdStoreServiceCustomers dvdStoreService;

    // Ajouter un nouveau client
    @PostMapping("/")
    public DvdStoreRepositoryModelCustomers addDvd(@RequestBody DvdStoreRepositoryModelCustomers customer) {
        return dvdStoreService.save(customer);
    }


    //Afficher tous les clients
    @GetMapping("/")
    public ArrayList<DvdStoreDtoCustomers> getAllCustomers() {
        return dvdStoreService.findAll();
    }
}

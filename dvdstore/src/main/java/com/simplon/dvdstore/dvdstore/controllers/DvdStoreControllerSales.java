package com.simplon.dvdstore.dvdstore.controllers;

import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModelSales;
import com.simplon.dvdstore.dvdstore.services.DvdStoreServiceSales;
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
@RequestMapping("sales")
public class DvdStoreControllerSales {
    @Autowired
    private DvdStoreServiceSales dvdStoreService;

    // Ajouter une nouvelle vente
    @PostMapping("/")
    //public DvdStoreRepositoryModelSales addSales(@RequestBody DvdStoreDtoSales sale) {
    public DvdStoreRepositoryModelSales addSales(@RequestBody DvdStoreRepositoryModelSales sale) {
        return dvdStoreService.save(sale);
    }/**/

    @GetMapping("/")
    public ArrayList<DvdStoreDtoSales> getAllCustomers() {
        return dvdStoreService.findAll();
    }

    @DeleteMapping("/{id}")
    public boolean deleteDvd(@PathVariable Long id){
        return dvdStoreService.delete(id);
    }

}

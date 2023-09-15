package com.simplon.dvdstore.dvdstore.controllers;

import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModelSales;
import com.simplon.dvdstore.dvdstore.services.DvdStoreServiceSales;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("sale")
public class DvdStoreControllerSales {
    @Autowired
    private DvdStoreServiceSales dvdStoreService;

    // Ajouter une nouvelle vente
    @PostMapping("/")
    public DvdStoreRepositoryModelSales addSales(@RequestBody DvdStoreRepositoryModelSales sale) {
        return dvdStoreService.save(sale);
    }
}

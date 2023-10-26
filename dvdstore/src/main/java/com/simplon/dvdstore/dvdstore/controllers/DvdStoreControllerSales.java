package com.simplon.dvdstore.dvdstore.controllers;

import com.simplon.dvdstore.dvdstore.services.DvdModelServiceSales;
import com.simplon.dvdstore.dvdstore.services.DvdStoreServiceSales;
import com.simplon.dvdstore.dvdstore.services.ServiceMapper;
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
//@RequestMapping("api/sales")
@RequestMapping("sales")
public class DvdStoreControllerSales {
    @Autowired
    private DvdStoreServiceSales dvdStoreService;

    private ServiceMapper serviceMapper;

    // Ajouter une nouvelle vente
    @PostMapping("/")
    //On type boulean pour afficher true si la requette a réussi
    public boolean addSales(@RequestBody DvdStoreDtoSales sale) {//ici on reçoit un model du dto
        //Comme on reçoit un model Dto, on doit maintenant le transformer en model service
        DvdModelServiceSales dvdModelServiceSales = ServiceMapper.INSTANCE.dtoToServiceSale(sale);
        return dvdStoreService.save(dvdModelServiceSales);
    }

    @GetMapping("/")
    public ArrayList<DvdStoreDtoSales> getAllCustomers() {
        return dvdStoreService.findAll();
    }

    @DeleteMapping("/{id}")
    public boolean deleteDvd(@PathVariable Long id){
        return dvdStoreService.delete(id);
    }

    @PutMapping("/{id}")
    public boolean updateDvd(@PathVariable Long id, @RequestBody DvdStoreDtoSales sale) {
        // Créez un objet DvdModelServiceSales à partir des données de la requête
        DvdModelServiceSales dvdModelService = ServiceMapper.INSTANCE.dtoToServiceSale(sale);

        // Appelez la méthode de mise à jour dans le service
        return dvdStoreService.updateSale(id, dvdModelService);
    }

}

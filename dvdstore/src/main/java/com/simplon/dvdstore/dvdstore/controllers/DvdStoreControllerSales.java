package com.simplon.dvdstore.dvdstore.controllers;

import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModelSales;
import com.simplon.dvdstore.dvdstore.services.DvdModelServiceMovies;
import com.simplon.dvdstore.dvdstore.services.DvdModelServiceSales;
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
    //On type boulean pour afficher true si la requette a réussi
    public boolean addSales(@RequestBody DvdStoreDtoSales sale) {//ici on reçoit un model du dto
        //Comme on reçoit un model Dto, on doit maintenant le transformer en model service
        DvdModelServiceSales dvdModelServiceSales = new DvdModelServiceSales(
            //ici nous devons donner les renseignements suivants pour construire notre vente
            sale.customer_id(), sale.movie_id(),sale.quantityOfSales(), sale.date(), sale.total()
        );
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

    //Update
    /*@PutMapping("/{id}")
    public boolean updateDvd(@PathVariable Long id, @RequestBody DvdStoreDtoIdSales sale){
        DvdModelServiceSales dvdModelService = new DvdModelServiceSales(sale.id(), sale.customer_id(), sale.movie_id(),sale.quantityOfSales());
        return dvdStoreService.updateSale(id,dvdModelService);
    }/**/

    @PutMapping("/{id}")
    public boolean updateDvd(@PathVariable Long id, @RequestBody DvdModelServiceSales sale) {
        // Créez un objet DvdModelServiceSales à partir des données de la requête
        DvdModelServiceSales dvdModelService = new DvdModelServiceSales(
                sale.getCustomerId(), sale.getMovieId(), sale.getQuantityOfSales(), sale.getDate(), sale.getTotal()
        );

        // Appelez la méthode de mise à jour dans le service
        return dvdStoreService.updateSale(id, dvdModelService);
    }

}

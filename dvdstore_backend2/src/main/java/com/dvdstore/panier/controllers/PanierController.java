package com.dvdstore.panier.controllers;

import com.dvdstore.panier.repositories.PanierRepositoryModel;
import com.dvdstore.panier.services.PanierModelService;
import com.dvdstore.panier.services.PanierModelServiceID;
import com.dvdstore.panier.services.PanierService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractList;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("panier")
public class PanierController {
    @Autowired
    private PanierService service;


   @GetMapping("/")
   public AbstractList<PanierDto> getAllPanier() {
        return service.findAll();
    }/**/

    @GetMapping("/{id}")
    public PanierRepositoryModel getPanierById(@PathVariable Integer id){
        return service.findById(id);
    }

    @PostMapping("/")
    public boolean addPanier(@RequestBody PanierDtoId panier) {//ici on reçoit un model du dto
        //Comme on reçoit un model Dto, on doit maintenant le transformer en model service
        PanierModelServiceID panierService = new PanierModelServiceID(panier.id_panier(),panier.idClient(),panier.idDvd(),panier.prixUnitaire(),panier.total(),panier.date(),panier.quantity());
        return service.save(panierService);
    }

    @DeleteMapping("/{id}")
    public boolean deletePanier(@PathVariable Integer id){
        return service.delete(id);
    }

    @PutMapping("/{id}")
    public PanierRepositoryModel updatePanier(@PathVariable Integer id, @RequestBody PanierModelService panier){
        PanierModelService panierService = new PanierModelService(panier.getIdClient(), panier.getIdDvd(), panier.getPrixUnitaire(),panier.getTotal(),panier.getDate(),panier.getQuantity());
        return service.update(id,panierService);
    }

    //Utilise les procdures
    @PostMapping("/total")
    public boolean total() {
        return service.total();
    }

    @PostMapping("/supppanier")
    public boolean supppanier() {
        return service.supppanier();
    }

    /*@PostMapping("/solde")
    public boolean solde(float poucent) {
        return service.solde(poucent);
    }/**/
  @PostMapping("/solde")
  public boolean solde(@RequestBody Map<String, Float> request) {
      float pourcent = request.get("pourcent");
      return service.solde(pourcent);
  }
}

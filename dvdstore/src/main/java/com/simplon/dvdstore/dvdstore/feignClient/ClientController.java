package com.simplon.dvdstore.dvdstore.feignClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/client/controller")
public class ClientController {
    @Autowired
    private MicroServicePanier panier;

    @GetMapping("{id}")
    public PanierDtoId recupererUnProduit(@PathVariable Integer id) {
        return panier.findById(id);
    }

    @GetMapping("/")
    public List<PanierDto> affichePanier() {
        return panier.findAll();
    }

    @DeleteMapping("/{id}")
    public boolean deletePanier(@PathVariable Integer id){
        return panier.deletePanier(id);
    };

    @PostMapping("/")
    public boolean insertPanier(@RequestBody PanierDtoId panier2){
        return panier.save(panier2);
    }

    @PutMapping("/{id}")
    public PanierDtoId updateP(@PathVariable Integer id, @RequestBody PanierDtoId panier2){
        return panier.update(id,panier2);
    };

    @PostMapping("/total")
    public boolean total() {
        return panier.total();
    }

    @PostMapping("/supppanier")
    public boolean supppanier() {
        return panier.supppanier();
    }
}
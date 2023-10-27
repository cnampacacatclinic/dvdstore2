package com.simplon.dvdstore.dvdstore.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "microservice-produits", url = "http://localhost:9001/panier")
public interface MicroServicePanier {

    PanierDto panier = null;

    @GetMapping("{id}")
    PanierDtoId findById(@PathVariable Integer id);

    @GetMapping("/")
    List<PanierDtoId> findAll();

    @DeleteMapping("/{id}")
    public boolean deletePanier(@PathVariable Integer id);

    @PostMapping("/")
    public boolean save(@RequestBody PanierDtoId panier);

    @PutMapping("/{id}")
    public PanierDtoId update(@PathVariable Integer id, @RequestBody PanierDtoId panier);

    @PostMapping("/total")
    public boolean total();

    @PostMapping("/supppanier")
    public boolean supppanier();

}
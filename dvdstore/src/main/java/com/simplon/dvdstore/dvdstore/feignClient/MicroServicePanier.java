package com.simplon.dvdstore.dvdstore.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-produits", url = "http://localhost:9001/panier")
public interface MicroServicePanier {

    @GetMapping("{id}")
    PanierDtoId findById(@PathVariable Integer id);

    @GetMapping("/")
    List<PanierDto> findAll();
}
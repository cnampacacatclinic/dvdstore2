package com.simplon.dvdstore.dvdstore.feignClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
package com.dvdstore.panier.controllers;

import com.dvdstore.panier.services.PanierService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController
public class PanierController {
    @Autowired
    private PanierService service;
}

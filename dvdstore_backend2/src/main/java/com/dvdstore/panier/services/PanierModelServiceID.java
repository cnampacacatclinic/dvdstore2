package com.dvdstore.panier.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PanierModelServiceID {

    private Integer id_panier;
    private Integer idClient;
    private Integer idDvd;
    private float prixUnitaire;
    private float total;
    private Date date;
    private Integer quantity;

}

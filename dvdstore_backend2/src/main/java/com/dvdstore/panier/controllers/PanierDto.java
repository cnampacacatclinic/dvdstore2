package com.dvdstore.panier.controllers;

import java.util.Date;

public record PanierDto(Long idClient,Long idDvd,float prixUnitaire,float total,Date date,Long quantity) {
}

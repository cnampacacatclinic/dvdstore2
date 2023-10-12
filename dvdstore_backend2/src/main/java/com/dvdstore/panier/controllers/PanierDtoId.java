package com.dvdstore.panier.controllers;

import java.util.Date;

public record PanierDtoId(Long id_panier,Long idClient, Long idDvd, float prixUnitaire, float total, Date date, Long quantity) {
}

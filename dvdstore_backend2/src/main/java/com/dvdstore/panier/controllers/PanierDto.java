package com.dvdstore.panier.controllers;

import java.util.Date;

public record PanierDto(Integer idClient, Integer idDvd, float prixUnitaire, float total, Date date, Integer quantity) {
}

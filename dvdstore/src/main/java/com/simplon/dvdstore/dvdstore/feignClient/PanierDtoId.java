package com.simplon.dvdstore.dvdstore.feignClient;

import java.util.Date;

public record PanierDtoId(Integer id_panier, Integer idClient, Integer idDvd, float prixUnitaire, float total, Date date, Integer quantity) {
}

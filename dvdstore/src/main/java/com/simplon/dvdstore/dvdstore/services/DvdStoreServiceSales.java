package com.simplon.dvdstore.dvdstore.services;

import com.simplon.dvdstore.dvdstore.controllers.DvdStoreDtoSales;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryInterfaceSales;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModelSales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DvdStoreServiceSales {
    @Autowired
    private DvdStoreRepositoryInterfaceSales dvdStoreRepository;

    //Insertion en BDD d'une vente
    public DvdStoreRepositoryModelSales save(DvdStoreRepositoryModelSales sale) {
        return dvdStoreRepository.save(sale);
    }

    //afficher toutes les ventes
   /*public ArrayList<DvdStoreDtoSales> findAll() {
        ArrayList<DvdStoreRepositoryModelSales> salesList = dvdStoreRepository.findAll();
        ArrayList<DvdStoreDtoSales> salesDtoList = new ArrayList<>();

        for(DvdStoreRepositoryModelSales ee : salesList){
            DvdStoreDtoSales salesDto = new DvdStoreDtoSales(ee.getFKUsers(),ee.getFKMovies(),ee.getQuantityOfSales(),ee.getDate());
            salesDtoList.add(salesDto);
        }

        return salesDtoList;
    }/**/
}

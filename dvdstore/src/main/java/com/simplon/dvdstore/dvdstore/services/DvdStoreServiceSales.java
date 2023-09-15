package com.simplon.dvdstore.dvdstore.services;

import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryInterfaceSales;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModelSales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DvdStoreServiceSales {
    @Autowired
    private DvdStoreRepositoryInterfaceSales dvdStoreRepository;

    //Insertion en BDD d'une vente
    public DvdStoreRepositoryModelSales save(DvdStoreRepositoryModelSales sale) {
        return dvdStoreRepository.save(sale);
    }
}

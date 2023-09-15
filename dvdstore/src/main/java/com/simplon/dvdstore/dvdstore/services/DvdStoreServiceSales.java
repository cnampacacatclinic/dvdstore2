package com.simplon.dvdstore.dvdstore.services;

import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryInterfaceSales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DvdStoreServiceSales {
    @Autowired
    private DvdStoreRepositoryInterfaceSales dvdStoreRepository;
}
